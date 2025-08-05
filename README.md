# 🎓 Student Management System

![Java](https://img.shields.io/badge/Java-11-blue.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.7.18-brightgreen.svg)
![Maven](https://img.shields.io/badge/Build-Maven-red.svg)
![License](https://img.shields.io/badge/License-MIT-yellow.svg)

A modern, web-based Student Management System built with Spring Boot, featuring a stunning, animated UI. This application allows you to manage student records with full CRUD (Create, Read, Update, Delete) operations through an intuitive and responsive web interface.

---

## ✨ Features

-   **Full CRUD Functionality**: Create, Read, Update, and Delete student records.
-   **Stunning UI**: A beautiful, animated interface with floating backgrounds, gradient effects, and smooth transitions.
-   **Real-time Search**: Instantly find students by their roll number.
-   **Responsive Design**: A fully responsive layout that works on all devices, built with Bootstrap 5.
-   **Data Persistence**: Student data is stored locally in a simple and portable CSV file.
-   **Intuitive Forms**: Easy-to-use forms for adding and editing student information.
-   **User Feedback**: Clear success and error notifications for all actions.

---

## 🛠️ Tech Stack

| Category      | Technology                                       |
| ------------- | ------------------------------------------------ |
| **Backend**   | Spring Boot 2.7.18, Spring Web                   |
| **Frontend**  | Thymeleaf, Bootstrap 5, Font Awesome, Google Fonts |
| **Build Tool**| Maven                                            |
| **Java**      | JDK 11                                           |
| **Data**      | File-based CSV Storage                           |

---

## 🚀 Getting Started

### Prerequisites

-   Java JDK 11 or higher
-   Apache Maven 3.6 or higher (or use the included Maven Wrapper)

### Installation & Running

1.  **Clone the repository:**
    ```sh
    git clone <repository-url>
    cd StudentManagementSystem
    ```

2.  **Run the application (choose one method):**

    *   **Method 1: Using Maven Wrapper (Recommended)**
        This is the easiest way to run the application, as it uses the specific Maven version defined in the project.

        *On Windows (Command Prompt):*
        ```cmd
        .\mvnw.cmd spring-boot:run
        ```
        *On Windows (PowerShell):*
        ```powershell
        .\mvnw.cmd spring-boot:run
        ```
        *On Linux/macOS:*
        ```sh
        ./mvnw spring-boot:run
        ```

    *   **Method 2: Using Scripts**
        Convenience scripts are provided to run the application.

        *On Windows (Command Prompt):*
        ```cmd
        .\run.bat
        ```
        *On Windows (PowerShell):*
        ```powershell
        .\run.ps1
        ```

    *   **Method 3: Manual Build and Run**
        If you prefer to build the project manually first.

        *Build the JAR:*
        ```sh
        mvn clean install
        ```
        *Run the JAR:*
        ```sh
        java -jar target/student-management-system-1.0.0.jar
        ```

3.  **Access the application:**
    Once the application is running, open your web browser and navigate to:
    **[http://localhost:8080](http://localhost:8080)**

---

## 📁 Project Structure

```
StudentManagementSystem/
├── 📄 pom.xml                           # Maven configuration file
├── 📄 mvnw                                # Maven wrapper for Linux/macOS
├── 📄 mvnw.cmd                          # Maven wrapper for Windows
├── 📄 run.bat                           # Batch script to start application
├── 📄 run.ps1                           # PowerShell script to start application
├── 📂 .mvn/                              # Maven wrapper support files
├── 📂 data/
│   └── 📄 students.txt                  # CSV file storing student data
└── 📂 src/
    └── 📂 main/
        ├── 📂 java/
        │   └── 📂 com/studentmanagement/
        │       ├── 📄 StudentManagementApplication.java    # Main Spring Boot class
        │       ├── 📂 controller/
        │       │   └── 📄 StudentController.java           # Web controller for HTTP requests
        │       ├── 📂 model/
        │       │   └── 📄 Student.java                     # Student entity class
        │       ├── 📂 service/
        │       │   └── 📄 StudentService.java              # Business logic service
        │       └── 📂 util/
        │           └── 📄 FileUtil.java                    # File operations utility
        └── 📂 resources/
            ├── 📄 application.properties                       # Application configuration
            └── 📂 templates/
                ├── 📄 index.html                               # Main dashboard page
                ├── 📄 add-student.html                         # Add student form
                ├── 📄 edit-student.html                        # Edit student form
                └── 📄 search-result.html                       # Search results page
```

---

## 🔌 API Endpoints

| Method | Endpoint              | Description                      |
| ------ | --------------------- | -------------------------------- |
| `GET`  | `/`                   | Displays the home page with all students. |
| `GET`  | `/add`                | Shows the form to add a new student. |
| `POST` | `/add`                | Submits the new student data.    |
| `GET`  | `/edit/{roll}`        | Shows the form to edit a student. |
| `POST` | `/edit`               | Submits the updated student data. |
| `GET`  | `/delete/{roll}`      | Deletes a student by roll number. |
| `GET`  | `/search?roll={roll}` | Searches for a student by roll number. |

---

## 🆘 Troubleshooting

-   **Port 8080 in use**: If another application is using port 8080, you can change it by editing `src/main/resources/application.properties` and setting `server.port` to a different value (e.g., `server.port=8081`).
-   **PowerShell Execution Policy Error**: If you cannot run `run.ps1`, open PowerShell as an administrator and run:
    ```powershell
    Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser
    ```
-   **Java/Maven not found**: Ensure that Java and Maven are installed correctly and that their `bin` directories are included in your system's `PATH` environment variable.

---

## 📈 Future Enhancements

-   [ ] **Database Integration**: Replace file storage with a relational database like MySQL or PostgreSQL.
-   [ ] **User Authentication**: Add login/logout functionality with Spring Security.
-   [ ] **Advanced Reporting**: Implement features to generate and export student reports.
-   [ ] **RESTful API**: Develop a more comprehensive REST API for headless

---

## 📜 License

This project is licensed under the MIT License.
