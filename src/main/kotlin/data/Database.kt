package data

import org.jetbrains.exposed.sql.Database

// Connect to SQLite database via JDBC Driver
object DatabaseFactory{
    fun init(){
        Database.connect("jdbc:sqlite:tasks.db" , driver = "org.sqlite.JDBC")
    }
}