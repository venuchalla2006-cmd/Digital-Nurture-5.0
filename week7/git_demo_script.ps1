# Week 7: Git Lab Operations Simulation Script (PowerShell Version)
# This script automates and simulates local Git operations (Labs 1-4) in a temporary sandbox.

Write-Output "============================================="
$SandboxDir = "git_sandbox"
Write-Output "Creating Git Sandbox directory: $SandboxDir"
if (Test-Path $SandboxDir) {
    Remove-Item -Recurse -Force $SandboxDir
}
New-Item -ItemType Directory -Path $SandboxDir | Out-Null
Set-Location $SandboxDir

Write-Output "============================================="
Write-Output "LAB 1: Git Repository Initialization & Setup"
Write-Output "============================================="
git init
"Hello World" | Out-File -FilePath sample.txt -Encoding utf8
git add sample.txt
git commit -m "Initial commit: Add sample.txt"
git log --oneline

Write-Output "============================================="
Write-Output "LAB 2: Ignored Files with .gitignore"
Write-Output "============================================="
"This is a log message" | Out-File -FilePath app.log -Encoding utf8
New-Item -ItemType Directory -Path log | Out-Null
"Error occurred" | Out-File -FilePath log/error.log -Encoding utf8

Write-Output "Creating .gitignore to exclude *.log and log/ directory..."
"*.log`nlog/" | Out-File -FilePath .gitignore -Encoding utf8

Write-Output "Git Status (notice that app.log and log/ are not listed):"
git status -s

git add .gitignore
git commit -m "Add .gitignore"

Write-Output "============================================="
Write-Output "LAB 3: Branching & Merging"
Write-Output "============================================="
Write-Output "Creating branch GitNewBranch..."
git branch GitNewBranch
Write-Output "Switching to GitNewBranch..."
git checkout GitNewBranch

Write-Output "Making modifications on GitNewBranch..."
"New feature content" | Out-File -FilePath feature.txt -Encoding utf8
git add feature.txt
git commit -m "Add feature.txt on GitNewBranch"

Write-Output "Switching back to master..."
git checkout master

Write-Output "Merging GitNewBranch into master..."
git merge GitNewBranch

Write-Output "Deleting branch GitNewBranch..."
git branch -d GitNewBranch

Write-Output "Log history after merge:"
git log --oneline --graph --decorate --all

Write-Output "============================================="
Write-Output "LAB 4: Merge Conflict Resolution"
Write-Output "============================================="
Write-Output "Creating branch GitWork..."
git checkout -b GitWork

Write-Output "Adding hello.xml with GitWork content..."
"<root><message>Hello from GitWork</message></root>" | Out-File -FilePath hello.xml -Encoding utf8
git add hello.xml
git commit -m "Add hello.xml on GitWork"

Write-Output "Switching back to master..."
git checkout master

Write-Output "Adding hello.xml with master content..."
"<root><message>Hello from Master</message></root>" | Out-File -FilePath hello.xml -Encoding utf8
git add hello.xml
git commit -m "Add hello.xml on master"

Write-Output "Merging GitWork branch (This will trigger a conflict)..."
git merge GitWork

Write-Output "File content of hello.xml with conflict markers:"
Get-Content hello.xml

Write-Output "Resolving merge conflict in hello.xml..."
$ResolvedContent = @"
<root>
  <message>Hello from Master and GitWork</message>
</root>
"@
$ResolvedContent | Out-File -FilePath hello.xml -Encoding utf8

Write-Output "Staging resolved hello.xml and committing..."
git add hello.xml
git commit -m "Resolve merge conflict in hello.xml"

Write-Output "Deleting branch GitWork..."
git branch -d GitWork

Write-Output "============================================="
Write-Output "Simulation Finished Successfully!"
Write-Output "============================================="
Set-Location ..
Remove-Item -Recurse -Force $SandboxDir
Write-Output "Sandbox directory cleaned up."
