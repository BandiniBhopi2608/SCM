/* Author: Samruddhi Kalyankar
 * Contact: samruddhi9369@gmail.com
 * Description: This class handles artifact operations such as to calculate artifact id of the file
 */
package SCM;

public class ArtifactController {
	private FileManager objFileManager = new FileManager();

	/*Function Name : calculateArtifactId
	 *Parameters    : 1. strFile : Path of the File whose Artifact ID is to be calculated
	 *Return Type   : String
	 *Description   : This function gets the input parameter and calculates the Artifact ID of the given File. 
	 *Created By    : Samruddhi Kalyankar [23 Feb 2017]
	 */
	public String calculateArtifactId(String strFile) {
		char[] fileContents = objFileManager.readFile(strFile);
		int fileLength = fileContents.length;
		int sum = 0;
		int[] checkSum = { 1, 3, 11, 17 };

		for (int i = 0; i < fileLength; i++) {
			sum += fileContents[i] * checkSum[i % checkSum.length];
		}
		return sum + "." + fileLength;
	}
}
