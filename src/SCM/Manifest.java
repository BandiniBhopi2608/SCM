/* Author: Sharol Dsouza
 * Contact: sharoldsouza@ymail.com
 * Description: This class contains private members and getter methods for private members
 */
package SCM;

import java.util.ArrayList;

public class Manifest {
	private String strCommand;
	private String strSourcePath;
	private String strDestinationPath;
	private ArrayList<Artifact> lstArtifact;

	public void SetCommand(String strCommand) {
		this.strCommand = strCommand;
	}

	public void SetSourcePath(String strSourcePath) {
		this.strSourcePath = strSourcePath;
	}

	public void SetDestinationPath(String strDestinationPath) {
		this.strDestinationPath = strDestinationPath;
	}
	
	public void SetArtifact(ArrayList<Artifact> lstArtifact) {
		this.lstArtifact = lstArtifact;
	}

	public String GetCommand() {
		return this.strCommand;
	}
	
	public String GetSourcePath() {
		return this.strSourcePath;
	}
	
	public String GetDestinationPath() {
		return this.strDestinationPath;
	}
	
	public ArrayList<Artifact> GetArtifactList() {
		return this.lstArtifact;
	}
}
