package LockedMe;

public interface CRUDInterface {
	void addFile(String fileName, String content);
	void removeFile();
	void searchFile();
	void showDirectoryItems();
}
