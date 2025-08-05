# 🎓 Student Management System - Complete Guide

## 🌟 Overview
A modern, web-based Student Management System built with Spring Boot and featuring a stunning, animated UI. This application allows you to manage student records with full CRUD (Create, Read, Update, Delete) operations through an intuitive web interface.

---

## 🚀 How to Start the Application

### Method 1: Using Maven Wrapper (Recommended)
```powershell
.\mvnw.cmd spring-boot:run
```

### Method 2: Using Run Scripts
```powershell
# For PowerShell
.\run.ps1

# For Command Prompt
.\run.bat
```

### Method 3: Using Java directly (if compiled)
```powershell
java -jar target/student-management-system-1.0.0.jar
```

---

## 🌐 Accessing the Application

Once started, the application will be available at:
**http://localhost:8080**

The application runs on port 8080 by default. You'll see a beautiful, animated interface with:
- 🎨 Floating background animations
- 📊 Statistics cards showing total students
- 🔍 Real-time search functionality
- ✨ Smooth hover effects and transitions
- 📱 Fully responsive design

---

## 🛠️ Tech Stack & Dependencies

### **Backend Framework**
- **Spring Boot 2.7.18** - Main application framework
- **Spring Web** - Web MVC and REST capabilities
- **Spring Boot DevTools** - Development tools for hot reload

### **Frontend Technologies**
- **Thymeleaf** - Server-side templating engine
- **Bootstrap 5.1.3** - CSS framework for responsive design
- **Font Awesome 6.0.0** - Icon library
- **Google Fonts (Poppins)** - Modern typography
- **Custom CSS3** - Advanced animations and effects

### **Build Tools**
- **Maven** - Dependency management and build automation
- **Maven Wrapper** - Ensures consistent Maven version across environments

### **Data Storage**
- **File-based CSV** - Simple file storage for student data
- **Custom FileUtil** - File operations utility

### **Java Version**
- **Java 11** - Runtime environment

---

## 📁 Project Structure

```
StudentManagementSystem/
├── 📄 pom.xml                           # Maven configuration file
├── 📄 mvnw.cmd                          # Maven wrapper for Windows
├── 📄 run.bat                           # Batch script to start application
├── 📄 run.ps1                           # PowerShell script to start application
├── 📄 README.md                         # This documentation file
├── 📂 data/
│   └── 📄 students.txt                  # CSV file storing student data
├── 📂 src/
│   └── 📂 main/
│       ├── 📂 java/
│       │   └── 📂 com/
│       │       └── 📂 studentmanagement/
│       │           ├── 📄 StudentManagementApplication.java    # Main Spring Boot class
│       │           ├── 📂 controller/
│       │           │   └── 📄 StudentController.java           # Web controller for HTTP requests
│       │           ├── 📂 model/
│       │           │   └── 📄 Student.java                     # Student entity class
│       │           ├── 📂 service/
│       │           │   └── 📄 StudentService.java              # Business logic service
│       │           └── 📂 util/
│       │               └── 📄 FileUtil.java                    # File operations utility
│       └── 📂 resources/
│           ├── 📄 application.properties                       # Application configuration
│           └── 📂 templates/
│               ├── 📄 index.html                               # Main dashboard page
│               ├── 📄 add-student.html                         # Add student form
│               ├── 📄 edit-student.html                        # Edit student form
│               └── 📄 search-result.html                       # Search results page
└── 📂 target/                                                  # Compiled classes and build artifacts
```

---

## 🎯 Features & Functionality

### **Dashboard (index.html)**
- 📊 Statistics overview with total student count
- 🎨 Animated floating shapes background
- 🔍 Quick search by roll number
- 📋 Student list with color-coded grades
- ✨ Hover effects on table rows
- 🎭 Gradient animations on title

### **Student Operations**
1. **Add Student** - Create new student records with name, roll number, and grade
2. **Edit Student** - Update existing student information
3. **Delete Student** - Remove students with confirmation dialog
4. **Search Student** - Find students by roll number

### **UI Enhancements**
- 🌈 Gradient backgrounds with fixed attachment
- 💫 Shimmer effects on containers
- 🎪 Button hover animations with scale and shadow effects
- 📱 Responsive design for all screen sizes
- 🎨 Color-coded grade badges (A+/A: Green, B+/B: Warning, Others: Gray)
- ⚡ Loading animations on button clicks
- 🔔 Auto-dismissing success/error alerts

---

## 🔧 Configuration Details

### **Application Properties**
- Server port: 8080 (default)
- Context path: / (root)
- Thymeleaf cache: Disabled for development

### **Maven Dependencies**
- Spring Boot Starter Web
- Spring Boot Starter Thymeleaf
- Spring Boot DevTools
- Spring Boot Starter Test

---

## 📝 Development Notes

### **File Storage Format**
Student data is stored in `data/students.txt` using CSV format:
```
rollNumber,name,grade
101,John Doe,A+
102,Jane Smith,B
```

### **MVC Architecture**
- **Model**: `Student.java` - Data representation
- **View**: HTML templates with Thymeleaf
- **Controller**: `StudentController.java` - Request handling

### **Service Layer**
- `StudentService.java` handles business logic
- `FileUtil.java` manages file operations
- Separation of concerns maintained

---

## 🎨 UI Design Features

### **Color Scheme**
- Primary gradient: Purple to blue (#667eea → #764ba2)
- Success: Green gradients
- Warning: Orange gradients
- Danger: Pink/red gradients

### **Animations**
- Floating shapes with infinite loop
- Gradient color cycling on title
- Shimmer effects on containers
- Button hover with translate and scale
- Table row hover effects

### **Typography**
- Font family: Poppins (Google Fonts)
- Weights: 300, 400, 500, 600, 700
- Icon integration with Font Awesome

---

## 🚀 Getting Started Checklist

1. ✅ Ensure Java 11 is installed
2. ✅ Navigate to project directory
3. ✅ Run `.\mvnw.cmd spring-boot:run`
4. ✅ Open browser to `http://localhost:8080`
5. ✅ Start managing students!

---

## 🆘 Troubleshooting

### **Common Issues**
- **Port 8080 in use**: Stop other applications or change port in application.properties
- **Java version mismatch**: Ensure Java 11 is active
- **Maven wrapper issues**: Use `.\mvnw.cmd clean compile` first
- **File permissions**: Ensure data directory is writable

### **PowerShell Execution Policy**
If you encounter execution policy errors:
```powershell
Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser
```

---

## 📈 Future Enhancements

- 🗄️ Database integration (MySQL/PostgreSQL)
- 🔐 User authentication and authorization
- 📊 Advanced reporting and analytics
- 📧 Email notifications
- 📱 Mobile app integration
- 🔄 Real-time updates with WebSocket

---

**Created with ❤️ using Spring Boot and modern web technologies**
