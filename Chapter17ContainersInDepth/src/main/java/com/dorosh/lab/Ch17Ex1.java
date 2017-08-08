/* TIJed4 Chapter Containers in Depth, Exercise 1, page 579
 * 
 * Exercise 1: (1) Create a List (try both ArrayList and LinkedList)
 * and fill it using Countries. 
 * Sort the list and print it, then apply Collections.shuffle( ) 
 * to the list repeatedly, printing it each time so that 
 * you can see how the shuffle( ) method randomizes the list differently each time.
 *
 * My solution to one of the exercises in 
 * Thinking in Java 4th Edition (by Bruce Eckel).
 * It compiles and runs correctly using JDK 1.8
 * @author Maryan Dorosh
 * August, 2017
 */

package com.dorosh.lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.dorosh.lab.net.mindview.util.Countries;

public class Ch17Ex1 {

	public static void main(String[] args) {

		List<String> arrayList = new ArrayList<String>();
		List<String> linkedListl = new LinkedList<String>();
		for (int i = 0; i < Countries.DATA.length; i++) {
			arrayList.add(Countries.DATA[i][0]);
			linkedListl.add(Countries.DATA[i][1]);
		}
		Collections.sort(arrayList);
		Collections.sort(linkedListl);
		System.out.println("Countries: " + arrayList);
		System.out.println("Capitals: " + linkedListl);
		
		for (int i = 0; i < 3; i++) {
			Collections.shuffle(arrayList);
			Collections.shuffle(linkedListl);
			System.out.println("Countries " + i + ": " + arrayList);
			System.out.println("Capitals " + i + ": " + linkedListl);
		}

	}

}
