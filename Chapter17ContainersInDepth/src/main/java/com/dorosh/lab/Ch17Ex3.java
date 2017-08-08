/* TIJed4 Chapter Containers in Depth, Exercise 3, page 579
 * 
 * Exercise 3: (1) Using Countries, fill a Set multiple times with the same data 
 * and verify that the Set ends up with only one of each instance. 
 * Try this with HashSet, LinkedHashSet, and TreeSet.
 *
 * My solution to one of the exercises in 
 * Thinking in Java 4th Edition (by Bruce Eckel).
 * It compiles and runs correctly using JDK 1.8
 * @author Maryan Dorosh
 * August, 2017
 */

package com.dorosh.lab;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.dorosh.lab.net.mindview.util.Countries;
import com.dorosh.lab.net.mindview.util.Print;

public class Ch17Ex3 {

	public static void main(String[] args) {

		Set<String> hashSet = new HashSet<>();
		Set<String> treeSet = new TreeSet<>();
		Set<String> linkedHashSet = new LinkedHashSet<>();

		for (int i = 0; i < Countries.DATA.length; i++) {
			hashSet.add(Countries.DATA[i][0]);
		}

		treeSet.addAll(hashSet);
		linkedHashSet.addAll(hashSet);

		// print on the console
		print(hashSet);
		print(treeSet);
		print(linkedHashSet);

		// add the same ones data
		for (int i = 0; i < 3; i++) {
			hashSet.addAll(hashSet);
			treeSet.addAll(hashSet);
			linkedHashSet.addAll(hashSet);
		}

		// print on the console
		System.out.println("after adding");
		print(hashSet);
		print(treeSet);
		print(linkedHashSet);
	}

	private static void print(Set<String> set) {
		System.out.println(String.format("%s has length %d and contains %s", set.getClass().getSimpleName(), set.size(),
				set.toString()));

	}

}
