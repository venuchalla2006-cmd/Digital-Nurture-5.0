#!/bin/bash

# Week 7: Git Lab Operations Simulation Script
# This script automates and simulates local Git operations (Labs 1-4) in a temporary sandbox.

echo "============================================="
# Make a clean sandbox directory for simulation
SANDBOX_DIR="git_sandbox"
echo "Creating Git Sandbox directory: $SANDBOX_DIR"
rm -rf "$SANDBOX_DIR"
mkdir "$SANDBOX_DIR"
cd "$SANDBOX_DIR"

echo "============================================="
echo "LAB 1: Git Repository Initialization & Setup"
echo "============================================="
git init
echo "Hello World" > sample.txt
git add sample.txt
git commit -m "Initial commit: Add sample.txt"
git log --oneline

echo "============================================="
echo "LAB 2: Ignored Files with .gitignore"
echo "============================================="
echo "This is a log message" > app.log
mkdir -p log
echo "Error occurred" > log/error.log

echo "Creating .gitignore to exclude *.log and log/ directory..."
echo "*.log" > .gitignore
echo "log/" >> .gitignore

echo "Git Status (notice that app.log and log/ are not listed):"
git status -s

git add .gitignore
git commit -m "Add .gitignore"

echo "============================================="
echo "LAB 3: Branching & Merging"
echo "============================================="
echo "Creating branch GitNewBranch..."
git branch GitNewBranch
echo "Switching to GitNewBranch..."
git checkout GitNewBranch

echo "Making modifications on GitNewBranch..."
echo "New feature content" > feature.txt
git add feature.txt
git commit -m "Add feature.txt on GitNewBranch"

echo "Switching back to master..."
git checkout master

echo "Merging GitNewBranch into master..."
git merge GitNewBranch

echo "Deleting branch GitNewBranch..."
git branch -d GitNewBranch

echo "Log history after merge:"
git log --oneline --graph --decorate --all

echo "============================================="
echo "LAB 4: Merge Conflict Resolution"
echo "============================================="
echo "Creating branch GitWork..."
git checkout -b GitWork

echo "Adding hello.xml with GitWork content..."
echo "<root><message>Hello from GitWork</message></root>" > hello.xml
git add hello.xml
git commit -m "Add hello.xml on GitWork"

echo "Switching back to master..."
git checkout master

echo "Adding hello.xml with master content..."
echo "<root><message>Hello from Master</message></root>" > hello.xml
git add hello.xml
git commit -m "Add hello.xml on master"

echo "Merging GitWork branch (This will trigger a conflict)..."
git merge GitWork

echo "File content of hello.xml with conflict markers:"
cat hello.xml

echo "Resolving merge conflict in hello.xml..."
# Simulating conflict resolution by replacing content
cat <<EOT > hello.xml
<root>
  <message>Hello from Master and GitWork</message>
</root>
EOT

echo "Staging resolved hello.xml and committing..."
git add hello.xml
git commit -m "Resolve merge conflict in hello.xml"

echo "Deleting branch GitWork..."
git branch -d GitWork

echo "============================================="
echo "Simulation Finished Successfully!"
echo "============================================="
cd ..
rm -rf "$SANDBOX_DIR"
echo "Sandbox directory cleaned up."
