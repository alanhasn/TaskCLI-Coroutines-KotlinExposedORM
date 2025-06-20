package ui

import kotlinx.coroutines.runBlocking
import services.TaskService

object ConsoleUI {

    // Show the menu options to the user
    private fun menu() {
        println(
            """
            📋 === Task Manager Menu ===
            [1] ➤ Add a new task
            [2] ➤ Show all tasks
            [3] ➤ Show task by ID
            [4] ➤ Update a task
            [5] ➤ Delete a task
            [6] ➤ Show incomplete tasks
            [0] ➤ Exit
            """.trimIndent()
        )
        print("Choose an option: ")
    }

    // Handle the user's input and call the appropriate service functions
    private fun conditions() = runBlocking {
        var isRunning = true

        while (isRunning) {
            menu()
            when (readlnOrNull()?.trim()) {
                "1" -> {
                    println("➤ Enter task title:")
                    val title = readlnOrNull()?.trim() ?: ""
                    println("➤ Enter task description:")
                    val desc = readlnOrNull()?.trim() ?: ""
                    TaskService.addTask(title, desc)
                }

                "2" -> {
                    println()
                    TaskService.showAllTasks()
                }

                "3" -> {
                    println("➤ Enter task ID:")
                    val id = readlnOrNull()?.toIntOrNull() ?: -1
                    TaskService.getTaskByID(id)
                }

                "4" -> {
                    println("➤ Enter task ID to update:")
                    val id = readlnOrNull()?.toIntOrNull() ?: -1

                    println("➤ New title:")
                    val newTitle = readlnOrNull()?.trim() ?: ""

                    println("➤ New description:")
                    val newDesc = readlnOrNull()?.trim() ?: ""

                    println("➤ Is completed? (true/false):")
                    val isCompleted = readlnOrNull()?.toBooleanStrictOrNull() ?: false

                    TaskService.updateTask(id, newTitle, newDesc, isCompleted)
                }

                "5" -> {
                    println("➤ Enter task ID to delete:")
                    val id = readlnOrNull()?.toIntOrNull() ?: -1
                    TaskService.deleteTask(id)
                }

                "6" -> {
                    TaskService.getIncompleteTasks()
                }

                "0" -> {
                    println("👋 Exiting the program. Goodbye!")
                    isRunning = false
                }

                else -> {
                    println("❌ Invalid option. Please try again.")
                }
            }

            // Add a line between operations for better readability
            println("\n-------------------------\n")
        }
    }

    // Start the CLI interface
    fun start() {
        println("🚀 Welcome to Kotlin Task Manager CLI!")
        conditions()
    }
}
