package snake;

import java.util.Random;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import snake.linkedList.LinearNode;
import snake.linkedList.LinkedList;

public class Snake{
	private static final int RIGHT = 0;
	private static final int DOWN = 1;
	private static final int LEFT = 2;
	private static final int UP = 3;
	
	private LinkedList list;	// Linked list containing each part of snake
	private int headX, headY;					// Coordinates of head
	private Rectangle head;						// Head object
	private int size; 							// Size of head and used as step distance
	private int dir; 							// Direction of head
	
	private Rectangle fruit;
	private Random rand = new Random();
	
	// Constructor
	public Snake(){
		dir = 0;
		
		headX = 200;
		headY = 200;
		size = 20;
		

		list = new LinkedList();
		
		int randX = rand.nextInt(390);
		int randY = rand.nextInt(390);
		
		fruit = new Rectangle(randX - (randX % 20), randY - (randY % 20), size, size);
		
		head = new Rectangle(headX, headY, size, size);
		
		list.add(new LinearNode(head));
	}
	
	// On key pressed
	public void pressed(KeyEvent e){
		KeyCode code = e.getCode();
		if(code == KeyCode.D && dir != LEFT){
			dir = RIGHT;
		}else if(code == KeyCode.S && dir != UP){
			dir = DOWN;
		}else if(code == KeyCode.A && dir != RIGHT){
			dir = LEFT;
		}else if(code == KeyCode.W && dir != DOWN){
			dir = UP;
		}		
	}
	
	// Moves every element one down and head toward dir each frame
	public Rectangle frame(){
		Rectangle eat = null;
		
		Rectangle rect = list.getFirst().getElement();
		
		double prevX = rect.getX();
		double prevY = rect.getY();
		
		switch(dir){
		case RIGHT:
			rect.setX(rect.getX() + size);
			break;
		case DOWN:
			rect.setY(rect.getY() + size);
			break;
		case LEFT:
			rect.setX(rect.getX() - size);
			break;
		case UP:
			rect.setY(rect.getY() - size);
			break;
		}
		
		
		// If out of bounds
		if(rect.getX() < 0 || rect.getX() > 390 ||
				rect.getY() < 0 || rect.getY() > 390){
			
		}
		
		
		if(fruit.getX() == rect.getX() && fruit.getY() == rect.getY()){
			Rectangle newRect;
			if(list.getAmount() == 1){
				newRect = new Rectangle(prevX, prevY, size, size);
			}else{
				newRect = new Rectangle(fruit.getX(), fruit.getY(), size, size);
				
			}
			//newRect.setFill(Color.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
			newRect.setFill(Color.rgb( 255 - (list.getAmount() * 10) % 255, 0, 0));
			LinearNode node = new LinearNode(newRect);
			list.addBehindFirst(node);
			
			
			int randX = rand.nextInt(390);
			int randY = rand.nextInt(390);
			
			fruit.setX(randX - (randX % 20));
			fruit.setY(randY - (randY % 20));
			eat = newRect;
		}
		if(list.getAmount() > 1){
			list.shiftDown();
			
		}
		
		return eat;
		
		
		
	}
	
	public LinkedList getList(){
		return list;
	}
	
	public Rectangle[] getRectangles(){
		return list.getAllElements();
	}
	
	public Rectangle getFruit(){
		return fruit;
	}
	
}
