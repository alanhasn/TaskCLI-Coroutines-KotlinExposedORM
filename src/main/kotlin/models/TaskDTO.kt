package models

// This is the DTO class to represent a Task as a plain data object
data class TaskDTO(
    val id: Int,
    val title: String,
    val description: String,
    val isCompleted: Boolean
)
