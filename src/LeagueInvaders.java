

import java.awt.*;

import javax.swing.JFrame;

public class LeagueInvaders {
	static JFrame window;
	GamePanel game;
	final static int WIDTH = 500;
	final static int HEIGHT = 800;
public static void main(String[] args) {
    window = new JFrame();
	window.setSize(500, 800);
	window.setVisible(true);
	LeagueInvaders League = new LeagueInvaders();
	League.setup();
	window.addKeyListener(League.game);
}
  public LeagueInvaders() {
	  game = new GamePanel();
  }
public void setup() {
	window.add(game);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	window.getContentPane().setPreferredSize(new Dimension(500, 800));
    window.pack();
    game.startGame();
}
}


