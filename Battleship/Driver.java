import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Driver extends JPanel implements ActionListener{
	public static void PlaySound(File sound) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));
			clip.start();

			Thread.sleep(clip.getMicrosecondLength() / 1000);
		} catch (Exception e) {

		}
	}
	int width = 800;
	int height = 800;
	//create background.java
	static File Victory = new File("BattleShip_Victory.wav");
	static File Defeat = new File("BattleShip_Defeat.wav");
	static File Explosion = new File("BattleShip_Explosion.wav");
	static File Miss = new File("BattleShip_Miss.wav");
	Background bg;
	static boolean youWon;
	static boolean oppWon;
	static Ships two1;
	static Ships two2;
	static Ships three1;
	static Ships three2;
	static Ships three3;
	static Ships four1;
	static Ships four2;
	static Ships five1;
	static ArrayList<Coordinate> five;
	static ArrayList<Coordinate> firstFour;
	static ArrayList<Coordinate> secondFour;
	static ArrayList<Coordinate> firstThree;
	static ArrayList<Coordinate> secondThree;
	static ArrayList<Coordinate> thirdThree;
	static ArrayList<Coordinate> firstTwo;
	static ArrayList<Coordinate> secondTwo;
	static ArrayList<Coordinate> fiveNPC;
	static ArrayList<Coordinate> fourNPC1;
	static ArrayList<Coordinate> fourNPC2;
	static ArrayList<Coordinate> threeNPC1;
	static ArrayList<Coordinate> threeNPC2;
	static ArrayList<Coordinate> threeNPC3;
	static ArrayList<Coordinate> twoNPC1;
	static ArrayList<Coordinate> twoNPC2;
	static ArrayList<Coordinate> painted;
	static ArrayList<Coordinate> painted1;
	static Driver2 d1;
	public void paint(Graphics g) {
		Graphics2D gd = (Graphics2D) g;
		super.paintComponent(gd);
		bg.paint(gd);
		two1.paint(gd);
		two2.paint(gd);
		three1.paint(gd);
		three2.paint(gd);
		three3.paint(gd);
		four1.paint(gd);
		four2.paint(gd);
		
		five1.paint(gd);
		d1.updateArray(painted1);
		for (Coordinate c : painted) {
			c.paint(g);
		}
//		for (Coordinate c : painted1) {
//			c.paint(g);
//		}
		//notes:
		//make sure to check if the coordinates aren't too high or too low
		//make sure to check for visited coordinates
	
		//make sure to check for input format error
		
		
	}
	//don't need to alter the isValid method. Leave it as is.
	public static boolean isValid(ArrayList<Coordinate> coors) {
		for (Coordinate c: coors) {
			if (c.getX() < 0 || c.getX()>9) {
				return false;
			}
			if (c.getY() < 0 || c.getY()>9) {
				return false;
			}
		}
		return true;
//		boolean xEqual = true;
//		boolean yEqual = true;
//		boolean xConsecutive = true;
//		boolean yConsecutive = true;
//		ArrayList<Integer> xCoors = new ArrayList<>();
//		ArrayList<Integer> yCoors = new ArrayList<>();
//		for (Coordinate c : coors) {
//			xCoors.add(c.getX());
//			yCoors.add(c.getY());
//		}
//		Collections.sort(xCoors);
//		Collections.sort(yCoors);
//		int prevEqual = xCoors.get(0);
//		int prevCons = prevEqual-1;
//		for (int i : xCoors) {
//			if (i != prevEqual) {
//				xEqual = false;
//			}
//			if (i != prevCons+1) {
//				xConsecutive = false;
//			}
//			prevEqual = i;
//			prevCons = i;
//		}
//		prevEqual = yCoors.get(0);
//		prevCons = prevEqual-1;
//		for (int i : yCoors) {
//			if (i != prevEqual) {
//				yEqual = false;
//			}
//			if (i != prevCons+1) {
//				yConsecutive = false;
//			}
//			prevEqual = i;
//			prevCons = i;
//		}
//		if ((xEqual && yConsecutive) || (xConsecutive && yEqual)) {
//			return true;
//		}
//		return false;
	}
	
	public static boolean overlap(ArrayList<Coordinate> coors, boolean[][] visited) {
		for (Coordinate c : coors) {
			if (visited[c.getX()][c.getY()]) {
				return true;
			}
			
		}
		return false;
	}
	public static void main(String[] args) {
//		// TODO Auto-generated method stub
////		String[] fiveBoat = new String[5];
		
		boolean[][] arr = new boolean[10][10];
		String[][] valueArr = new String[10][10];
		//opponent's grid
		boolean[][] arr1 = new boolean[10][10];
		String[][] valueArr1 = new String[10][10];
		for(int r = 0; r<arr.length; r++) {
			for(int c = 0; c<arr[r].length; c++) {
				arr[r][c] = false;
			}
		}
		boolean isValid = false;
		System.out.println("You will input coordinates for one 5 unit boat, two 4 unit boats, three 3 unit boats, and two 2 unit boats.");
		
		while (!isValid) {
			System.out.println("Please input the beginning of the boat coordinates and whether it is horizontal or not for the 5 unit boat in the format: x,y,true/false");
			five = new ArrayList<>();
				Scanner scanner = new Scanner(System.in);
				String s = scanner.nextLine();
				int x = 0;
				int y = 0;
				boolean horizontal = true;
				boolean format = true;
				String z = "";
				//first scan everything in and then add to the arrays
				try {
				x = Integer.parseInt(s.substring(0,1));
				 y = Integer.parseInt(s.substring(2,3));
				 horizontal = true;
				 z = s.substring(4,5);
				}
				catch(Exception e) {
					System.out.println("Input format error");
					format = false;
				}
				if (format) {
					if(z.equals("f")) {
						horizontal = false;
						Coordinate coor = new Coordinate(x,y, false);
						five.add(coor);
//						arr[x][y] = true;
//						valueArr[x][y] = "five";
						coor = new Coordinate(x,y+1, false);
						five.add(coor);
//						arr[x][y+1] = true;
//						valueArr[x][y+1] = "five";
						coor = new Coordinate(x,y+2, false);
						five.add(coor);
//						arr[x][y+2] = true;
//						valueArr[x][y+2] = "five";
						coor = new Coordinate(x,y+3, false);
						five.add(coor);
//						arr[x][y+3] = true;
//						valueArr[x][y+3] = "five";
						coor = new Coordinate(x,y+4, false);
						five.add(coor);
//						arr[x][y+4] = true;
//						valueArr[x][y+4] = "five";
//						five1 = new Ships(x*80, y*80, horizontal, "5ship.png");
						//maybe sort?
						//sort using an integer arr
					}else {
						Coordinate coor = new Coordinate(x,y, true);
						five.add(coor);
//						arr[x][y] = true;
//						valueArr[x][y] = "five";
						coor = new Coordinate(x+1,y, true);
						five.add(coor);
//						arr[x+1][y] = true;
//						valueArr[x+1][y] = "five";
						coor = new Coordinate(x+2,y, true);
						five.add(coor);
//						arr[x+2][y] = true;
//						valueArr[x+2][y] = "five";
						coor = new Coordinate(x+3,y, true);
						five.add(coor);
//						arr[x+3][y] = true;
//						valueArr[x+3][y] = "five";
						coor = new Coordinate(x+4,y, true);
						five.add(coor);
//						arr[x+4][y] = true;
//						valueArr[x+4][y] = "five";
					}
					isValid = isValid(five);
					if (!isValid) {
						System.out.println("Invalid boat input");
					}
				}
				
		}
		
		
		//after you make sure that the values are valid, then put it in the arrays
		for (Coordinate c : five) {
			arr[c.getX()][c.getY()] = true;
			valueArr[c.getX()][c.getY()] = "five";
		}
		//first four unit ship
		
		isValid = false;
		boolean overlap = false;
		while (!isValid || overlap) {
			System.out.println("Please input the beginning of the boat coordinates and whether it is horizontal or not for the first 4 unit boat in the format: x,y,true/false");
			firstFour = new ArrayList<>();
				Scanner scanner = new Scanner(System.in);
				String s = scanner.nextLine();
				int x = 0;
				int y = 0;
				boolean horizontal = true;
				boolean format = true;
				String z = "";
				//first scan everything in and then add to the arrays
				try {
				x = Integer.parseInt(s.substring(0,1));
				 y = Integer.parseInt(s.substring(2,3));
				 horizontal = true;
				 z = s.substring(4,5);
				}
				catch(Exception e) {
					System.out.println("Input format error");
					format = false;
				}
				if (format) {
				if(z.equals("f")) {
				Coordinate coor = new Coordinate(x,y, false);
				firstFour.add(coor);
//				arr[x][y] = true;
//				valueArr[x][y] = "five";
				coor = new Coordinate(x,y+1, false);
				firstFour.add(coor);
//				arr[x][y+1] = true;
				coor = new Coordinate(x,y+2, false);
				firstFour.add(coor);
//				arr[x][y+2] = true;
				coor = new Coordinate(x,y+3, false);
				firstFour.add(coor);
//				arr[x][y+3] = true;
				
				//maybe sort?
				//sort using an integer arr
			}else {
				Coordinate coor = new Coordinate(x,y, true);
				firstFour.add(coor);
//				arr[x][y] = true;
				coor = new Coordinate(x+1,y, true);
				firstFour.add(coor);
//				arr[x+1][y] = true;
				coor = new Coordinate(x+2,y, true);
				firstFour.add(coor);
//				arr[x+2][y] = true;
				coor = new Coordinate(x+3,y, true);
				firstFour.add(coor);
//				arr[x+3][y] = true;
			}
			isValid = isValid(firstFour);
			if (!isValid) {
				System.out.println("Invalid boat input");
			}
			else {
			overlap = overlap(firstFour, arr);
			}
			if (overlap) {
				System.out.println("Overlapping ships");
			}
				}
		}
		for (Coordinate c : firstFour) {
			arr[c.getX()][c.getY()] = true;
			valueArr[c.getX()][c.getY()] = "firstFour";
		}
		
		//four2
		isValid = false;
		overlap = false;
		while (!isValid || overlap) {
			System.out.println("Please input the beginning of the boat coordinates and whether it is horizontal or not for the second 4 unit boat in the format: x,y,true/false");
			secondFour = new ArrayList<>();
				Scanner scanner = new Scanner(System.in);
				String s = scanner.nextLine();
				int x = 0;
				int y = 0;
				boolean horizontal = true;
				boolean format = true;
				String z = "";
				//first scan everything in and then add to the arrays
				try {
				x = Integer.parseInt(s.substring(0,1));
				 y = Integer.parseInt(s.substring(2,3));
				 horizontal = true;
				 z = s.substring(4,5);
				}
				catch(Exception e) {
					System.out.println("Input format error");
					format = false;
				}
				if (format) {
				if(z.equals("f")) {
				Coordinate coor = new Coordinate(x,y, false);
				secondFour.add(coor);
//				arr[x][y] = true;
				coor = new Coordinate(x,y+1, false);
				secondFour.add(coor);
//				arr[x][y+1] = true;
				coor = new Coordinate(x,y+2, false);
				secondFour.add(coor);
//				arr[x][y+2] = true;
				coor = new Coordinate(x,y+3, false);
				secondFour.add(coor);
//				arr[x][y+3] = true;
				
				//maybe sort?
				//sort using an integer arr
			}else {
				Coordinate coor = new Coordinate(x,y, true);
				secondFour.add(coor);
//				arr[x][y] = true;
				coor = new Coordinate(x+1,y, true);
				secondFour.add(coor);
//				arr[x+1][y] = true;
				coor = new Coordinate(x+2,y, true);
				secondFour.add(coor);
//				arr[x+2][y] = true;
				coor = new Coordinate(x+3,y, true);
				secondFour.add(coor);
//				arr[x+3][y] = true;
			}
			isValid = isValid(secondFour);
			if (!isValid) {
				System.out.println("Invalid boat input");
			}
			else {
			overlap = overlap(secondFour, arr);
			}
			if (overlap) {
				System.out.println("Overlapping ships");
			}
		}
		}
		for (Coordinate c : secondFour) {
			arr[c.getX()][c.getY()] = true;
			valueArr[c.getX()][c.getY()] = "secondFour";
		}
		
		//first three unit boat
		isValid = false;
		
		while (!isValid || overlap) {
			System.out.println("Please input the beginning of the boat coordinates and whether it is horizontal or not for the first 3 unit boat in the format: x,y,true/false");
			firstThree = new ArrayList<>();
				Scanner scanner = new Scanner(System.in);
				String s = scanner.nextLine();
				int x = 0;
				int y = 0;
				boolean horizontal = true;
				boolean format = true;
				String z = "";
				//first scan everything in and then add to the arrays
				try {
				x = Integer.parseInt(s.substring(0,1));
				 y = Integer.parseInt(s.substring(2,3));
				 horizontal = true;
				 z = s.substring(4,5);
				}
				catch(Exception e) {
					System.out.println("Input format error");
					format = false;
				}
				if (format) {
				if(z.equals("f")) {
				Coordinate coor = new Coordinate(x,y, false);
				firstThree.add(coor);
//				arr[x][y] = true;
				coor = new Coordinate(x,y+1, false);
				firstThree.add(coor);
//				arr[x][y+1] = true;
				coor = new Coordinate(x,y+2, false);
				firstThree.add(coor);
//				arr[x][y+2] = true;
				
				//maybe sort?
				//sort using an integer arr
			}else {
				Coordinate coor = new Coordinate(x,y, true);
				firstThree.add(coor);
//				arr[x][y] = true;
				coor = new Coordinate(x+1,y, true);
				firstThree.add(coor);
//				arr[x+1][y] = true;
				coor = new Coordinate(x+2,y, true);
				firstThree.add(coor);
//				arr[x+2][y] = true;
			}
			isValid = isValid(firstThree);
			if (!isValid) {
				System.out.println("Invalid boat input");
			}
			else {
			overlap = overlap(firstThree, arr);
			}
			if (overlap) {
				System.out.println("Overlapping ships");
			}
				}
		}
		for (Coordinate c : firstThree) {
			arr[c.getX()][c.getY()] = true;
			valueArr[c.getX()][c.getY()] = "firstThree";
		}
		
		
		//second 3 unit boat
		isValid = false;
		while (!isValid || overlap) {
			System.out.println("Please input the beginning of the boat coordinates and whether it is horizontal or not for the second 3 unit boat in the format: x,y,true/false");
			secondThree = new ArrayList<>();
				Scanner scanner = new Scanner(System.in);
				String s = scanner.nextLine();
				int x = 0;
				int y = 0;
				boolean horizontal = true;
				boolean format = true;
				String z = "";
				//first scan everything in and then add to the arrays
				try {
				x = Integer.parseInt(s.substring(0,1));
				 y = Integer.parseInt(s.substring(2,3));
				 horizontal = true;
				 z = s.substring(4,5);
				}
				catch(Exception e) {
					System.out.println("Input format error");
					format = false;
				}
				if (format) {
				if(z.equals("f")) {
				Coordinate coor = new Coordinate(x,y, false);
				secondThree.add(coor);
//				arr[x][y] = true;
				coor = new Coordinate(x,y+1, false);
				secondThree.add(coor);
//				arr[x][y+1] = true;
				coor = new Coordinate(x,y+2, false);
				secondThree.add(coor);
//				arr[x][y+2] = true;
				
				//maybe sort?
				//sort using an integer arr
			}else {
				Coordinate coor = new Coordinate(x,y, true);
				secondThree.add(coor);
//				arr[x][y] = true;
				coor = new Coordinate(x+1,y, true);
				secondThree.add(coor);
//				arr[x+1][y] = true;
				coor = new Coordinate(x+2,y, true);
				secondThree.add(coor);
//				arr[x+2][y] = true;
			}
			isValid = isValid(secondThree);
			if (!isValid) {
				System.out.println("Invalid boat input");
			}
			else {
			overlap = overlap(secondThree, arr);
			}
			if (overlap) {
				System.out.println("Overlapping ships");
			}
		}
		}
		for (Coordinate c : secondThree) {
			arr[c.getX()][c.getY()] = true;
			valueArr[c.getX()][c.getY()] = "secondThree";
		}
		
		
		//third 3 unit boat
		isValid = false;
		
		while (!isValid || overlap) {
			System.out.println("Please input the beginning of the boat coordinates and whether it is horizontal or not for the third 3 unit boat in the format: x,y,true/false");
			thirdThree = new ArrayList<>();
				Scanner scanner = new Scanner(System.in);
				String s = scanner.nextLine();
				int x = 0;
				int y = 0;
				boolean horizontal = true;
				boolean format = true;
				String z = "";
				//first scan everything in and then add to the arrays
				try {
				x = Integer.parseInt(s.substring(0,1));
				 y = Integer.parseInt(s.substring(2,3));
				 horizontal = true;
				 z = s.substring(4,5);
				}
				catch(Exception e) {
					System.out.println("Input format error");
					format = false;
				}
				if (format) {
				if(z.equals("f")) {
				Coordinate coor = new Coordinate(x,y, false);
				thirdThree.add(coor);
//				arr[x][y] = true;
				coor = new Coordinate(x,y+1, false);
				thirdThree.add(coor);
//				arr[x][y+1] = true;
				coor = new Coordinate(x,y+2, false);
				thirdThree.add(coor);
//				arr[x][y+2] = true;
				
				//maybe sort?
				//sort using an integer arr
			}else {
				Coordinate coor = new Coordinate(x,y, true);
				thirdThree.add(coor);
//				arr[x][y] = true;
				coor = new Coordinate(x+1,y, true);
				thirdThree.add(coor);
//				arr[x+1][y] = true;
				coor = new Coordinate(x+2,y, true);
				thirdThree.add(coor);
//				arr[x+2][y] = true;
			}
			isValid = isValid(thirdThree);
			if (!isValid) {
				System.out.println("Invalid boat input");
			}
			else {
			overlap = overlap(thirdThree, arr);
			}
			if (overlap) {
				System.out.println("Overlapping ships");
			}
		}
		}
		for (Coordinate c : thirdThree) {
			arr[c.getX()][c.getY()] = true;
			valueArr[c.getX()][c.getY()] = "thirdThree";
		}
		
		
//		//first 2 unit boat
		isValid = false;
		
		while (!isValid || overlap) {
			System.out.println("Please input the beginning of the boat coordinates and whether it is horizontal or not for the first 2 unit boat in the format: x,y,true/false");
			firstTwo = new ArrayList<>();
				Scanner scanner = new Scanner(System.in);
				String s = scanner.nextLine();
				int x = 0;
				int y = 0;
				boolean horizontal = true;
				boolean format = true;
				String z = "";
				//first scan everything in and then add to the arrays
				try {
				x = Integer.parseInt(s.substring(0,1));
				 y = Integer.parseInt(s.substring(2,3));
				 horizontal = true;
				 z = s.substring(4,5);
				}
				catch(Exception e) {
					System.out.println("Input format error");
					format = false;
				}
				if (format) {
				if(z.equals("f")) {
				Coordinate coor = new Coordinate(x,y, false);
				firstTwo.add(coor);
//				arr[x][y] = true;
				coor = new Coordinate(x,y+1, false);
				firstTwo.add(coor);
//				arr[x][y+1] = true;
				
				//maybe sort?
				//sort using an integer arr
			}else {
				Coordinate coor = new Coordinate(x,y, true);
				firstTwo.add(coor);
//				arr[x][y] = true;
				coor = new Coordinate(x+1,y, true);
				firstTwo.add(coor);
//				arr[x+1][y] = true;
			}
			isValid = isValid(firstTwo);
			if (!isValid) {
				System.out.println("Invalid boat input");
			}
			else {
			overlap = overlap(firstTwo, arr);
			}
			if (overlap) {
				System.out.println("Overlapping ships");
			}
		}
		}
		for (Coordinate c : firstTwo) {
			arr[c.getX()][c.getY()] = true;
			valueArr[c.getX()][c.getY()] = "firstTwo";
		}
		
		
		//second 2 unit boat
		isValid = false;
		
		while (!isValid || overlap) {
			System.out.println("Please input the beginning of the boat coordinates and whether it is horizontal or not for the second 2 unit boat in the format: x,y,true/false");
			secondTwo = new ArrayList<>();
				Scanner scanner = new Scanner(System.in);
				String s = scanner.nextLine();
				int x = 0;
				int y = 0;
				boolean horizontal = true;
				boolean format = true;
				String z = "";
				//first scan everything in and then add to the arrays
				try {
				x = Integer.parseInt(s.substring(0,1));
				 y = Integer.parseInt(s.substring(2,3));
				 horizontal = true;
				 z = s.substring(4,5);
				}
				catch(Exception e) {
					System.out.println("Input format error");
					format = false;
				}
				if (format) {
				if(z.equals("f")) {
				Coordinate coor = new Coordinate(x,y, false);
				secondTwo.add(coor);
//				arr[x][y] = true;
				coor = new Coordinate(x,y+1, false);
				secondTwo.add(coor);
//				arr[x][y+1] = true;
				
				//maybe sort?
				//sort using an integer arr
			}else {
				Coordinate coor = new Coordinate(x,y, true);
				secondTwo.add(coor);
//				arr[x][y] = true;
				coor = new Coordinate(x+1,y, true);
				secondTwo.add(coor);
//				arr[x+1][y] = true;
			}
			isValid = isValid(secondTwo);
			if (!isValid) {
				System.out.println("Invalid boat input");
			}
			else {
			overlap = overlap(secondTwo, arr);
			}
			if (overlap) {
				System.out.println("Overlapping ships");
			}
		}
		}
		for (Coordinate c : secondTwo) {
			arr[c.getX()][c.getY()] = true;
			valueArr[c.getX()][c.getY()] = "secondTwo";
		}
		
//		Driver d = new Driver();
		/////////////////////////////////////////////////////
		//NPC BOATS
		
		isValid=false;
		
		while (!isValid) {
			fiveNPC = new ArrayList<>();
			//change these: get rid of the +1	
			int x = (int)(Math.random()*10);
				int y = (int)(Math.random()*10);
				int z = (int)(Math.random()*2);
				String w = "a";
				if(z == 0) {
					w = "f";
				}else {
					w = "t";
				}
				if(w.equals("f")) {
				Coordinate coor = new Coordinate(x,y, false);
				fiveNPC.add(coor);
//				arr1[x][y] = true;
				coor = new Coordinate(x,y+1, false);
				fiveNPC.add(coor);
//				arr1[x][y+1] = true;
				coor = new Coordinate(x,y+2, false);
				fiveNPC.add(coor);
//				arr1[x][y+2] = true;
				coor = new Coordinate(x,y+3, false);
				fiveNPC.add(coor);
//				arr1[x][y+3] = true;
				coor = new Coordinate(x,y+4, false);
				fiveNPC.add(coor);
//				arr1[x][y+4] = true;
				
				//maybe sort?
				//sort using an integer arr
			}else {
				Coordinate coor = new Coordinate(x,y, true);
				fiveNPC.add(coor);
//				arr1[x][y] = true;
				coor = new Coordinate(x+1,y, true);
				fiveNPC.add(coor);
//				arr1[x+1][y] = true;
				coor = new Coordinate(x+2,y, true);
				fiveNPC.add(coor);
//				arr1[x+2][y] = true;
				coor = new Coordinate(x+3,y, true);
				fiveNPC.add(coor);
//				arr1[x+3][y] = true;
				coor = new Coordinate(x+4,y, true);
				fiveNPC.add(coor);
//				arr1[x+4][y] = true;
			}
		
			isValid = isValid(fiveNPC);
			if (!isValid) {
//				System.out.println("Invalid boat input");
			}
			
		}
		for (Coordinate c : fiveNPC) {
			arr1[c.getX()][c.getY()] = true;
			valueArr1[c.getX()][c.getY()] = "five";
		}
		
		
		
		//fourNPC1
		
		isValid=false;
		while (!isValid || overlap) {
			fourNPC1 = new ArrayList<>();
				int x = (int)(Math.random()*10);
				int y = (int)(Math.random()*10);
				int z = (int)(Math.random()*2);
				String w = "a";
				if(z == 0) {
					w = "f";
				}else {
					w = "t";
				}
				if(w.equals("f")) {
				Coordinate coor = new Coordinate(x,y, false);
				fourNPC1.add(coor);
//				arr1[x][y] = true;
				coor = new Coordinate(x,y+1, false);
				fourNPC1.add(coor);
//				arr1[x][y+1] = true;
				coor = new Coordinate(x,y+2, false);
				fourNPC1.add(coor);
//				arr1[x][y+2] = true;
				coor = new Coordinate(x,y+3, false);
				fourNPC1.add(coor);
//				arr1[x][y+3] = true;
				
				//maybe sort?
				//sort using an integer arr
			}else {
				Coordinate coor = new Coordinate(x,y, true);
				fourNPC1.add(coor);
//				arr1[x][y] = true;
				coor = new Coordinate(x+1,y, true);
				fourNPC1.add(coor);
//				arr1[x+1][y] = true;
				coor = new Coordinate(x+2,y, true);
				fourNPC1.add(coor);
//				arr1[x+2][y] = true;
				coor = new Coordinate(x+3,y, true);
				fourNPC1.add(coor);
//				arr1[x+3][y] = true;
			}
			isValid = isValid(fourNPC1);
			if (!isValid) {
//				System.out.println("Invalid boat input");
			}
			else {
			overlap = overlap(fourNPC1, arr1);
			}
			if (overlap) {
//				System.out.println("Overlapping ships");
			}
		
		}
		for (Coordinate c : fourNPC1) {
			arr1[c.getX()][c.getY()] = true;
			valueArr1[c.getX()][c.getY()] = "fourNPC1";
		}
		
		
		//fourNPC2
	
		isValid=false;
		while (!isValid || overlap) {
			fourNPC2 = new ArrayList<>();
				int x = (int)(Math.random()*10);
				int y = (int)(Math.random()*10);
				int z = (int)(Math.random()*2);
				String w = "a";
				if(z == 0) {
					w = "f";
				}else {
					w = "t";
				}
				if(w.equals("f")) {
				Coordinate coor = new Coordinate(x,y, false);
				fourNPC2.add(coor);
//				arr1[x][y] = true;
				coor = new Coordinate(x,y+1, false);
				fourNPC2.add(coor);
//				arr1[x][y+1] = true;
				coor = new Coordinate(x,y+2, false);
				fourNPC2.add(coor);
//				arr1[x][y+2] = true;
				coor = new Coordinate(x,y+3, false);
				fourNPC2.add(coor);
//				arr1[x][y+3] = true;
				
				//maybe sort?
				//sort using an integer arr
			}else {
				Coordinate coor = new Coordinate(x,y, true);
				fourNPC2.add(coor);
//				arr1[x][y] = true;
				coor = new Coordinate(x+1,y, true);
				fourNPC2.add(coor);
//				arr1[x+1][y] = true;
				coor = new Coordinate(x+2,y, true);
				fourNPC2.add(coor);
//				arr1[x+2][y] = true;
				coor = new Coordinate(x+3,y, true);
				fourNPC2.add(coor);
//				arr1[x+3][y] = true;
			}
			isValid = isValid(fourNPC2);
			if (!isValid) {
//				System.out.println("Invalid boat input");
			}
			else {
			overlap = overlap(fourNPC2, arr1);
			}
			if (overlap) {
//				System.out.println("Overlapping ships");
			}
		}
		for (Coordinate c : fourNPC2) {
			arr1[c.getX()][c.getY()] = true;
			valueArr1[c.getX()][c.getY()] = "fourNPC2";
		}
		
		
		//first 3 unit boat
		
		isValid=false;
		while (!isValid || overlap) {
			threeNPC1 = new ArrayList<>();
				int x = (int)(Math.random()*10);
				int y = (int)(Math.random()*10);
				int z = (int)(Math.random()*2);
				String w = "a";
				if(z == 0) {
					w = "f";
				}else {
					w = "t";
				}
				if(w.equals("f")) {
				Coordinate coor = new Coordinate(x,y, false);
				threeNPC1.add(coor);
//				arr1[x][y] = true;
				coor = new Coordinate(x,y+1, false);
				threeNPC1.add(coor);
//				arr1[x][y+1] = true;
				coor = new Coordinate(x,y+2, false);
				threeNPC1.add(coor);
//				arr1[x][y+2] = true;
				
				//maybe sort?
				//sort using an integer arr
			}else {
				Coordinate coor = new Coordinate(x,y, true);
				threeNPC1.add(coor);
//				arr1[x][y] = true;
				coor = new Coordinate(x+1,y, true);
				threeNPC1.add(coor);
//				arr1[x+1][y] = true;
				coor = new Coordinate(x+2,y, true);
				threeNPC1.add(coor);
//				arr1[x+2][y] = true;
			}
			isValid = isValid(threeNPC1);
			if (!isValid) {
//				System.out.println("Invalid boat input");
			}
			else {
			overlap = overlap(threeNPC1, arr1);
			}
			if (overlap) {
//				System.out.println("Overlapping ships");
			}
		}
		for (Coordinate c : threeNPC1) {
			arr1[c.getX()][c.getY()] = true;
			valueArr1[c.getX()][c.getY()] = "threeNPC1";
		}
		
		
		//second 3 unit boat
		
		isValid=false;
		while (!isValid || overlap) {
			threeNPC2 = new ArrayList<>();
				int x = (int)(Math.random()*10);
				int y = (int)(Math.random()*10);
				int z = (int)(Math.random()*2);
				String w = "a";
				if(z == 0) {
					w = "f";
				}else {
					w = "t";
				}
				if(w.equals("f")) {
				Coordinate coor = new Coordinate(x,y, false);
				threeNPC2.add(coor);
//				arr1[x][y] = true;
				coor = new Coordinate(x,y+1, false);
				threeNPC2.add(coor);
//				arr1[x][y+1] = true;
				coor = new Coordinate(x,y+2, false);
				threeNPC2.add(coor);
//				arr1[x][y+2] = true;
				
				//maybe sort?
				//sort using an integer arr
			}else {
				Coordinate coor = new Coordinate(x,y, true);
				threeNPC2.add(coor);
//				arr1[x][y] = true;
				coor = new Coordinate(x+1,y, true);
				threeNPC2.add(coor);
//				arr1[x+1][y] = true;
				coor = new Coordinate(x+2,y, true);
				threeNPC2.add(coor);
//				arr1[x+2][y] = true;
			}
			isValid = isValid(threeNPC2);
			if (!isValid) {
//				System.out.println("Invalid boat input");
			}
			else {
			overlap = overlap(threeNPC2, arr1);
			}
			if (overlap) {
//				System.out.println("Overlapping ships");
			}
		}
		for (Coordinate c : threeNPC2) {
			arr1[c.getX()][c.getY()] = true;
			valueArr1[c.getX()][c.getY()] = "threeNPC2";
		}
		
		
		//third 3 unit boat

		isValid=false;
		while (!isValid || overlap) {
			threeNPC3 = new ArrayList<>();
				int x = (int)(Math.random()*10);
				int y = (int)(Math.random()*10);
				int z = (int)(Math.random()*2);
				String w = "a";
				if(z == 0) {
					w = "f";
				}else {
					w = "t";
				}
				if(w.equals("f")) {
				Coordinate coor = new Coordinate(x,y, false);
				threeNPC3.add(coor);
//				arr1[x][y] = true;
				coor = new Coordinate(x,y+1, false);
				threeNPC3.add(coor);
//				arr1[x][y+1] = true;
				coor = new Coordinate(x,y+2, false);
				threeNPC3.add(coor);
//				arr1[x][y+2] = true;
				
				//maybe sort?
				//sort using an integer arr
			}else {
				Coordinate coor = new Coordinate(x,y, true);
				threeNPC3.add(coor);
//				arr1[x][y] = true;
				coor = new Coordinate(x+1,y, true);
				threeNPC3.add(coor);
//				arr1[x+1][y] = true;
				coor = new Coordinate(x+2,y, true);
				threeNPC3.add(coor);
//				arr1[x+2][y] = true;
			}
			isValid = isValid(threeNPC3);
			if (!isValid) {
//				System.out.println("Invalid boat input");
			}
			else {
			overlap = overlap(threeNPC3, arr1);
			}
			if (overlap) {
//				System.out.println("Overlapping ships");
			}
		}
		for (Coordinate c : threeNPC3) {
			arr1[c.getX()][c.getY()] = true;
			valueArr1[c.getX()][c.getY()] = "threeNPC3";
		}
		
		
		//first 2 unit boat
	
		isValid=false;
		while (!isValid || overlap) {
			twoNPC1 = new ArrayList<>();
				int x = (int)(Math.random()*10);
				int y = (int)(Math.random()*10);
				int z = (int)(Math.random()*2);
				String w = "a";
				if(z == 0) {
					w = "f";
				}else {
					w = "t";
				}
				if(w.equals("f")) {
				Coordinate coor = new Coordinate(x,y, false);
				twoNPC1.add(coor);
//				arr1[x][y] = true;
				coor = new Coordinate(x,y+1, false);
				twoNPC1.add(coor);
//				arr1[x][y+1] = true;
				
				//maybe sort?
				//sort using an integer arr
			}else {
				Coordinate coor = new Coordinate(x,y, true);
				twoNPC1.add(coor);
//				arr1[x][y] = true;
				coor = new Coordinate(x+1,y, true);
				twoNPC1.add(coor);
//				arr1[x+1][y] = true;
			}
			isValid = isValid(twoNPC1);
			if (!isValid) {
//				System.out.println("Invalid boat input");
			}
			else {
			overlap = overlap(twoNPC1, arr1);
			}
			if (overlap) {
//				System.out.println("Overlapping ships");
			}
		}
		for (Coordinate c : twoNPC1) {
			arr1[c.getX()][c.getY()] = true;
			valueArr1[c.getX()][c.getY()] = "twoNPC1";
		}
		
		//twoNPC2
		
		isValid=false;
		while (!isValid || overlap) {
			twoNPC2 = new ArrayList<>();
				int x = (int)(Math.random()*10);
				int y = (int)(Math.random()*10);
				int z = (int)(Math.random()*2);
				String w = "a";
				if(z == 0) {
					w = "f";
				}else {
					w = "t";
				}
				if(w.equals("f")) {
				Coordinate coor = new Coordinate(x,y, false);
				twoNPC2.add(coor);
//				arr1[x][y] = true;
				coor = new Coordinate(x,y+1, false);
				twoNPC2.add(coor);
//				arr1[x][y+1] = true;
				
				//maybe sort?
				//sort using an integer arr
			}else {
				Coordinate coor = new Coordinate(x,y, true);
				twoNPC2.add(coor);
//				arr1[x][y] = true;
				coor = new Coordinate(x+1,y, true);
				twoNPC2.add(coor);
//				arr1[x+1][y] = true;
			}
			isValid = isValid(twoNPC2);
			if (!isValid) {
//				System.out.println("Invalid boat input");
			}
			else {
			overlap = overlap(twoNPC2, arr1);
			}if (overlap) {
//				System.out.println("Overlapping ships");
			}
		}
		for (Coordinate c : twoNPC2) {
			arr1[c.getX()][c.getY()] = true;
			valueArr1[c.getX()][c.getY()] = "twoNPC2";
		}
		d1 = new Driver2();
		Driver d = new Driver();
		//===============================
		//actual game starts
		//to do: check extraneous inputs 
		boolean over = false;
		boolean[][] guessed = new boolean[10][10];
		ArrayList<Coordinate> cpuGuesses = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				cpuGuesses.add(new Coordinate(i, j, false));
			}
		}
		Scanner scanner = new Scanner(System.in);
		painted = new ArrayList<>();
		painted1 = new ArrayList<>();

		while (!over) {
			boolean valid = false;
			int x = 0;
			int y = 0;
			while (!valid) {
				System.out.println("Take a turn (x,y format)");
				String guess = scanner.nextLine();
				try {
				x = Integer.parseInt(guess.substring(0,1));
				y = Integer.parseInt(guess.substring(2,3));
				}
				catch(Exception e) {
					System.out.println("Input format error");
					continue;
				}
				if ((x < 0 || x > 9) || (y < 0 || y > 9)) {
					valid = false;
				}
				else {
					valid = true;
				}
				if (valid) {
				if (!guessed[x][y]) {
					valid = true;
					
				}
				else {
					valid = false;
					System.out.println("That coordinate has already been guessed. Guess again");
				}
				}
			}
			
			guessed[x][y] = true;
			
			boolean hit = false;
			if (arr1[x][y]) {
				hit = true;
				painted1.add(new Coordinate(x*72 + 73,y*72+73,"explosion.png"));
				arr1[x][y] = false;
				System.out.println("Hit");
				PlaySound(Explosion);
				String ship = valueArr1[x][y];
				//add a method to check if the entire boat has sank
				
				boolean sunk = sinkNPCBoats(ship, x, y);
				if (sunk) {
					System.out.println(ship + " unit boat sunk");
				}
				if (sunk) {
					over = gameOver();
				}
			}
			else {
				painted1.add(new Coordinate(x*72+73,y*72+73,"shotmiss.png"));
				PlaySound(Miss);
			}
			// cpu's turn
			
			int size = cpuGuesses.size();
			int i = (int)(Math.random()*size);
			Coordinate c = cpuGuesses.get(i);
			cpuGuesses.remove(i);
			int oppX = c.getX();
			int oppY = c.getY();
			System.out.println("Opponent guessed: " + oppX + ", " + oppY); 
			if (arr[oppX][oppY]) {
				
				painted.add(new Coordinate(oppX*72+73,oppY*72+73,"explosion.png"));

				arr[oppX][oppY] = false;
				System.out.println("Hit");
				String ship = valueArr[oppX][oppY];
//				System.out.println(ship);
				//add a method to check if the entire boat has sank
				
				boolean sunk = sink(ship, oppX, oppY);
				//method for returning specific number of unit boat?
				if (sunk) {
					System.out.println(ship + " unit boat sunk");
				}
				if (sunk) {
					over = gameOver();
				}
			}else {
				painted.add(new Coordinate(oppX*72+73,oppY*72+73,"shotmiss.png"));

			}
		}
		
		if (over && youWon) {
			System.out.println("You won!!!");
			PlaySound(Victory);
		}else {
			System.out.println("Game over. Better luck next time.");
			PlaySound(Defeat);
		}
	}
	//returns true if the ship has sunk
	public static boolean sink(String ship, int x, int y) {
//		System.out.println(x + y);
		switch(ship) {
		case "five":
			for (int i = 0; i < five.size(); i++) {
				
				if (five.get(i).getX() == x && five.get(i).getY() == y) {
					five.remove(i);
					break;
				}
			}
			if (five.isEmpty()) {
				System.out.println("here");
				return true;
			}
			break;
		case "firstFour":
				for (int i = 0; i < firstFour.size(); i++) {
//					System.out.println("here");
//					System.out.println(firstFour.get(i).getX());
//					System.out.println(x);
//					System.out.println(firstFour.get(i).getY());
//					System.out.println(y);
					if (firstFour.get(i).getX() == x && firstFour.get(i).getY() == y) {
						
						firstFour.remove(i);
						break;
					}
					
				}
				if (firstFour.isEmpty()) {
					return true;
				}
				break;
		case "secondFour":
			for (int i = 0; i < secondFour.size(); i++) {
				if (secondFour.get(i).getX() == x && secondFour.get(i).getY() == y) {
					secondFour.remove(i);
					break;
				}
				
			}
			if (secondFour.isEmpty()) {
				return true;
			}
			break;
		case "firstThree":
			for (int i = 0; i < firstThree.size(); i++) {
				if (firstThree.get(i).getX() == x && firstThree.get(i).getY() == y) {
					firstThree.remove(i);
					break;
				}
				
			}
			if (firstThree.isEmpty()) {
				return true;
			}
			break;
		case "secondThree":
			for (int i = 0; i < secondThree.size(); i++) {
				if (secondThree.get(i).getX() == x && secondThree.get(i).getY() == y) {
					secondThree.remove(i);
					break;
				}
				
			}
			if (secondThree.isEmpty()) {
				return true;
			}
			break;
		case "thirdThree":
			for (int i = 0; i < thirdThree.size(); i++) {
				if (thirdThree.get(i).getX() == x && thirdThree.get(i).getY() == y) {
					thirdThree.remove(i);
					break;
				}
				
			}
			if (thirdThree.isEmpty()) {
				return true;
			}
			break;
		case "firstTwo":
			for (int i = 0; i < firstTwo.size(); i++) {
				if (firstTwo.get(i).getX() == x && firstTwo.get(i).getY() == y) {
					firstTwo.remove(i);
					break;
				}
				
			}
			if (firstTwo.isEmpty()) {
				return true;
			}
			break;
		
		case "secondTwo":
		for (int i = 0; i < secondTwo.size(); i++) {
			if (secondTwo.get(i).getX() == x && secondTwo.get(i).getY() == y) {
				secondTwo.remove(i);
				break;
			}
			
		}
		
		if (secondTwo.isEmpty()) {
			return true;
		}
		break;
	}
	return false;
	}
	
	public static boolean sinkNPCBoats(String ship, int x, int y) {
//		System.out.println(x + y);
		switch(ship) {
		case "five":
			for (int i = 0; i < fiveNPC.size(); i++) {
				
				if (fiveNPC.get(i).getX() == x && fiveNPC.get(i).getY() == y) {
					fiveNPC.remove(i);
					break;
				}
			}
			if (fiveNPC.isEmpty()) {
				System.out.println("here");
				return true;
			}
			break;
		case "fourNPC1":
				for (int i = 0; i < fourNPC1.size(); i++) {
//					System.out.println("here");
//					System.out.println(firstFour.get(i).getX());
//					System.out.println(x);
//					System.out.println(firstFour.get(i).getY());
//					System.out.println(y);
					if (fourNPC1.get(i).getX() == x && fourNPC1.get(i).getY() == y) {
						
						fourNPC1.remove(i);
						break;
					}
					
				}
				if (fourNPC1.isEmpty()) {
					return true;
				}
				break;
		case "fourNPC2":
			for (int i = 0; i < fourNPC2.size(); i++) {
				if (fourNPC2.get(i).getX() == x && fourNPC2.get(i).getY() == y) {
					fourNPC2.remove(i);
					break;
				}
				
			}
			if (fourNPC2.isEmpty()) {
				return true;
			}
			break;
		case "threeNPC1":
			for (int i = 0; i < threeNPC1.size(); i++) {
				if (threeNPC1.get(i).getX() == x && threeNPC1.get(i).getY() == y) {
					threeNPC1.remove(i);
					break;
				}
				
			}
			if (threeNPC1.isEmpty()) {
				return true;
			}
			break;
		case "threeNPC2":
			for (int i = 0; i < threeNPC2.size(); i++) {
				if (threeNPC2.get(i).getX() == x && threeNPC2.get(i).getY() == y) {
					threeNPC2.remove(i);
					break;
				}
				
			}
			if (threeNPC2.isEmpty()) {
				return true;
			}
			break;
		case "threeNPC3":
			for (int i = 0; i < threeNPC3.size(); i++) {
				if (threeNPC3.get(i).getX() == x && threeNPC3.get(i).getY() == y) {
					threeNPC3.remove(i);
					break;
				}
				
			}
			if (threeNPC3.isEmpty()) {
				return true;
			}
			break;
		case "twoNPC1":
			for (int i = 0; i < twoNPC1.size(); i++) {
				if (twoNPC1.get(i).getX() == x && twoNPC1.get(i).getY() == y) {
					twoNPC1.remove(i);
					break;
				}
				
			}
			if (twoNPC1.isEmpty()) {
				return true;
			}
			break;
		
		case "twoNPC2":
		for (int i = 0; i < twoNPC2.size(); i++) {
			if (twoNPC2.get(i).getX() == x && twoNPC2.get(i).getY() == y) {
				twoNPC2.remove(i);
				break;
			}
			
		}
		
		if (twoNPC2.isEmpty()) {
			return true;
		}
		break;
	}
	return false;
	}
	public static boolean gameOver() {
		oppWon = true;
		youWon = true;
		if (!five.isEmpty()) {
			oppWon = false;
		}
		if (!firstFour.isEmpty()) {
			oppWon = false;		}
		if (!secondFour.isEmpty()) {
			oppWon = false;
		}
		if (!firstThree.isEmpty()) {
			oppWon = false;
		}
		if (!secondThree.isEmpty()) {
			oppWon = false;
		}
		if (!thirdThree.isEmpty()) {
			oppWon = false;
		}
		if (!firstTwo.isEmpty()) {
			oppWon = false;
		}
		if (!secondTwo.isEmpty()) {
			oppWon = false;
		}
		
		//check if opp boats are empty
		if (!fiveNPC.isEmpty()) {
			youWon = false;
		}
		if (!fourNPC1.isEmpty()) {
			youWon = false;		}
		if (!fourNPC2.isEmpty()) {
			youWon = false;
		}
		if (!threeNPC1.isEmpty()) {
			youWon = false;
		}
		if (!threeNPC2.isEmpty()) {
			youWon = false;
		}
		if (!threeNPC3.isEmpty()) {
			youWon = false;
		}
		if (!twoNPC1.isEmpty()) {
			youWon = false;
		}
		if (!twoNPC2.isEmpty()) {
			youWon = false;
		}
		if (youWon || oppWon) {
			return true;
		}
		return false;
	}
	public Driver() {
		JFrame f = new JFrame();
		f.setTitle("StingingArmada");
		f.setSize(width, height);
		f.setResizable(false);
		bg = new Background("newmap.png");
		if (!five.get(0).horizontal) {
			five1 = new Ships(five.get(0).getX()*73+73,five.get(0).getY()*73+73, five.get(0).horizontal, "5ship.png"  );
		}
		else {
			five1 = new Ships(five.get(0).getX()*73+73,five.get(0).getY()*73+73, five.get(0).horizontal, "horfive.png"  );

		}
		if (!firstFour.get(0).horizontal) {
			four1 = new Ships(firstFour.get(0).getX()*73+73,firstFour.get(0).getY()*73+73, firstFour.get(0).horizontal, "fourship.png"  );
		}
		else {
			four1 = new Ships(firstFour.get(0).getX()*73+73,firstFour.get(0).getY()*73+73, firstFour.get(0).horizontal, "horfour.png"  );

		}
		if (!secondFour.get(0).horizontal) {
			four2 = new Ships(secondFour.get(0).getX()*73+73,secondFour.get(0).getY()*73+73, secondFour.get(0).horizontal, "fourship.png"  );
		}
		else {
			four2 = new Ships(secondFour.get(0).getX()*73+73,secondFour.get(0).getY()*73+73, secondFour.get(0).horizontal, "horfour.png"  );

		}
		if (!firstThree.get(0).horizontal) {
			three1 = new Ships(firstThree.get(0).getX()*73+73,firstThree.get(0).getY()*73+73, firstThree.get(0).horizontal, "threeship.png"  );
		}
		else {
			three1 = new Ships(firstThree.get(0).getX()*73+73,firstThree.get(0).getY()*73+73, firstThree.get(0).horizontal, "horthree.png"  );

		}
		if (!secondThree.get(0).horizontal) {
			three2 = new Ships(secondThree.get(0).getX()*73+73,secondThree.get(0).getY()*73+73, secondThree.get(0).horizontal, "threeship.png"  );
		}
		else {
			three2 = new Ships(secondThree.get(0).getX()*73+73,secondThree.get(0).getY()*73+73, secondThree.get(0).horizontal, "horthree.png"  );

		}
		if (!thirdThree.get(0).horizontal) {
			three3 = new Ships(thirdThree.get(0).getX()*73+73,thirdThree.get(0).getY()*73+73, thirdThree.get(0).horizontal, "threeship.png"  );
		}
		else {
			three3 = new Ships(thirdThree.get(0).getX()*73+73,thirdThree.get(0).getY()*73+73, thirdThree.get(0).horizontal, "horthree.png"  );

		}
		if (!firstTwo.get(0).horizontal) {
			two1 = new Ships(firstTwo.get(0).getX()*73+73,firstTwo.get(0).getY()*73+73, firstTwo.get(0).horizontal, "twoship.png"  );
		}
		else {
			two1 = new Ships(firstTwo.get(0).getX()*73+73,firstTwo.get(0).getY()*73+73, firstTwo.get(0).horizontal, "hortwo.png"  );

		}
		if (!secondTwo.get(0).horizontal) {
			two2 = new Ships(secondTwo.get(0).getX()*73+73,secondTwo.get(0).getY()*73+73, secondTwo.get(0).horizontal, "twoship.png"  );
		}
		else {
			two2 = new Ships(secondTwo.get(0).getX()*73+73,secondTwo.get(0).getY()*73+73, secondTwo.get(0).horizontal, "hortwo.png"  );

		}
//		five1 = new Ships(five.get(0).getX()*73+73,five.get(0).getY()*73+73, five.get(0).horizontal, "5ship.png"  );
//		four1 = new Ships(firstFour.get(0).getX()*73+73,firstFour.get(0).getY()*73+73, firstFour.get(0).horizontal, "fourship.png"  );
//		four2 = new Ships(secondFour.get(0).getX()*73+73,secondFour.get(0).getY()*73+73, secondFour.get(0).horizontal, "fourship.png"  );
//		three1 = new Ships(firstThree.get(0).getX()*73+73,firstThree.get(0).getY()*73+73, firstThree.get(0).horizontal, "threeship.png"  );
//		three2 = new Ships(secondThree.get(0).getX()*73+73,secondThree.get(0).getY()*73+73, secondThree.get(0).horizontal, "threeship.png"  );
//		three3 = new Ships(thirdThree.get(0).getX()*73+73,thirdThree.get(0).getY()*73+73, thirdThree.get(0).horizontal, "threeship.png"  );
//		two1 = new Ships(firstTwo.get(0).getX()*73+73,firstTwo.get(0).getY()*73+73, firstTwo.get(0).horizontal, "twoship.png"  );
//		two2 = new Ships(secondTwo.get(0).getX()*73+73,secondTwo.get(0).getY()*73+73, secondTwo.get(0).horizontal, "twoship.png"  );
//		five1 = new Ships(730,73, false, "5ship.png"  );
		
		
		
	
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