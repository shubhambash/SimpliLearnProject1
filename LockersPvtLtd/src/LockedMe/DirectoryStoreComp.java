package LockedMe;

import java.util.Comparator;

public class DirectoryStoreComp implements Comparator<FileStorage>{

	@Override
	public int compare(FileStorage o1, FileStorage o2) {
		return o1.fileName.compareTo(o2.fileName);
	}
}




