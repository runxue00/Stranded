

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
Human human;
//ArrayList<Projectile> projectiles= new ArrayList<Projectile>();
ArrayList<Falling_Fruit> fruit= new ArrayList<Falling_Fruit>();
long enemyTimer = 0;
int enemySpawnTime = 3000;
int score = 0;
int BadStrawberry;

public int getScore() {
	return this.score;
	
}



public ObjectManager(Human rocket) {
	this.human = rocket;
}

// void addProjectile(Projectile object) {
//	projectiles.add(object);
//}

public void addAlien(Falling_Fruit a) {
	fruit.add(a);
}

public void update() {
	human.update();
	
	for (int i = 0; i < fruit.size(); i++) {
	    Falling_Fruit a = fruit.get(i);
		a.update();
	}
	
}

public void draw(Graphics g) {
	human.draw(g);
//	for (int i = 0; i < projectiles.size(); i++) {
//		Projectile p = projectiles.get(i);
//		p.draw(g);
//	}
	for (int i = 0; i < fruit.size(); i++) {
	    Falling_Fruit a = fruit.get(i);
		a.draw(g);
	}
}
public void checkCollision() {
	for(Falling_Fruit f : fruit){

        if(human.collisionBox.intersects(f.collisionBox)) {
                f.isAlive = false;
        }
        if(f.y+f.height>=800) {
        	BadStrawberry++;
        	f.isAlive = false;
        }
        
        if(BadStrawberry>=3) {
        	
        	GamePanel.currentState = GamePanel.END_STATE;
        }

}
//	for(Projectile p : projectiles){
for (Falling_Fruit f : fruit) {
	if(f.collisionBox.intersects(human.collisionBox)){

//        p.isAlive = false;
       f.isAlive = false;
       score+=1;
	}
}
}
        

//}
//}
public void manageEnemies(){
    if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
            addAlien(new Falling_Fruit(new Random().nextInt(Stranded.WIDTH), 0, 100, 100, 100));
            enemySpawnTime = new Random().nextInt(3000);
enemyTimer = System.currentTimeMillis();
    }
}

public void purgeObjects() {
//	for (int i = 0; i < projectiles.size(); i++) {
//		Projectile p = projectiles.get(i);
//		if(p.isAlive == false) {
//			projectiles.remove(i);
//		}
//	8
	for (int i = 0; i < fruit.size(); i++) {
	    Falling_Fruit a = fruit.get(i);
		if(a.isAlive == false) {
			fruit.remove(i);
		}
	}
//	if(human.isAlive == false) {
//		GamePanel.currentState = GamePanel.END_STATE;
//	}
	
}
}







