# Week 7: Git Hands-on Labs (1 - 5) Solutions

This document provides the step-by-step commands and detailed explanations for the 5 Git hands-on laboratories required for the Platforms construct in Week 7.

---

## Lab 1: Setup and Basic Git Operations

### Objective
- Set up local Git configurations (Username, Email, Editor).
- Configure notepad++ as the default editor.
- Perform basic repository initialization, file staging, and committing.

### Step-by-Step Commands

1. **Verify Git Installation:**
   Check if Git is installed on your machine by opening Git Bash and executing:
   ```bash
   git --version
   ```

2. **Configure User Details:**
   Configure your global username and email address (do not use your corporate credentials for personal GitHub/GitLab accounts):
   ```bash
   git config --global user.name "Venu Challa"
   git config --global user.email "venuchalla@example.com"
   ```

3. **Verify Settings:**
   List all configurations to ensure user name and email are correctly configured globally:
   ```bash
   git config --list
   ```

4. **Integrate Notepad++ as Default Editor:**
   To add Notepad++ to your system path:
   - Search for **System Environment Variables** in Windows.
   - Edit the `Path` variable under User/System variables and append the path to Notepad++ (usually `C:\Program Files\Notepad++`).
   - Reopen Git Bash and test that `notepad++` can be executed.
   - Configure Notepad++ as the default git editor:
     ```bash
     git config --global core.editor "'C:/Program Files/Notepad++/notepad++.exe' -multiInst -notabbar -nosession -noPlugin"
     ```
   - Verify the editor configuration by launching global configurations in Notepad++:
     ```bash
     git config --global -e
     ```

5. **Initialize Git and Add First File:**
   In your project directory, initialize a new Git repository:
   ```bash
   git init
   ```
   Create a text file, add it to the staging area, and commit it:
   ```bash
   echo "Initial file content" > sample.txt
   git add sample.txt
   git commit -m "Initial commit: Add sample.txt"
   ```

---

## Lab 2: Working with `.gitignore`

### Objective
- Use `.gitignore` to prevent tracking of unnecessary temporary files, logs, and build artifacts.

### Scenario
We want to ignore all files ending in `.log` and any contents inside the `log/` folder.

### Step-by-Step Commands

1. **Create Log File and Folder:**
   ```bash
   echo "System log details" > info.log
   mkdir log
   echo "Application error logs" > log/error.log
   ```

2. **Create and Configure `.gitignore`:**
   Create a `.gitignore` file and open it to write the patterns:
   ```bash
   echo "*.log" > .gitignore
   echo "log/" >> .gitignore
   ```

3. **Verify Status:**
   Check the status of the repository to confirm that `info.log` and the `log` folder are ignored:
   ```bash
   git status
   ```
   *Expected output:* Only `.gitignore` is displayed as an untracked file. `info.log` and the `log/` directory are not listed.

4. **Commit `.gitignore`:**
   Add and commit the `.gitignore` file to save your changes:
   ```bash
   git add .gitignore
   git commit -m "Add .gitignore to exclude log files and directories"
   ```

---

## Lab 3: Branching and Merging

### Objective
- Create, list, switch, merge, and delete local branches.

### Step-by-Step Commands

1. **Create a New Branch:**
   Create a branch named `GitNewBranch`:
   ```bash
   git branch GitNewBranch
   ```

2. **List Available Branches:**
   List all local branches. The active branch will be marked with an asterisk `*`:
   ```bash
   git branch
   ```

3. **Switch to the New Branch:**
   ```bash
   git checkout GitNewBranch
   ```

4. **Add and Commit Changes on the Branch:**
   Create a new file `feature.txt` in the branch and commit:
   ```bash
   echo "New feature content" > feature.txt
   git add feature.txt
   git commit -m "Add feature.txt on GitNewBranch"
   ```

5. **Switch Back to Master:**
   ```bash
   git checkout master
   ```

6. **Check Differences:**
   Compare the files in the master branch against the `GitNewBranch` branch:
   ```bash
   git diff master GitNewBranch
   ```

7. **Merge the Branch:**
   Merge the changes from `GitNewBranch` into `master`:
   ```bash
   git merge GitNewBranch
   ```

8. **View Logging Graph:**
   Check the visual layout of commits, branches, and merges:
   ```bash
   git log --oneline --graph --decorate --all
   ```

9. **Delete the Branch:**
   Since the branch is merged, delete it to keep the repository clean:
   ```bash
   git branch -d GitNewBranch
   ```

---

## Lab 4: Conflict Resolution

### Objective
- Handle situations where conflicting modifications are made to the same file on two different branches, resulting in a merge conflict.

### Step-by-Step Commands

1. **Verify Clean State:**
   Ensure there are no uncommitted changes:
   ```bash
   git status
   ```

2. **Create a Branch and Modify a File:**
   Create a branch `GitWork` and create a file `hello.xml`:
   ```bash
   git checkout -b GitWork
   echo "<root><message>Hello from GitWork</message></root>" > hello.xml
   git add hello.xml
   git commit -m "Add hello.xml on GitWork"
   ```

3. **Switch Back to Master and Modify the Same File:**
   ```bash
   git checkout master
   echo "<root><message>Hello from Master</message></root>" > hello.xml
   git add hello.xml
   git commit -m "Add hello.xml on master with different content"
   ```

4. **Merge the Branch (Triggers Conflict):**
   ```bash
   git merge GitWork
   ```
   *Expected output:*
   ```text
   Auto-merging hello.xml
   CONFLICT (add/add): Merge conflict in hello.xml
   Automatic merge failed; fix conflicts and then commit the result.
   ```

5. **Resolve the Conflict Manually:**
   Open `hello.xml` in an editor. You will see conflict markers:
   ```xml
   <<<<<<< HEAD
   <root><message>Hello from Master</message></root>
   =======
   <root><message>Hello from GitWork</message></root>
   >>>>>>> GitWork
   ```
   Edit the file to merge the changes. For example:
   ```xml
   <root>
     <message>Hello from Master and GitWork</message>
   </root>
   ```
   Save the file.

6. **Mark as Resolved and Commit:**
   Stage the resolved file and complete the merge commit:
   ```bash
   git add hello.xml
   git commit -m "Merge branch 'GitWork' and resolve conflict in hello.xml"
   ```

7. **Verify Log and Delete Branch:**
   ```bash
   git log --oneline --graph --decorate --all
   git branch -d GitWork
   ```

---

## Lab 5: Remote Git Operations

### Objective
- Synchronize your local changes with a remote git repository (fetch, pull, and push).

### Step-by-Step Commands

1. **Verify Remote Connection:**
   Check the remote URLs linked to your local repository:
   ```bash
   git remote -v
   ```

2. **Pull Remote Changes (Optional/Sync):**
   Before pushing, pull any potential remote updates into your local master branch:
   ```bash
   git pull origin master
   ```

3. **Push Local Changes:**
   Push your local master branch commits to the remote origin:
   ```bash
   git push origin master
   ```

4. **Verify Remote Status:**
   Confirm that all branches and commits are properly synced by logging into your remote GitLab/GitHub repository dashboard.
