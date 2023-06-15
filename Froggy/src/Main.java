import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//Problem - A frog is on a 3x3 grid and is allowed to move 1 unit at a time 
// up, down, left, or right. The direction it chooses to move is random, 
// and it is allowed to move off of the grid. Given a starting point and a destination on the grid, 
// compute the probability that the frog will reach the destination before moving off the grid.
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Coordinate> stack = new Stack<>();
		//grid: x goes from 1 to 3, y goes from 1,3
		Coordinate c = new Coordinate(1,1);
		c.probability = 1.0;
		stack.push(c);
		double prob = dfs(stack, 2, 2);
		//calculate the probability that the frog will leap to 2,2 before leaping off of the grid
		System.out.println(prob);
	}
	public static double dfs(Stack<Coordinate> stack, int destX, int destY) {
		Coordinate[][] visited = new Coordinate[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				visited[i][j] = new Coordinate(i,j);
			}
		}
		double totalProbability = 0.0;
		while (!stack.isEmpty()) {
			boolean end = false;
			Coordinate c = stack.pop();
			int x = c.x;
			int y = c.y;
			if (c.probability != 1.0) {
				Coordinate previous = c.prev;
				tracePath(visited, previous);
				c.probability = previous.probability / previous.neighbors;
				previous.next = c;
			}
			if (x == 0 || x == 4 || y == 0 || y == 4) {
				
				end = true;
			}
			if (x == destX && y == destY) {
				totalProbability += c.probability;
				end = true;
			}
			if (!end) {
				visited[x][y] = c;
				c.visited = true;
				
				
				
				
				
				int neighbors = 0;
				//left node
				if (!visited[x-1][y].visited) {
					neighbors++;
					Coordinate left = new Coordinate(x-1,y);
					stack.push(left);
					left.prev = c;
				}
				//right node
				if (!visited[x+1][y].visited) {
					neighbors++;
					Coordinate right = new Coordinate(x+1,y);
					stack.push(right);
					right.prev = c;
				}
				//down node
				if (!visited[x][y-1].visited) {
					neighbors++;
					Coordinate down = new Coordinate(x,y-1);
					stack.push(down);
					down.prev = c;
					
				}
				//up node
				if (!visited[x][y+1].visited) {
					neighbors++;
					Coordinate up = new Coordinate(x,y+1);
					stack.push(up);
					up.prev = c;
				}
				c.neighbors = neighbors;
			}
		
		}
		return totalProbability;
	}
	
	public static void tracePath(Coordinate[][] visited, Coordinate coor) {
		while (!(coor.next == null)) {
			coor = coor.next;
			visited[coor.x][coor.y].visited = false;
		}
	}
}
