

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	//GameObject object;
	Timer time;
	final static int MENU_STATE = 0;

	final int GAME_STATE = 1;

	final static int END_STATE = 2;
	
	static int currentState = MENU_STATE;
	
	Font titleFont;
	
	Font buttonFont;
	
	int x;
	
    int y;
    
    public static BufferedImage alienImg;

    public static BufferedImage rocketImg;

    public static BufferedImage bulletImg;

    public static BufferedImage spaceImg;
    
    Rocketship ship = new Rocketship(250, 700, 50, 50, 5);
    
    ObjectManager manager = new ObjectManager(ship);
	
	public void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setColor(Color.cyan);
		g.setFont(titleFont);
		g.drawString("LEAGUE INVADERS", 80, 100);
		g.setFont(buttonFont);
		g.drawString("Press ENTER to start", 120, 300);
		g.drawString("Press SPACE for instructions", 80, 600);
		
	}
	
public void drawGameState(Graphics g) {
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	g.drawImage(GamePanel.spaceImg, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
	manager.draw(g);
    
	}

public void drawEndState(Graphics g) {
	g.setColor(Color.RED);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	g.setColor(Color.black);
	g.setFont(titleFont);
	g.drawString("GAME OVER", 120, 100);
	g.setFont(buttonFont);
	g.drawString("You killed " + manager.getScore() + " enemies", 130, 300);
	g.drawString("Press ENTER to restart", 120, 600);
	
}

	public void paintComponent(Graphics g){
		//object.draw(g);
		if(currentState == MENU_STATE){

            drawMenuState(g);

    }else if(currentState == GAME_STATE){

            drawGameState(g);

    }else if(currentState == END_STATE){

            drawEndState(g);

    }

	        }
	
public void updateMenuState() {
	
}

public void updateGameState() {
	manager.update();
	manager.manageEnemies();
	manager.checkCollision();
	manager.purgeObjects();
}

public void updateEndState() {
	
}

	
 public GamePanel() {
	 try {

         alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));

         rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));

         bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));

         spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));

 } catch (IOException e) {

         // TODO Auto-generated catch block

         e.printStackTrace();

 }
	 this.x = x;
	 this.y = y;
	 time = new Timer(1000/60, this);
	 titleFont = new Font("Arial", Font.PLAIN, 38);
	 buttonFont = new Font("Arial", Font.PLAIN, 23);
 }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		//object.update();
		repaint();
		if(currentState == MENU_STATE){

            updateMenuState();

    }else if(currentState == GAME_STATE){

            updateGameState();

    }else if(currentState == END_STATE){

            updateEndState();

    }
	}
	

	public void startGame() {
		time.start();
	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
		
		if(currentState==END_STATE) {
			 ship = new Rocketship(250, 700, 50, 50, 5);
			 manager = new ObjectManager(ship);
		}currentState++;
		}
		if(currentState > END_STATE){

            currentState = MENU_STATE;
    }
		if(e.getKeyCode() == KeyEvent.VK_UP) {
	    	 ship.setUp(true);
	     }
	     if(e.getKeyCode() == KeyEvent.VK_DOWN) {
	    	 ship.setDown(true);
	     }
	     if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
	    	 ship.setRight(true);
	     }
	     if(e.getKeyCode() == KeyEvent.VK_LEFT) {
	    	 ship.setLeft(true);
	     }
	     
	     if(e.getKeyCode() == KeyEvent.VK_SPACE) {
	    	 manager.addProjectile(new Projectile(ship.x+25, ship.y, 10, 10, 10));
	     }
		
	     if(e.getKeyCode() == KeyEvent.VK_ENTER) {
	    	 if(currentState == END_STATE) {
	    		 this.ship = ship;
	    	 }
	     }
		
	}



	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_UP) {
	    	 ship.setUp(false);
	     }
	     if(e.getKeyCode() == KeyEvent.VK_DOWN) {
	    	 ship.setDown(false);
	     }
	     if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
	    	 ship.setRight(false);
	     }
	     if(e.getKeyCode() == KeyEvent.VK_LEFT) {
	    	 ship.setLeft(false);
	     }
	}
	
}













