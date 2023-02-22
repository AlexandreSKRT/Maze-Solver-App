package dijkstra;

public class CoordKeeper {
	private int x; 
	private int y;  
	
	public CoordKeeper(int x, int y) {
		this.x = x; 
		this.y = y; 
	}
	
	public void setCoord(int x, int y) {
		this.x = x; 
		this.y = y; 
	}
	
	public int getMazeTabCoord(int columnCounter) {
		return x+columnCounter*y; 
	}

	public int getY() {
		return y; 
	}
	
	public int getX() {
		return x; 
	}
}

