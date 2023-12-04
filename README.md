# think24

1. Tell Git who you are (Configure the author name and email address to be used with your commits. Note that Git strips some characters (for example trailing periods) from user.name.)

* **git config --global user.name "Sam Smith"**
* **git config --global user.email sam@example.com**
  
==========================================================

2. Add files (Add one or more files to staging (index):)
   
* **git add `<filename>`**
* git add *
  
==========================================================

3. Commit

* **git commit -m "Commit message"**   (Commit changes to head (but not yet to the remote repository):
* **git commit -a**                     (Commit any files you've added with git add, and also commit any files you've changed since then:)
  
==========================================================

4. Push (Send changes to the master branch of your remote repository)
* **git push origin master**
  
==========================================================

5.Status (List the files you've changed and those you still need to add or commit.)
* **git status**
  
==========================================================

6. Branches
* **git checkout -b `<branchname>`**      (Create a new branch and switch to it)
* **git checkout `<branchname>`**         (Switch from one branch to another)
* **git branch**                          (List all the branches in your repo, and also tell you what branch you're currently in)
* **git branch -d `<branchname>`**        (Delete the feature branch:)
* **git push origin `<branchname>`**      (Push the branch to your remote repository, so others can use it:)
* **git push --all origin**               (Push all branches to your remote repository:)
* **git push origin :`<branchname>`**     (Delete a branch on your remote repository:)
  
==========================================================

7. Connect to a remote repository 
* **git remote add origin `<server>`**              (If you haven't connected your local repository to a remote server, add the server to be able to push to it:	)
* **git remote -v**                                 (List all currently configured remote repositories:	)
  
==========================================================

8. Update from the remote repository
* **git pull**                                                   (Fetch and merge changes on the remote server to your working directory:	)
* **git merge `<branchname>`**                                   (To merge a different branch into your active branch:)
* **git diff**                                                   (View all the merge conflicts)
* **git diff --base `<filename>`**                               (View the conflicts against the base file)
* **git diff `<sourcebranch>` `<targetbranch>`**                 (Preview changes, before merging))
* **git add `<filename>`**                                       (After you have manually resolved any conflicts, you mark the changed file:)
  
==========================================================

9. Tags	
* **git tag 1.0.0 `<commitID>`**                                  (You can use tagging to mark a significant changeset, such as a release:)
* **git log**                                                     (CommitId is the leading character of the changeset ID, up to 10, but must be unique. Get the ID using:)
* **git push --tags origin**                                      (Push all tags to remote repository:)
  
==========================================================

10. Undo local changes
* **git checkout -- `<filename>`**                  (If you mess up, you can replace the changes in your working tree with the last content in head: Changes already added to the index, as well as new files, will be kept.)
* **git fetch origin**                              (Instead, to drop all your local changes and commits, fetch the latest history from the server and point your local master branch at it, do this:)
* **git reset --hard origin/master**
  
==========================================================

11. Search	
* **git grep "foo()"**                             (Search the working directory for foo():)
  
==========================================================
