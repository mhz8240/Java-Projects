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

public class Driver2 extends JPanel implements ActionListener {
	Background bg1;
	int width = 800;
	int height = 800;
	ArrayList<Coordinate> painted1;
	//updates the painted array
	public void updateArray(ArrayList<Coordinate> painted) {
		painted1 = painted;
	}
	public void paint(Graphics g) {
		Graphics2D gd = (Graphics2D) g;
		super.paintComponent(gd);
		bg1.paint(gd);
		for (Coordinate c : painted1) {
			c.paint(g);
		}
		//notes:
		//make sure to check if the coordinates aren't too high or too low
		//make sure to check for visited coordinates
	
		//make sure to check for input format error
		
	}

	public Driver2() {
		painted1 = new ArrayList<>();
		JFrame f = new JFrame();
		f.setTitle("GuessedMap");
		f.setSize(width, height);
		f.setResizable(false);
		bg1 = new Background("newmap.png");
		f.add(this);
		t1 = new Timer(17, this);
		t1.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	Timer t1;
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}
	
}