# PowerShell script to compile and run TDD tests and SLF4J logging

$ErrorActionPreference = "Stop"

Write-Host "=== Compiling TDD and Logging Projects ===" -ForegroundColor Cyan

# Clean and recreate bin directory
if (Test-Path bin) {
    Remove-Item bin -Recurse -Force
}
New-Item -ItemType Directory -Path bin -Force | Out-Null

# Classpath for compilation
$compileCp = "lib/junit-platform-console-standalone-1.10.1.jar;lib/mockito-core-5.8.0.jar;lib/slf4j-api-1.7.36.jar"

# Find all Java source files
$sources = Get-ChildItem -Path src -Filter *.java -Recurse | Select-Object -ExpandProperty FullName

# Compile Java files
javac -cp $compileCp -d bin -sourcepath src $sources

Write-Host "Compilation successful!`n" -ForegroundColor Green

Write-Host "=== Running JUnit 5 and Mockito Tests ===" -ForegroundColor Cyan

# Classpath for running tests (include compiled classes, mockito, byte buddy, and objenesis)
$runCp = "bin;lib/mockito-core-5.8.0.jar;lib/byte-buddy-1.14.10.jar;lib/byte-buddy-agent-1.14.10.jar;lib/objenesis-3.3.jar"

$env:MSYS_NO_PATHCONV = 1

# Run tests using the Standalone Console Launcher
java "-Dnet.bytebuddy.experimental=true" -jar lib/junit-platform-console-standalone-1.10.1.jar --class-path $runCp --select-package com.example.tdd.junit --select-package com.example.tdd.mockito

Write-Host "`n=== Running SLF4J Logging Demonstration ===" -ForegroundColor Cyan

# Classpath for running SLF4J example (include bin, slf4j, logback-classic, logback-core, and current dir for logback.xml)
$logCp = "bin;lib/slf4j-api-1.7.36.jar;lib/logback-classic-1.2.11.jar;lib/logback-core-1.2.11.jar;."

java -cp $logCp com.example.logging.LoggingExample

Write-Host "`nAll TDD and Logging demonstrations completed." -ForegroundColor Green
