package edu.umb.cs680.hw13;

import java.util.Comparator;

public class TimeStampComparator implements Comparator<FSElement> {
	public int compare(FSElement a, FSElement b) {
		return b.getCreationTime().compareTo(a.getCreationTime());
	}
}
