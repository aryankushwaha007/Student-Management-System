# Student Management System - PowerShell Launcher
Write-Host "Starting Student Management System Web Application..." -ForegroundColor Green
Write-Host ""
Write-Host "Using Maven Wrapper - no need to install Maven separately!" -ForegroundColor Yellow
Write-Host ""

# Check if Java is available
$javaCheck = Get-Command java -ErrorAction SilentlyContinue
if (-not $javaCheck) {
    Write-Host "ERROR: Java not found! Please install Java 11+ and add it to your PATH." -ForegroundColor Red
    Write-Host "Download Java from: https://adoptium.net/" -ForegroundColor Yellow
    Read-Host "Press Enter to exit"
    exit 1
}

# Build and run the application
Write-Host "Building and starting the application..." -ForegroundColor Blue
try {
    & .\mvnw.cmd clean spring-boot:run
} catch {
    Write-Host "Error starting the application: $_" -ForegroundColor Red
    Read-Host "Press Enter to exit"
    exit 1
}

Write-Host ""
Write-Host "The application will be available at: http://localhost:8080" -ForegroundColor Green
Read-Host "Press Enter to exit"
