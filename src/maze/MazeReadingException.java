package maze;

@SuppressWarnings("serial")
public class MazeReadingException extends Exception {
	private final String fileName;
	private final int indexLine;
	private final String errorMessage;

	public MazeReadingException(String fileName, int indexLine, String errorMessage) {
		super(errorMessage + " : in " + fileName + " at line " + indexLine);
		this.fileName = fileName;
		this.errorMessage = errorMessage;
		this.indexLine = indexLine;
	}

	public MazeReadingException(String fileName, String errorMessage) {
		super(errorMessage + " : in " + fileName);
		this.fileName = fileName;
		this.errorMessage = errorMessage;
		this.indexLine = 0;
	}

	public String getFileName() {
		return fileName;
	}

	public int getIndexLine() {
		return indexLine;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
