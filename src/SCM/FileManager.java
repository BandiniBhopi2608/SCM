/* Author: Samruddhi Kalyankar
 * Contact: samruddhi9369@gmail.com
 * Description: This class handles file operations such as readFile
 */
package SCM;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileManager {

	/*Function Name : readFile
	 *Parameters    : 1. strFile : Path of the File whose Artifact ID is to be calculated
	 *Return Type   : char[]
	 *Description   : This function gets the input parameter and creates the character array of the file contents. 
	 *Created By    : Samruddhi Kalyankar [23 Feb 2017]
	 */
	public char[] readFile(String strFile) {
		String string = "";
		File file = new File(strFile);
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			string = scanner.nextLine();
			while (scanner.hasNextLine()) {
				string += "\n" + scanner.nextLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		char[] fileCharArray = string.toCharArray();
		return fileCharArray;
	}
}
