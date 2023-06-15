
public class Coordinate {
	public int x;
	public int y;
	public boolean visited;
	public double probability;
	public int neighbors;
	public Coordinate prev;
	public Coordinate next;
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
		visited = false;
		probability = 0.0;
		neighbors = 0;
		prev = null;
		next = null;
	}
}
