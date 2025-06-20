package models

import org.jetbrains.exposed.sql.Table

// Tasks model using Exposed ORM

object Tasks:Table("tasks"){

    val id = integer("id").autoIncrement()
    val title = varchar("title",250)
    val description = text("description")
    val isCompleted = bool("completed").default(false)

    override val primaryKey = PrimaryKey(id)
}