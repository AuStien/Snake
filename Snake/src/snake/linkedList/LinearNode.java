package snake.linkedList;

import javafx.scene.shape.Rectangle;

public class LinearNode {
	private LinearNode next, previous;
	private Rectangle element;
	
	public LinearNode(Rectangle el){
		next = null;
		previous = null;
		element = el;
	}

	
	public double[] getXY(){
		double[] XY = {element.getX(), element.getY()};
		return XY;
	}
	
	public void setXY(double[] XY){
		element.setX(XY[0]);
		element.setY(XY[1]);
	}
	
	public LinearNode getNext() {
		return next;
	}

	public void setNext(LinearNode next) {
		this.next = next;
	}
	
	public LinearNode getPrevious() {
		return previous;
	}

	public void setPrevious(LinearNode previous) {
		this.previous = previous;
	}

	public Rectangle getElement() {
		return element;
	}

	public void setElement(Rectangle element) {
		this.element = element;
	}
	
	
}
