package edu.umb.cs680.hw13;

import java.util.Comparator;

public class SizeComparator implements Comparator<FSElement> {
	public int compare(FSElement a, FSElement b) {
		return a.getSize() - b.getSize();
	}
}
