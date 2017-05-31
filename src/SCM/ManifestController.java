/* Author: Sharol Dsouza
 * Contact: sharoldsouza@ymail.com
 * Description: This class handles creation of activity folder and manifest file.
 */
package SCM;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ManifestController {

	/*Function Name : ManifestCreate
	 *Parameters    : 1. objManifest : Manifest Object passed by the helper.Contains command,source_path,dest_path and artifact list
	 *Return Type   : void
	 *Description   : Checks if activity folder exists.If not creates activity folder then generates a new manifest file each time it is called.  
	 *Created By    : Sharol Dsouza [24 Feb 2017]
	 */
	public void ManifestCreate(Manifest objManifest,String ManifestLocation) {
		String strTargetRepoPath;
		//System.out.println("Test");
		if(objManifest.GetDestinationPath() == ManifestLocation){
		strTargetRepoPath = objManifest.GetDestinationPath().substring(0, objManifest.GetDestinationPath().lastIndexOf(File.separator));
		//System.out.println("Test1");
		}
		else{
			strTargetRepoPath = objManifest.GetSourcePath();
			
		}
		 
		File file = new File(strTargetRepoPath + File.separator + "Activity");
		if (!file.exists()) {
			if (file.mkdir()) {
				System.out.println("Repository created successfully!!");
			}
			
		}
		// if folder exists create a new manifest file
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String dateString = simpleDateFormat.format(new Date());
		SimpleDateFormat dtCreatedDateFormat = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a");
		try {
			String s = "Manifest";
			String filename = s.concat(dateString);
			File dir = new File(strTargetRepoPath + File.separator + "Activity");
			dir.mkdirs();
			File p = new File(dir, filename + ".txt");
			p.createNewFile();
			System.out.println(p);
			// write in the new created file
			FileOutputStream fout = new FileOutputStream(p);
			BufferedWriter buffw = new BufferedWriter(new OutputStreamWriter(fout));
			buffw.write(filename);
			buffw.newLine();
			buffw.write("Created at:" + dtCreatedDateFormat.format(new Date()));
			buffw.newLine();
			buffw.write("Command Name:" + objManifest.GetCommand());
			buffw.newLine();
			buffw.write("Full Original Project Path:" + objManifest.GetSourcePath());
			buffw.newLine();
			buffw.write("Full Repository Path:" +strTargetRepoPath);
			buffw.newLine();
			buffw.write("Files Copied:");
			buffw.newLine();
			for (Artifact obj : objManifest.GetArtifactList()) {

				buffw.write(obj.getArtifact_name() + " " + obj.getArtifact_original() + " " + obj.getArtifact_path());
				buffw.newLine();
			}
			buffw.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
