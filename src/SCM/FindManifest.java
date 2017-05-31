package SCM;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FindManifest {

	/*Function Name : maniCheckOut
	*Parameters    : 1. strCommand: Command input by the user
	*				 2. strSourcePath: Source Folder Path
	*				 3. strDestPAth :Destination Folder Path
	*				 4.strDateTime : Manifest version Date Time provided
	*Return Type   : Void
	*Description   : Finds the Manifest based on the strDateTime ,Passes objMAnifest details containig the file metadata to Checkout
	*Created By    : Sharol Dsouza [5-10-2017]
	*Modified By   : Bandini Bhopi [5-11-2017]
	*/
	public void maniCheckOut(String strCommand, String strSourcePath, String strDestPath,
			String strDateTime) {
		File flSourcePath = new File(strSourcePath);
		Manifest objManifest = new Manifest();
		CheckOut objCheckOut =new CheckOut();
		objManifest.SetCommand(strCommand);
		objManifest.SetSourcePath(strSourcePath);
		objManifest.SetDestinationPath(strDestPath);
		Artifact artifact;
		ArrayList<Artifact> artifactarray= new ArrayList<Artifact>();;
		if (!flSourcePath.isDirectory()) {
			System.out.println("Source Path is not a valid directory.");
			return;

		}
		if (!flSourcePath.exists()) {
			System.out.println("Directory '" + strSourcePath + " does not exists.");
			return;
		}
		File file = new File(strSourcePath + File.separator + "Activity"+File.separator+"Manifest"+strDateTime+".txt");
		System.out.println(file);
	   if (!file.exists()) {
			System.out.println("Manifest File not found!");
			return;
		}
	  // System.out.println("Manifest File found!");
	   
	   String search ="Files Copied:";
	   boolean flag=false;
	   try {
           Scanner scan =new Scanner(file);
		   while (scan.hasNextLine())
           {
               final String lineFromFile = scan.nextLine();
               if(lineFromFile.contains(search)||flag == true)
               {	if(flag == true){
            	  String[] arti = lineFromFile.split(" ");
            	  artifact= new Artifact(arti);
            	  artifactarray.add(artifact);
               }
                  flag = true;
               }
           }
		   scan.close();
		   objManifest.SetArtifact(artifactarray);
		   
		  /* for (Artifact obj : objManifest.GetArtifactList()) {

				System.out.println("File:"+obj.getArtifact_name() + " " + obj.getArtifact_original() + " " + obj.getArtifact_path());

			}*/
		   objCheckOut.CheckOutmani(objManifest);
		   
       }
       catch(IOException e) {
           e.printStackTrace();      
       }
	   
	   
	   
	}

}
