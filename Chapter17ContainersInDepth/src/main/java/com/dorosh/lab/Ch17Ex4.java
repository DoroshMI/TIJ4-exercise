/* TIJed4 Chapter Containers in Depth, Exercise 4, page 579
 * 
 * Exercise 4: (2) Create a Collection initializer that opens a file and breaks it into words using TextFile, 
 * and then uses the words as the source of data for the resulting Collection. 
 * Demonstrate that it works.
 *
 * My solution to one of the exercises in 
 * Thinking in Java 4th Edition (by Bruce Eckel).
 * It compiles and runs correctly using JDK 1.8
 * @author Maryan Dorosh
 * August, 2017
 */

package com.dorosh.lab;


import java.util.Arrays;
import java.util.Collection;
import java.util.TreeSet;

import com.dorosh.lab.net.mindview.util.TextFile;

public class Ch17Ex4 {

	static Collection<String> collectFromFile(String fileName) {		
		String[] sa = TextFile.read(fileName).split(" ");
		return Arrays.asList(sa);
	}
	static Collection<String> collectUniqeFromFile(String fileName) {		
		return new TreeSet<String>(new TextFile(fileName, "\\W+"));
	}
	public static void main(String[] args) {
		System.out.println(collectFromFile("src/main/java/com/dorosh/lab/Ch17Ex4.java"));
		System.out.println(collectUniqeFromFile("src/main/java/com/dorosh/lab/Ch17Ex4.java"));
	}

}
