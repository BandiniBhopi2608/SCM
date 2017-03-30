/* Author: Sharol Dsouza
 * Contact: sharoldsouza@ymail.com
 * Description: This class gathers manifest information for the ManifestController.
 */
package SCM;

import java.io.File;
import java.util.ArrayList;

public class ManifestHelper {

	private ArrayList<Artifact> artilist = new ArrayList<Artifact>();

	/*Function Name : CreateActivity
	 *Parameters    : 1. objManifest : Manifest Object.
	 *Return Type   : void
	 *Description   : Calls GetArtifactList to get arraylist of files copied.Then calls manifest controller
	 *Created By    : Sharol Dsouza [24 Feb 2017]
	 */
	public void CreateActivity(Manifest objManifest) {

		File dir = new File(objManifest.GetDestinationPath());
		GetArtifactList(dir, objManifest.GetDestinationPath());
		objManifest.SetArtifact(artilist);
		// Collect all artifacts
		ManifestController manifest = new ManifestController();
		manifest.ManifestCreate(objManifest);
	}
	/*Function Name : GetArtifactList
	 *Parameters    : 1. dir: target folder path of the project directory 
	 *				  2. target_path: folder path of the project in the repository folder
	 *Return Type   : void
	 *Description   : Generates an Artifact list.
	 *Created By    : Sharol Dsouza [24 Feb 2017]
	 *Modfied By	: Samruddhi Kalyankar [25 Feb 2017]
	 */
	private void GetArtifactList(File dir, String target_path) {
		File[] files = dir.listFiles();

		for (File file : files) {
			if (file.isDirectory()) {
				GetArtifactList(file, target_path);
			} else {
				String filePath = file.getPath();
				String strTreePath = filePath.substring(0, filePath.lastIndexOf(File.separator));
				strTreePath = strTreePath.substring(0, strTreePath.lastIndexOf(File.separator));
				String strProjectTreePath = strTreePath.replace(target_path, "");
				Artifact temp = new Artifact(file.getName(), strProjectTreePath, dir.getName());
				artilist.add(temp);
			}
		}
	}
}
