package LockedMe;

public interface CRUDInterface {
	void addFile(String fileName, String content);
	void removeFile(String fileName);
	void searchFile(String fileName);
	void showDirectoryItems();
}
