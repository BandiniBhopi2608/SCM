/* Author: Bandini Bhopi
 * Contact: bandini.bhopi@gmail.com
 * Description: This class handles creation of the repository.
 */
package SCM;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class CreateRepo {

	private ArtifactController objArtifactController;
	private ManifestHelper objManifestHelper;
	private Manifest objManifest;

	/*Function Name : CreateRepository
	 *Parameters    : 1. strCommand : User command to create Repository eg. CreateRepo [SourcePath] [DestinationPath]
	 *				  2. strSourcePath: Project source Full Path
	 *				  3. strDestinationPath: Target Repository Full Path
	 *Return Type   : Void
	 *Description   : This function validates the input parameter and creates the target repository on Specified path. 
	 *Created By    : Bandini Bhopi [24 Feb 2017]
	 */
	public void CreateRepository(String strCommand, String strSourcePath, String strDestinationPath)
			throws IOException {
		
		File flSourcePath = new File(strSourcePath);
		if (!flSourcePath.exists()) {
			System.out.println("Directory '" + strSourcePath + "' does not exists.");
			return;
		}
		
		if (!flSourcePath.isDirectory()) {
			System.out.println("Source Path is not a valid directory.");
			return;

		}

		String strSrcFolder = strSourcePath.substring(strSourcePath.lastIndexOf(File.separator) + 1);
		File flTargetRepoPath = new File(strDestinationPath + File.separator + strSrcFolder);
		if (flTargetRepoPath.mkdir()) {
			
			objArtifactController = new ArtifactController();
			CopyFolder(strSourcePath, strDestinationPath + File.separator + strSrcFolder);

			objManifest = new Manifest();
			objManifest.SetCommand(strCommand);
			objManifest.SetSourcePath(strSourcePath);
			objManifest.SetDestinationPath(strDestinationPath + File.separator + strSrcFolder);

			objManifestHelper = new ManifestHelper();
			objManifestHelper.CreateActivity(objManifest);
		} else {
			System.out.println("Error occurred while creating repository. Please try again.");
			return;
		}
	}

	/*Function Name : CopyFolder
	 *Parameters    : 1. strSrcFolderPath: Source Folder Path
	 *				  2. strRootTargetFolder: Repository Folder Path
	 *Return Type   : Void
	 *Description   : This folder copies the Project folder to the target repository folder by copying files with their artifact
	 *                name to maintain version.
	 *Created By    : Bandini Bhopi [24 Feb 2017]
	 */
	private void CopyFolder(String strSrcFolderPath, String strRootTargetFolder) throws IOException {
		File[] subDirectories = new File(strSrcFolderPath).listFiles();
		if (subDirectories.length > 0) {
			for (int i = 0; i < subDirectories.length; i++) {
				String strTargetFolder = strRootTargetFolder;
				if (subDirectories[i].isDirectory()) {
					strTargetFolder = strTargetFolder + File.separator + subDirectories[i].getName();
					CopyFolder(subDirectories[i].getPath(), strTargetFolder);
				} else {
					File flTargetSubFolder = new File(strTargetFolder + File.separator + subDirectories[i].getName());
					if (flTargetSubFolder.mkdirs()) {
						if (subDirectories[i].isFile()) {
							String artifactID = objArtifactController.calculateArtifactId(subDirectories[i].getPath());
							String strExtension = subDirectories[i].toString().substring(subDirectories[i].toString().lastIndexOf("."));
							Files.copy(subDirectories[i].toPath(),
									  (new File(flTargetSubFolder.getPath() + File.separator + artifactID + strExtension)).toPath(),
									  StandardCopyOption.REPLACE_EXISTING);
						}
					}
				}
			}
		}
	}
}
