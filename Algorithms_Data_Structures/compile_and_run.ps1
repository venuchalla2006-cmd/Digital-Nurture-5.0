# PowerShell script to compile and run Algorithms
$ErrorActionPreference = "Stop"
Write-Host "=== Compiling Algorithms ===" -ForegroundColor Cyan
if (Test-Path bin) { Remove-Item bin -Recurse -Force }
New-Item -ItemType Directory -Path bin -Force | Out-Null
$sources = Get-ChildItem -Path src -Filter *.java -Recurse | Select-Object -ExpandProperty FullName
javac -d bin -sourcepath src $sources
Write-Host "Compilation successful!\n" -ForegroundColor Green
Write-Host "=== Running E-commerce Search Test ===" -ForegroundColor Yellow
java -cp bin com.example.algo.search.SearchTest
Write-Host "\n=== Running Financial Forecasting Test ===" -ForegroundColor Yellow
java -cp bin com.example.algo.forecasting.ForecastingTest
