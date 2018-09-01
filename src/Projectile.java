

import java.awt.*;

public class Projectile extends GameObject{

	public Projectile(int x, int y, int width, int height, int speed) {
		super(x, y, width, height, speed);
		// TODO Auto-generated constructor stub
		speed = 10;
	}
	
	public void update() {
		super.update();
		y-=speed;
		if(y<0) {
			isAlive = false;
		}
	}
	
	public void draw(Graphics g) {
		g.drawImage(GamePanel.bulletImg, x, y, width, height, null);

	}

}

