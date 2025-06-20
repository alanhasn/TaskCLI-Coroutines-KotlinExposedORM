

import data.DatabaseFactory
import data.Schema
import ui.ConsoleUI
fun main()  {
    DatabaseFactory.init() // Connect to the database
    Schema.createTables() // Create Tables

    // Start the UI interface
    ConsoleUI.start()

}
