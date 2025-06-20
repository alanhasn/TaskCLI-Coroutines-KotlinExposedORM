package data

// Imports
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import models.TaskDTO
import models.Tasks
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

object TaskDao {

    // INSERT: Create a new task in the database
    suspend fun insertTask(title: String, description: String) = withContext(Dispatchers.IO) {
        transaction {
            Tasks.insert {
                it[Tasks.title] = title
                it[Tasks.description] = description
                it[Tasks.isCompleted] = false
            }
        }
    }

    // SELECT ALL: Return all tasks as a list of TaskDTO
    suspend fun getAllTasks(): List<TaskDTO> = withContext(Dispatchers.IO) {
        transaction {
            Tasks.selectAll().map {
                TaskDTO(
                    id = it[Tasks.id],
                    title = it[Tasks.title],
                    description = it[Tasks.description],
                    isCompleted = it[Tasks.isCompleted]
                )
            }
        }
    }

    // SELECT BY ID: Get a single task by its ID
    suspend fun getTaskById(id: Int): TaskDTO? = withContext(Dispatchers.IO) {
        transaction {
            Tasks.selectAll().where { Tasks.id eq id }
                .map {
                    TaskDTO(
                        id = it[Tasks.id],
                        title = it[Tasks.title],
                        description = it[Tasks.description],
                        isCompleted = it[Tasks.isCompleted]
                    )
                }
                .singleOrNull()
        }
    }

    // UPDATE: Update a task by ID with new values
    suspend fun updateTask(id: Int, newTitle: String, newDescription: String, isCompleted: Boolean): Boolean = withContext(Dispatchers.IO) {
        transaction {
            Tasks.update({ Tasks.id eq id }) {
                it[title] = newTitle
                it[description] = newDescription
                it[Tasks.isCompleted] = isCompleted
            } > 0 // returns true if a row was updated
        }
    }

    // DELETE: Remove a task by ID
    suspend fun deleteTask(id: Int): Boolean = withContext(Dispatchers.IO) {
        transaction {
            Tasks.deleteWhere { Tasks.id eq id } > 0
        }
    }

    // SELECT INCOMPLETE: Get all tasks that are not yet completed
    suspend fun getIncompleteTasks(): List<TaskDTO> = withContext(Dispatchers.IO) {
        transaction {
            Tasks.selectAll().where { Tasks.isCompleted eq false }.map {
                TaskDTO(
                    id = it[Tasks.id],
                    title = it[Tasks.title],
                    description = it[Tasks.description],
                    isCompleted = it[Tasks.isCompleted]
                )
            }
        }
    }
}
