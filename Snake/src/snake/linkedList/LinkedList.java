package snake.linkedList;

import javafx.scene.shape.Rectangle;

public class LinkedList {
	LinearNode first, last;
	int amount;
	
	public LinkedList(){
		first = null;
		last = null;
		amount = 0;
	}
	
	// Add new node to list
	public void add(LinearNode node){
		if(isEmpty()){
			first = node;
			last = node;
			amount++;
		}else{
			if(amount == 1){
				first.setNext(node);
				node.setPrevious(first);
				last = node;
				amount++;
			}else{
				last.setNext(node);
				node.setPrevious(last);
				last = node;
				amount++;
			}
		}
	}
	
	public void addBehindFirst(LinearNode node){
		if(amount > 1){
			node.setNext(first.getNext());
			node.setPrevious(first);
			first.getNext().setPrevious(node);
			first.setNext(node);
			amount++;
		}else{
			add(node);
		}
		
		System.out.println(amount);
	}
	
	// Moves every XY in each element one down in list
	public void shiftDown(){
		
		LinearNode relevant = last;
		
		if(amount == 2){
			relevant.setXY(first.getXY());
		}else if(amount > 1){
			for(int i = 0; i < amount -1  && relevant != null; i++){
				relevant.setXY(relevant.getPrevious().getXY());
				relevant = relevant.getPrevious();
			}
		}
		
	}
	
	// Return every element
	public Rectangle[] getAllElements(){
		Rectangle[] rects = new Rectangle[amount];
		LinearNode relevant = first;
		
		
		for(int i = 0; i < amount; i++){
			rects[i] = relevant.getElement();
			relevant = relevant.getNext();
		}
		
		return rects;
	}
	
	public void deleteAll(){
		LinearNode relevant = first;
		for(int i = 0; i < amount; i++){
			relevant.setElement(null);
			relevant = relevant.getNext();
		}
	}
	
	public boolean isEmpty(){
		return amount == 0;
	}
	
	public int getAmount(){
		return amount;
	}
	
	public LinearNode getFirst(){
		return first;
	}
}
