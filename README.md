# SCM
Source Code Management


Project Part-1: Create Repository</br>
Project Part-2: Checked

Introduction:
Project Part-1: This project part is the first step to build our SCM (Source Code Management) project (AKA a VCS: Version Control System). This part only implements an initial usecase: Create Repository. It is only a "Success Path" and contains "no frills". The SCM repository will contain multiple versions of the same file and each file version will be identified using the artifact id (version number of the file) and the path in which it is stored in the repository. Each change in the file will be recorded in the activity folder as a manifest file.</br>
Project Part-2: It also contains two new features check-in and check-out.Users can checkout specific versions of the file depending on the manifest file by providing the Date and time. This version is copied into the provided target folder as an original project tree. Check-in can be done by users to add their own project changes into the repo folder.The SCM notes the changes in the project tree then adds artifacts if it notices any changes.

External Requirements: 
Eclipse (Java)
