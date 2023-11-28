import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

//gives coordinates of ships, allows to change them, and does same for shot selected by user
public class Coordinate {

	private int x;
	private int y;
	private boolean shot;
	private boolean visited;
	public boolean horizontal;
	private String fileName;
	private Image img;
	public Coordinate(int x, int y, boolean horizontal) {
		this.x = x;
		this.y = y;
		shot = false;
		visited = false;
		this.horizontal = horizontal;
	}
	public Coordinate(int x, int y, String fileName) {
		this.x = x;
		this.y = y;
		
		img = getImage(fileName);
		init(x,y);
	}
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
	public void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 1);
	}
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
	}
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Ships.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	public boolean getVisited() {
		return visited;
	}
	
	public void setVisited() {
		this.visited = true;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean getShot() {
		return shot;
	}

	public void setShot() {
		shot = true;
	}

}