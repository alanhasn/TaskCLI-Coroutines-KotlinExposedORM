package ui

import kotlinx.coroutines.runBlocking
import services.TaskService

object ConsoleUI {

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

    // Safe input for Int with retry
    private fun readInt(prompt: String): Int {
        while (true) {
            print(prompt)
            val input = readln().trim()
            val number = input.toIntOrNull()
            if (number != null) return number
            println("❌ Please enter a valid number.")
        }
    }

    // Safe input for Boolean with retry
    private fun readBoolean(prompt: String): Boolean {
        while (true) {
            print(prompt)
            val input = readln().trim()
            when (input.lowercase()) {
                "true" -> return true
                "false" -> return false
                else -> println("❌ Please enter 'true' or 'false'.")
            }
        }
    }

    // General input for non-empty strings
    private fun readText(prompt: String): String {
        while (true) {
            print(prompt)
            val input = readln().trim()
            if (input.isNotEmpty()) return input
            println("❌ Input cannot be empty.")
        }
    }

    private fun conditions() = runBlocking {
        var isRunning = true

        while (isRunning) {
            menu()
            val choice = readln().trim()

            when (choice) {
                "1" -> {
                    val title = readText("➤ Enter task title: ")
                    val description = readText("➤ Enter task description: ")
                    TaskService.addTask(title, description)
                }

                "2" -> TaskService.showAllTasks()

                "3" -> {
                    val id = readInt("➤ Enter task ID: ")
                    TaskService.getTaskByID(id)
                }

                "4" -> {
                    val id = readInt("➤ Enter task ID to update: ")
                    val newTitle = readText("➤ New title: ")
                    val newDescription = readText("➤ New description: ")
                    val isCompleted = readBoolean("➤ Is completed? (true/false): ")
                    TaskService.updateTask(id, newTitle, newDescription, isCompleted)
                }

                "5" -> {
                    val id = readInt("➤ Enter task ID to delete: ")
                    TaskService.deleteTask(id)
                }

                "6" -> TaskService.getIncompleteTasks()

                "0" -> {
                    println("👋 Exiting the program. Goodbye!")
                    isRunning = false
                }

                else -> println("❌ Invalid option. Please try again.")
            }

            println("\n-------------------------\n")
        }
    }

    fun start() {
        println("🚀 Welcome to Kotlin Task Manager CLI!")
        conditions()
    }
}
