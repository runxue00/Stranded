

import java.awt.*;

public class Falling_Fruit extends GameObject{

	public Falling_Fruit(int x, int y, int width, int height, int speed) {
		super(x, y, width, height, speed);
		// TODO Auto-generated constructor stub
	}
	
	public void update() {
		super.update();
		y+=speed;
	}
	
	public void draw(Graphics g) {
		g.drawImage(GamePanel.fruitImg, x, y, width, height, null);
		
	}

}
