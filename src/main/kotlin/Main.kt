

import data.DatabaseFactory
import data.Schema
import data.TaskDao
import kotlinx.coroutines.runBlocking

fun main()  {
    DatabaseFactory.init() // Connect to the database
    Schema.createTables() // Create Tables

    runBlocking {
        TaskDao.getAllTasks()
    }
}
