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
	private static FindManifest objCheckOut =new FindManifest();
	private static String strPattern = "(?:[a-zA-Z]\\:)\\\\([\\w -]+\\\\)*\\w([\\w-.])+";
	private static String strManifestNumber = "[0-9]+-[0-9]+";
	/*Function Name : main
	*Return Type   : void
	*Description   : Main Function 
	*Created By    : Bandini Bhopi [24 Feb 2017]
	*Modfied By	: Samruddhi Kalyankar [25 Feb 2017]
	*					Sharol Dsouza[12 Feb 2017]
	*/
	public static void main(String[] args) throws IOException {
		System.out.print(">>");
		sc = new Scanner(System.in);
		String strCommand = sc.nextLine();
		if (strCommand.toLowerCase().startsWith("createrepo") || strCommand.toLowerCase().startsWith("checkin")) {
			
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
		} else if( strCommand.toLowerCase().startsWith("checkout")){
			Pattern p = Pattern.compile(strPattern);
			Matcher m = p.matcher(strCommand);
			Pattern p2 = Pattern.compile(strManifestNumber);
			Matcher m2 = p2.matcher(strCommand);
			List<String> Arg =new ArrayList<String>();
			while(m.find()){
				Arg.add(m.group());
			}
			while(m2.find()){
				Arg.add(m2.group());
			}
			if(Arg.size() == 3){
				objCheckOut.maniCheckOut(strCommand,Arg.get(0),Arg.get(1),Arg.get(2));
			}
			else{
				System.out.println("Invalid Command checkin/checkout");
			}
		}
		else {
			System.out.println("Invalid Command.");
		}

	}
}
