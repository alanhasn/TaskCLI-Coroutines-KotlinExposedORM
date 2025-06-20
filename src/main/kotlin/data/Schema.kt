package data

import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import models.Tasks

object Schema{
    fun createTables(){
        transaction{
            SchemaUtils.create(Tasks)
        }
    }
}
