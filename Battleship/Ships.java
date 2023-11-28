import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;


public class Ships {
	private int x,y;
	private int size;
	private boolean horizontal;
	private String fileName;
	private Image img;
	public Ships(int x, int y, boolean horizontal, String fileName) {
//		this.size = size;
		this.x = x;
		this.y = y;
		
		this.horizontal = horizontal;
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
	public int getSize() {
		return size;
	}
	
	public void setSize() {
		this.size = size;
	}
	
	public boolean getHorizontal() {
		return horizontal;
	}
	
	public void setHorizontal() {
		horizontal = true;
	}

}
