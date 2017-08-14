/* TIJed4 Chapter Type Information, Exercise 1, page 398
 * 
 * Exercise3: (2) Add Rhomboid to Shapes.java. 
 * Create a Rhomboid, upcast it to a Shape, then downcast it back to a Rhomboid. 
 * Try downcasting to a Circle and see what happens.
 *
 * My solution to one of the exercises in 
 * Thinking in Java 4th Edition (by Bruce Eckel).
 * It compiles and runs correctly using JDK 1.8
 * @author Maryan Dorosh
 * August, 2017
 */

package com.dorosh.lab;

import java.util.Arrays;
import java.util.List;

abstract class Shape {
	void draw() {
		System.out.println(this + ".draw()");
	}

	abstract public String toString();
}

class Circle extends Shape {
	public String toString() {
		return "Circle";
	}
}

class Square extends Shape {
	public String toString() {
		return "Square";
	}
}

class Triangle extends Shape {
	public String toString() {
		return "Triangle";
	}
}

class Rhomboid extends Shape {

	@Override
	public String toString() {
		return "Rhomboid";
	}

}

public class Ch14Ex03 {
	public static void main(String[] args) {
		List<Shape> shapeList = Arrays.asList(new Circle(), new Square(), new Triangle(), new Rhomboid());
		for (Shape shape : shapeList)
			shape.draw();
		
		Rhomboid rhomboid = new Rhomboid();
		Shape shape = rhomboid;
		System.out.println(shape.toString()); 
		
		rhomboid = (Rhomboid) shape;
		System.out.println(rhomboid.toString()); 
		
		Circle circle = (Circle) shape;
		System.out.println(circle.toString()); 
	}

}
