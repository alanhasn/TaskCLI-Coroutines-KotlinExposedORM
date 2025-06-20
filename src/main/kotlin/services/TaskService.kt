package services

import data.TaskDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object TaskService {

    // Add a task after validating title and description
    suspend fun addTask(title: String, description: String): Boolean = withContext(Dispatchers.IO) {
        if (title.isBlank()) {
            println("The title cannot be blank.")
            return@withContext false
        }

        if (description.isBlank()) {
            println("The description cannot be blank.")
            return@withContext false
        }

        val result = TaskDao.insertTask(title, description)
        if (result) println("Task added successfully!")
        result
    }

    // Show all tasks in a readable format
    suspend fun showAllTasks() = withContext(Dispatchers.IO) {
        val allTasks = TaskDao.getAllTasks()
        if (allTasks.isEmpty()) {
            println("There are no tasks to show.")
        } else {
            println("======= All Tasks =====")
            for (task in allTasks) {
                println(
                        "ID: ${task.id}\n" +
                        "Title: ${task.title}\n" +
                        "Description: ${task.description}\n" +
                        "Completed: ${task.isCompleted}\n"
                )
            }
        }
    }

    // Get a task by ID and display it
    suspend fun getTaskByID(id: Int) = withContext(Dispatchers.IO) {
        if (id <= 0) {
            println("Please enter a valid task ID (greater than 0).")
            return@withContext
        }

        val task = TaskDao.getTaskById(id)
        if (task != null) {
            println("Task Found:")
            println("ID: ${task.id}")
            println("Title: ${task.title}")
            println("Description: ${task.description}")
            println("Completed: ${task.isCompleted}")
        } else {
            println("Task with ID $id not found.")
        }
    }

    // Update a task with new values
    suspend fun updateTask(id: Int, newTitle: String, newDescription: String, isCompleted: Boolean) = withContext(Dispatchers.IO) {
        val updated = TaskDao.updateTask(id, newTitle, newDescription, isCompleted)
        if (updated) {
            println("Task updated successfully!")
        } else {
            println("Failed to update task. Check if ID $id exists.")
        }
    }

    // Delete a task by ID
    suspend fun deleteTask(id: Int) = withContext(Dispatchers.IO) {
        if (id <= 0) {
            println("Please enter a valid task ID.")
            return@withContext
        }

        val deleted = TaskDao.deleteTask(id)
        if (deleted) {
            println("Task deleted successfully.")
        } else {
            println("Task with ID $id not found.")
        }
    }

    // Show only incomplete (not yet done) tasks
    suspend fun getIncompleteTasks() = withContext(Dispatchers.IO) {
        val incompleteTasks = TaskDao.getIncompleteTasks()
        if (incompleteTasks.isEmpty()) {
            println("No incomplete tasks. All caught up!")
        } else {
            println("Incomplete Tasks:")
            for (task in incompleteTasks) {
                println("[${task.id}] ${task.title} – ${task.description}")
            }
        }
    }
}
