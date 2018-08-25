

import java.awt.*;

public class Rocketship extends GameObject {
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	
	public boolean getUp() {
		return up;
	}
	public void setUp(boolean up) {
		this.up = up;
	}
	
	public boolean getDown() {
		return down;
	}
	public void setDown(boolean down) {
		this.down = down;
	}
	
	public boolean getRight() {
		return right;
	}
	public void setRight(boolean right) {
		this.right = right;
	}
	
	public boolean getLeft() {
		return left;
	}
	public void setLeft(boolean left) {
		this.left = left;
	}
	
	
	public void update() {
		super.update();
		if(up == true) {
			y-=speed;
		}
		if(down == true) {
			y+=speed;
		}
		if(right == true) {
			x+=speed;
		}
		if(left == true) {
			x-=speed;
		}
	}
	
	public void draw(Graphics g) {
		g.drawImage(GamePanel.rocketImg, x, y, width, height, null);
		






	}

	public Rocketship(int x, int y, int width, int height, int speed) {
		super(x, y, width, height, speed);
		// TODO Auto-generated constructor stub
	} 
	
}
