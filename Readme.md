# 📝 TaskCLI - Kotlin Coroutines + Exposed ORM

A clean and modular **Task Management CLI application** built using **Kotlin**, **Coroutines**, and **Exposed ORM**, with a focus on good architecture and best practices.

---

## 📖 Description

TaskCLI is a terminal-based application that allows users to manage their personal tasks using a simple and interactive command-line interface. It supports full CRUD operations and stores data using an embedded SQLite database.

This project serves as a hands-on example to practice:
- Kotlin OOP (Object-Oriented Programming)
- Asynchronous programming with Kotlin Coroutines
- Exposed ORM (Database abstraction layer)
- Clean separation of layers: UI / Service / DAO
- Terminal-based UI interaction

---

## 🚀 Features

-  Add, update, delete, and list tasks
-  Search for task by ID
-  Filter incomplete tasks
-  SQLite persistence using Exposed ORM
-  Asynchronous non-blocking database operations using coroutines
-  Clean architecture (Separation of concerns)

---

## 🧠 Principles Applied

This project is structured around the following software design principles:

- **Separation of Concerns (SoC)**  
  → The app is divided into clear layers:  
  `UI` → `Service` → `DAO` → `Database`

- **Single Responsibility Principle (SRP)**  
  → Each class/object handles one specific concern only.

- **Asynchronous IO**  
  → All database access is performed using `Dispatchers.IO` for non-blocking behavior.

- **DTO Pattern**  
  → Separates domain logic from database representation.

---

## 🛠 Technologies Used

| Tool / Library        | Purpose                              |
|-----------------------|--------------------------------------|
| [Kotlin](https://kotlinlang.org/) | Main programming language |
| [SQLite](https://www.sqlite.org/index.html) | Embedded database |
| [Exposed ORM](https://github.com/JetBrains/Exposed) | Kotlin ORM for SQL access |
| [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) | Asynchronous programming |
| IntelliJ IDEA         | Development IDE                      |
| Gradle                | Build system                         |

---

## 🧪 How to Run

```bash

# Clone the repository
# Open in IntelliJ and run Main.kt file
git clone https://github.com/alanhasn/TaskCLI-Coroutines-KotlinExposedORM.git
````

> Make sure you have **JDK 17+** installed.

---

## 📂 Project Structure

```
├── data/            # Exposed DAO and DB schema setup
├── models/          # Task entity and DTO
├── services/        # Business logic layer
├── ui/              # Console UI (CLI)
├── Main.kt          # Entry point
├── build.gradle.kts
└── README.md
```

---

## 👨‍💻 Author

**[Alan](https://github.com/alanhasn)**
Passionate about clean code, security, and backend development with Django & Kotlin.

---

## 📄 License

This project is open-source and free to use under the MIT License.

