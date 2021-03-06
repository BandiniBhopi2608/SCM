Project/Program Name: Source Code Management (SCM)

Team Name: DKB

Authors and Contact Information:
Dsouza Sharol (sharoldsouza@ymail.com) CECS 543-01
Kalyankar Samruddhi (samruddhi9369@gmail.com) CECS 543-02
Bhopi Bandini (bandini.bhopi@gmail.com) CECS 543-02

Project Part-1: Create Repository
Project Part-2: Checked

Introduction:
Project Part-1: This project part is the first step to build our SCM (Source Code Management) project (AKA a VCS: Version Control System). This part only implements an initial usecase: Create Repository. It is only a "Success Path" and contains "no frills". The SCM repository will contain multiple versions of the same file and each file version will be identified using the artifact id (version number of the file) and the path in which it is stored in the repository. Each change in the file will be recorded in the activity folder as a manifest file.

Project Part-2: It also contains two new features check-in and check-out.Users can checkout specific versions of the file depending on the manifest file by providing the Date and time. This version is copied into the provided target folder as an original project tree. Check-in can be done by users to add their own project changes into the repo folder.The SCM notes the changes in the project tree then adds artifacts if it notices any changes.

External Requirements: 
Eclipse (Java)

List of Files:
Main.java
CreateRepo.java
FileManager.java
Artifact.java
ArtifactController.java
Manifest.java
ManifestController.java
ManifestHelper.java

Installation:
Install Eclipse IDE for Java.

Setup:
1. Extract project zip folder.
2. Create New Java Project.
3. Copy SCM folder into the src folder of the project.

Build/Run:
Run project and give command as shown in the syntax.

Syntax:
createrepo source_path destination_path
Example, createrepo C:\myPt D:\myRepo

checkout source_path destination_path version_datetime
Example, checkout D:\myrepo D:\GameTest 20170226-074044 

checkin source_path destination_path
Example, checkin D:\GameDev1 D:\myrepo 

Assumptions:
Assumes that free disk space is adequate at the destination path.

Known bugs:
1. This program is only for Windows File System.
2. First argument after createrepo should be path to the source project only.
3. Only Text files supported. Following formats not supported : .doc, .docx, .pdf, Images, .ppt, .rtf etc.
4. While giving command line input, if last folder name of source path and target path contain spaces then it wont recongnize part of the folder name after space.
Correct Command: C:\ASE Project\MyProject
Wrong Command  : C:\ASE Project\My Project