      

import java.awt.*;

public class GameObject {
	 int x;
     int y;
     int width;
     int height;
     int speed;
     boolean isAlive = true;
     Rectangle collisionBox;
     
     public GameObject(int x, int y, int width, int height, int speed) {
    	 this.x = x;
    	 this.y = y;
    	 this.width = width;
    	 this.height = height;
    	 speed = 5;
    	 this.speed = speed;
    	 collisionBox = new Rectangle(x, y, width, height);
     }
     
     public void update() {
    	 collisionBox.setBounds(x, y, width, height);
     }
     
     public void draw(Graphics g) {
    	 
     }
}
