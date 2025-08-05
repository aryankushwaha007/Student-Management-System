@echo off
echo Starting Student Management System Web Application...
echo.
echo Make sure you have Java 11+ installed on your system.
echo.

if not exist "target" (
    echo Building the application...
    .\mvnw.cmd clean install
)

echo Starting the web application...
.\mvnw.cmd spring-boot:run

echo.
echo The application will be available at: http://localhost:8080
pause
