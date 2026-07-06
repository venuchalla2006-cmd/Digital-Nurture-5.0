# PowerShell script to compile and run Design Patterns
$ErrorActionPreference = "Stop"
Write-Host "=== Compiling Design Patterns ===" -ForegroundColor Cyan
if (Test-Path bin) { Remove-Item bin -Recurse -Force }
New-Item -ItemType Directory -Path bin -Force | Out-Null
$sources = Get-ChildItem -Path src -Filter *.java -Recurse | Select-Object -ExpandProperty FullName
javac -d bin -sourcepath src $sources
Write-Host "Compilation successful!\n" -ForegroundColor Green
Write-Host "=== Running Singleton Test ===" -ForegroundColor Yellow
java -cp bin com.example.design.singleton.SingletonTest
Write-Host "\n=== Running Factory Test ===" -ForegroundColor Yellow
java -cp bin com.example.design.factory.FactoryTest
