

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
Human rocket;
ArrayList<Projectile> projectiles= new ArrayList<Projectile>();
ArrayList<Falling_Fruit> aliens= new ArrayList<Falling_Fruit>();
long enemyTimer = 0;
int enemySpawnTime = 3000;
int score = 0;

public int getScore() {
	return this.score;
	
}



public ObjectManager(Human rocket) {
	this.rocket = rocket;
}

 void addProjectile(Projectile object) {
	projectiles.add(object);
}

public void addAlien(Falling_Fruit a) {
	aliens.add(a);
}

public void update() {
	rocket.update();
	
	for (int i = 0; i < aliens.size(); i++) {
	    Falling_Fruit a = aliens.get(i);
		a.update();
	}
	
}

public void draw(Graphics g) {
	rocket.draw(g);
	for (int i = 0; i < projectiles.size(); i++) {
		Projectile p = projectiles.get(i);
		p.draw(g);
	}
	for (int i = 0; i < aliens.size(); i++) {
	    Falling_Fruit a = aliens.get(i);
		a.draw(g);
	}
}
public void checkCollision() {
	for(Falling_Fruit a : aliens){

        if(rocket.collisionBox.intersects(a.collisionBox)){

                rocket.isAlive = false;

        }

}
	for(Projectile p : projectiles){
for (Falling_Fruit a : aliens) {
	if(a.collisionBox.intersects(p.collisionBox)){

        p.isAlive = false;
        a.isAlive = false;
        score+=1;
}
}
        

}
}
public void manageEnemies(){
    if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
            addAlien(new Falling_Fruit(new Random().nextInt(LeagueInvaders.WIDTH), 0, 50, 50, 50));
            enemySpawnTime = new Random().nextInt(3000);
enemyTimer = System.currentTimeMillis();
    }
}

public void purgeObjects() {
	for (int i = 0; i < projectiles.size(); i++) {
		Projectile p = projectiles.get(i);
		if(p.isAlive == false) {
			projectiles.remove(i);
		}
	}
	for (int i = 0; i < aliens.size(); i++) {
	    Falling_Fruit a = aliens.get(i);
		if(a.isAlive == false) {
			aliens.remove(i);
		}
	}
	if(rocket.isAlive == false) {
		GamePanel.currentState = GamePanel.END_STATE;
	}
	
}
}







