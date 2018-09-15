

import java.awt.*;

public class Human extends GameObject {
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
		collisionBox.setBounds(x+40, y+150, 110, 30);
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
		g.drawImage(GamePanel.hoomanImg, x, y, 196, 300, null);
//		Graphics2D G2 = (Graphics2D) g;
//		G2.draw(collisionBox);






	}

	public Human(int x, int y, int width, int height, int speed) {
		super(x, y, width, height, speed);
		// TODO Auto-generated constructor stub
	} 
	
}
