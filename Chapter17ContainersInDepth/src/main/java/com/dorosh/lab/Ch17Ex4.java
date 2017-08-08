/* TIJed4 Chapter Containers in Depth, Exercise 5, page 579
 * 
 * Exercise 5: (3) Modify CountingMapData.java to fully implement the flyweight 
 * by adding a custom EntrySet class like the one in Countries.java.
 *
 * My solution to one of the exercises in 
 * Thinking in Java 4th Edition (by Bruce Eckel).
 * It compiles and runs correctly using JDK 1.8
 * @author Maryan Dorosh
 * August, 2017
 */

package com.dorosh.lab;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Ch17Ex4 extends AbstractMap<Integer, String> {
	private int size;
	private static String[] chars = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");

	public Ch17Ex4(int size) {
		if (size < 0)
			this.size = 0;
		this.size = size;
	}

	// Use AbstractSet by implementing size() & iterator()
	static class EntrySet extends AbstractSet<Map.Entry<Integer, String>> {
		private int size;

		EntrySet(int size) {
			if (size < 0)
				this.size = 0;
			else
				this.size = size;
		}

		public int size() {
			return size;
		}

		private class Iter implements Iterator<Map.Entry<Integer, String>> {
			// Only one Entry object per Iterator:
			private Entry entry = new Entry(-1);

			public boolean hasNext() {
				return entry.index < size - 1;
			}

			public Map.Entry<Integer, String> next() {
				entry.index++;
				return entry;
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}
		}

		public Iterator<Map.Entry<Integer, String>> iterator() {
			return new Iter();
		}
	}

	private static class Entry implements Map.Entry<Integer, String> {
		int index;

		Entry(int index) {
			this.index = index;
		}

		public boolean equals(Object o) {
			return Integer.valueOf(index).equals(o);
		}

		public Integer getKey() {
			return index;
		}

		public String getValue() {
			return chars[index % chars.length] + Integer.toString(index / chars.length);
		}

		public String setValue(String value) {
			throw new UnsupportedOperationException();
		}

		public int hashCode() {
			return Integer.valueOf(index).hashCode();
		}
	}

	public Set<Map.Entry<Integer, String>> entrySet() {
		// LinkedHashSet retains initialization order:
		Set<Map.Entry<Integer, String>> entries = new LinkedHashSet<Map.Entry<Integer, String>>();
		for (int i = 0; i < size; i++)
			entries.add(new Entry(i));
		return entries;
	}

	static Map<Integer, String> select(final int size) {
		return new Ch17Ex4(size) {
			public Set<Map.Entry<Integer, String>> entrySet() {
				return new EntrySet(size);
			}
		};
	}

	public static void main(String[] args) {
		System.out.println(new Ch17Ex4(60));
		System.out.println(select(10));
	}
}
