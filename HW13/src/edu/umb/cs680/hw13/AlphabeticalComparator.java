package edu.umb.cs680.hw13;

import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<FSElement> {
	public int compare(FSElement a, FSElement b) {
		return a.getName().compareTo(b.getName());
	}

}
