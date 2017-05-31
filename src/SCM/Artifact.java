/* Author: Samruddhi Kalyankar
 * Contact: samruddhi9369@gmail.com
 * Description: This class contains private members, constructors and getter methods for private members
 */
package SCM;

public class Artifact {
	private String artifact_name;
	private String artifact_path;
	private String artifact_original;

	public Artifact(String artifact_name, String artifact_path, String artifact_original) {
		this.artifact_name = artifact_name;
		this.artifact_path = artifact_path;
		this.artifact_original = artifact_original;
	}

	public Artifact(String[] arti) {
		this.artifact_name = arti[0];
		this.artifact_path = arti[2];
		this.artifact_original = arti[1];
	}

	public String getArtifact_name() {
		return artifact_name;
	}

	public String getArtifact_path() {
		return artifact_path;
	}

	public String getArtifact_original() {
		return artifact_original;
	}
	
	
}
