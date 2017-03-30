/* Author: Bandini Bhopi
 * Contact: bandini.bhopi@gmail.com
 * Description: This class handles input from user to create repository with command createrepo.
 * Syntax: createrepo source_path destination_path
 */
package SCM;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;

public class Main {
	private static Scanner sc;
	private static CreateRepo objCreateRepo = new CreateRepo();
	private static String strPattern = "(?:[a-zA-Z]\\:)\\\\([\\w -]+\\\\)*\\w([\\w-.][a-zA-Z0-9\\-\\.\\_]*)+";

	/*Function Name : calculateArtifactId
	 *Parameters    : 1. strFile : Path of the File whose Artifact ID is to be calculated
	 *Return Type   : String
	 *Description   : This function gets the input parameter and calculates the Artifact ID of the given File. 
	 *Created By    : Bandini Bhopi [24 Feb 2017]
	 *Modfied By	: Samruddhi Kalyankar [25 Feb 2017]
	 */
	public static void main(String[] args) throws IOException {
		System.out.print(">>");
		sc = new Scanner(System.in);
		String strCommand = sc.nextLine();
		if (strCommand.toLowerCase().startsWith("createrepo")) {
			
			Pattern p = Pattern.compile(strPattern);
			Matcher m = p.matcher(strCommand);
			List<String> Paths = new ArrayList<String>();
			while (m.find()) {
				Paths.add(m.group());
			}
			if (Paths.size() == 2) {
				objCreateRepo.CreateRepository(strCommand, Paths.get(0), Paths.get(1));
			} else {
				System.out.println("Invalid Command.");
			}
		} else {
			System.out.println("Invalid Command.");
		}

	}
}
