package SCM;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

public class CheckOut {
	
	private ManifestController objManifestController;
	
	/*Function Name : CheckOutmani
	*Parameters    : 1.objManifest: Manifest object containing the command,source path,destination path and file list
	*Return Type   : Void
	*Description   : Creats a copy of the project tree in the target folder specified from the repo with all file replaced by their orignal names
	 *Created By    : Samruddi Kalyankar [5-10-2017]
	*Modified By   : Bandini Bhopi [5-11-2017]
	**/
	public void CheckOutmani( Manifest objManifest) throws IOException{
		File flSourcePath = new File(objManifest.GetDestinationPath());
		if (!flSourcePath.isDirectory()) {
			System.out.println("Destination Path is not a valid directory.");
			return;

		}
		if (!flSourcePath.exists()) {
			System.out.println("Directory '" + objManifest.GetDestinationPath() + "' does not exists.");
			return;
		}	
		new ArtifactController();
		CopyFolder(objManifest.GetSourcePath(), objManifest.GetDestinationPath(),objManifest.GetArtifactList());
			 
		objManifestController = new ManifestController();
		objManifestController.ManifestCreate(objManifest,objManifest.GetSourcePath());		
	}

	/*Function Name : CopyFolder
	 *Parameters    : 1. strSrcFolderPath: Source Folder Path
	 *				  2. strRootTargetFolder: Repository Folder Path
	 *Return Type   : Void
	 *Description   : This folder copies the Project folder to the target repository folder by copying files with their artifact
	 *                name to maintain version.
	 *Created By    : Bandini Bhopi [24 Feb 2017]
	 */
	
	private void CopyFolder(String strSrcFolderPath, String strRootTargetFolder, ArrayList<Artifact> arrayList) throws IOException {
		File[] subDirectories = new File(strSrcFolderPath).listFiles();
		String strExActivity = "Activity";
		
		if (subDirectories.length > 0) {
			for (int i = 0; i < subDirectories.length; i++) {
				String strTargetFolder = strRootTargetFolder;
				if (subDirectories[i].isDirectory() && !subDirectories[i].getName().equalsIgnoreCase(strExActivity)) {
					System.out.println(subDirectories[i].getName());
					strTargetFolder = strTargetFolder + File.separator + subDirectories[i].getName();
					CopyFolder(subDirectories[i].getPath(), strTargetFolder, arrayList);
				} else if(!subDirectories[i].getName().equalsIgnoreCase(strExActivity)) {
					String strSourceFile = subDirectories[i].getName(); //6677.8.txt
					for(int j=0; j<arrayList.size() ; j++) {
						Artifact objArtifact= arrayList.get(j);
						if(objArtifact.getArtifact_name().equals(strSourceFile)) {
							strTargetFolder = strTargetFolder.substring(0, strTargetFolder.lastIndexOf(File.separator));
							File flTargetSubFolder = new File(strTargetFolder);
							if(!flTargetSubFolder.exists()) {
							flTargetSubFolder.mkdirs();
							}
								if (subDirectories[i].isFile() ) {
									Files.copy(subDirectories[i].toPath(),
											  (new File(flTargetSubFolder.getPath() + File.separator + objArtifact.getArtifact_original())).toPath(),
											  StandardCopyOption.REPLACE_EXISTING);
									break;
								}
							
						}
					}
				}
			}
		}
		
	}

}
