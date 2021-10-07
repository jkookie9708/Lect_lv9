package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class SaveFile {
	
	public static SaveFile instance = new SaveFile();

	public void saveData() {
		FileWriter save = null;
		String path = "gameData.txt";
		
	}
	
	public void loadData() {
		File file;
		FileReader reader;
		BufferedReader br;
		String path = "gameData.txt";
		file = new File(path);
	}
}
