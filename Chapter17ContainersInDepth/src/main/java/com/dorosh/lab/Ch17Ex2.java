/* TIJed4 Chapter Containers in Depth, Exercise 2, page 579
 * 
 * Exercise 2: (2) Produce a Map and a Set containing all the countries that begin with ‘A’.
 *
 * My solution to one of the exercises in 
 * Thinking in Java 4th Edition (by Bruce Eckel).
 * It compiles and runs correctly using JDK 1.8
 * @author Maryan Dorosh
 * August, 2017
 */

package com.dorosh.lab;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.dorosh.lab.net.mindview.util.Countries;

public class Ch17Ex2 {

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<String, String>();
		Set<String> set = null;

		for (int i = 0; i < Countries.DATA.length; i++) {
			if (Countries.DATA[i][0].startsWith("A")) {
				map.put(Countries.DATA[i][0], Countries.DATA[i][1]);
			}
		}

		set = map.keySet();
		System.out.println("all the countries that begin with ‘A’ - set: " + set);
		System.out.println("all the countries that begin with ‘A’ - map: " + map);
	}

}
