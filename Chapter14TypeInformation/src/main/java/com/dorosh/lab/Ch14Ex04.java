/* TIJed4 Chapter Type Information, Exercise 1, page 398
 * 
 * Exercise4: (2) Modify the previous exercise so that 
 * it uses instanceof to check the type before performing the downcast.
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

public class Ch14Ex04 {
	public static void main(String[] args) {
		List<Shape> shapeList = Arrays.asList(new Circle(), new Square(), new Triangle(), new Rhomboid());
		for (Shape shape : shapeList)
			shape.draw();

		Rhomboid rhomboid = new Rhomboid();
		Shape shape = rhomboid;
		System.out.println(shape.toString());

		if (shape instanceof Rhomboid) {
			rhomboid = (Rhomboid) shape;
			System.out.println(rhomboid.toString());
		}

		if (shape instanceof Circle) {
			Circle circle = (Circle) shape;
			System.out.println(circle.toString());
		}
	}

}
