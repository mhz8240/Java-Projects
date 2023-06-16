import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main extends JPanel implements ActionListener{
	int w = 800, h = 800;
	static boolean[][] arr = new boolean[10][10];
	static int lowestX;
	static int highestX;
	static int lowestY;
	static int highestY;
	public void paint(Graphics g) {
		super.paintComponent(g);
		int gridLength = 800/arr.length;
		for (int i = gridLength; i < 800; i += gridLength) {
			g.drawLine(0, i, 800, i);
			g.drawLine(i, 0, i, 800); 
		}
		for (int i = lowestX; i <= highestX; i++) {
			for (int j = lowestY; j <= highestY; j++) {
				if (arr[j][i]) {
					g.fillRect(i*gridLength, j*gridLength, gridLength, gridLength);
				}
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		arr[4][4] = true;
//		arr[4][5] = true;
//		arr[5][5] = true;
//		arr[6][5] = true;
//		arr[6][6] = true;
//		arr[6][7] = true;
//		arr[7][7] = true;
		arr[8][8] = true;
		arr[7][7] = true;
		arr[7][8] = true;
		arr[7][6] = true;
		lowestX = 6;
		highestX = 8;
		lowestY = 7;
		highestY = 8;
		Main d = new Main();
		Scanner scanner = new Scanner(System.in);
		boolean repeat = true;
		while (repeat) {
			System.out.println("Enter \"y\" if you want to move on to the next iteration. "
					+ "If you want to stop the game, enter \"n\"");
			String s = scanner.next();
			if (s.equals("n")) {
				repeat = false;
			}
			if (s.equals("y")) {
				
				resize();
				change();
				resetVars();
			}
		}
		
	}	
	public static void resize() {
		boolean boundary = false;
		int length = arr.length;
		
		if (length == 800) {
			return;
		}
		for (int i = 1; i < length; i++) {
			if (arr[1][i] || arr[length-2][i] || arr[i][1] || arr[length-2][i]) {
				boundary = true;
			}
		}
			if (boundary) {
//				System.out.println("here");
				if (length == 160) {
					length = 800;
				}
				else {
					length*=2;
				}
				boolean[][] newArr = new boolean[length][length];
				int distX = highestX-lowestX;
				int distY = highestY - lowestY;
				int addX = length/2 - distX/2 - lowestX;
				int addY = length/2 - distY/2 - lowestY;
				for (int a = lowestX; a <= highestX; a++) {
					for (int b = lowestY; b <= highestY; b++) {
						newArr[b+addY][a + addX] = arr[b][a];
					}
				}
				lowestX += addX;
				lowestY += addY;
				highestX += addX;
				highestY += addY;
//				System.out.println(lowestX + " " + highestX + " " + lowestY + " " + highestY);
//
				arr = newArr.clone();
			}
		}
	

	public static void resetVars() {
		int i = lowestX-1;
		boolean over = false;
		while (i<=highestX+1 && !over) {
			for (int j = lowestY-1; j <=highestY+1;j++) {
				if (arr[j][i]) {
					lowestX=i;
					over = true;
					break;
				}
			}
			i++;
		}
		i=highestX+1;
		over = false;
		while (i>=lowestX-1 && !over) {
			for (int j = lowestY-1; j <=highestY+1;j++) {
				if (arr[j][i]) {
					highestX=i;
					over = true;
					break;
				}
			}
			i--;
		}
		i=lowestY-1;
		over = false;
		while (i<=highestY+1 && !over) {
			for (int j = lowestX-1; j <=highestX+1;j++) {
				if (arr[i][j]) {
					lowestY=i;
					over = true;
					break;
				}
			}
			i++;
		}
		i=highestY+1;
		over = false;
//		System.out.println(lowestX + " " + highestX + " " + lowestY + " " + highestY);
		while (i>=lowestY-1 && !over) {
			for (int j = lowestX-1; j <=highestX+1;j++) {
//				System.out.println(i + " " + j);
				if (arr[i][j]) {
					highestY=i;
					over = true;
					break;
				}
			}
			i--;
		}
	}
	public static void change() {
		boolean[][] temp = new boolean[arr.length][arr.length];
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp.length; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		for (int i = lowestX-1; i <= highestX+1;i++) {
			for (int j = lowestY-1; j <= highestY+1; j++) {
				int count = 0;
				if (!arr[j][i]) {
					for (int a = i-1; a <= i+1; a++) {
						for (int b = j-1; b<=j+1; b++) {
							if (arr[b][a]) {
								count++;
							}
						}
					}
					if (count == 3) {
						temp[j][i] = true;
					}
				}
				count = 0;
				if (arr[j][i]) {
					for (int a = i-1; a <= i+1; a++) {
						for (int b = j-1; b<=j+1; b++) {
							if (a == i && b == j) {
								continue;
							}
							if (arr[b][a]) {
								count++;
							}
						}
					}
					if (count < 2 || count > 3) {
						temp[j][i] = false;
					}
				}
			}
		}
//		for (boolean[] arr1 : arr) {
//			for (boolean b : arr1) {
//				System.out.print(b + " ");
//			}
//			System.out.println();
//		}
		arr = temp.clone();
	}
	public Main() {

		JFrame f = new JFrame();
		f.setTitle("GameofLife");
		f.setSize(w, h);
		f.setBackground(Color.BLACK);
		f.setResizable(false);

		f.add(this);
		
		
		t = new Timer(17, this);
		
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

	}

	Timer t;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}
}
