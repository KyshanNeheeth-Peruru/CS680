package edu.umb.cs680.hw13;

import java.util.Comparator;

public class ReverseAlphabeticalComparator implements Comparator<FSElement> {
	public int compare(FSElement a, FSElement b) {
		return b.getName().compareTo(a.getName());
	}

}
