import java.nio.file.*;

public class FileVerifier {

	String path;
	Path filepath;
	
	FileVerifier(String path) {
		this.path = path;
		this.filepath = Paths.get(this.path);
	}
	
	private boolean verifyCSVExtension() {
		if (this.path.length() < 5) {
			return false;
		}
		if (!this.path.toLowerCase().endsWith(".csv")) {
			return false;
		}
		return true;
	}

	private boolean verifyFileExists() {
		if (!Files.exists(this.filepath)) {
			return false;
		}
		if (!Files.isRegularFile(this.filepath)) {
			return false;
		}
		return true;
	}

	private boolean verifyFileIsAccessible() {
		if (!Files.isReadable(filepath)) {
			return false;
		}
		return true;
	}

	public boolean verifyFileReqs() {
		if (!this.verifyFileExists()) {
			System.out.println("the path provided is invalid");
			return false;
		}
		if (!this.verifyFileIsAccessible()) {
			System.out.println("the path provided is valid but file" + 
			" but permissions are unsufficient to open the file");
			return false;
		}
		if (!this.verifyCSVExtension()) {
			System.out.println("the file is not in CSV format");
			return false;
		}
		return true;
	}
}
