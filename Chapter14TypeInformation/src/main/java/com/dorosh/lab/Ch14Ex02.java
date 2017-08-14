/* TIJed4 Chapter Type Information, Exercise 1, page 398
 * 
 * Exercise2: (2) Incorporate a new kind of interface into ToyTest.java 
 * and verify that it is detected and displayed properly.
 *
 * My solution to one of the exercises in 
 * Thinking in Java 4th Edition (by Bruce Eckel).
 * It compiles and runs correctly using JDK 1.8
 * @author Maryan Dorosh
 * August, 2017
 */

package com.dorosh.lab;

import com.dorosh.lab.toys.ToyTest;

public class Ch14Ex02 {

	public static void main(String[] args) {
		Class c = null;
		try {
			c = Class.forName("com.dorosh.lab.toys.FancyToy");
		} catch (ClassNotFoundException e) {
			System.out.println("Can't find FancyToy");
			System.exit(1);
		}
		ToyTest.printInfo(c);
		for (Class face : c.getInterfaces())
			ToyTest.printInfo(face);
		Class up = c.getSuperclass();
		Object obj = null;
		try {
			// Requires default constructor:
			obj = up.newInstance();
		} catch (InstantiationException e) {
			System.out.println("Cannot instantiate");
			System.exit(1);
		} catch (IllegalAccessException e) {
			System.out.println("Cannot access");
			System.exit(1);
		}
		ToyTest.printInfo(obj.getClass());

	}

}