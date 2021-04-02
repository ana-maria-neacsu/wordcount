package wordcount.Pojo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TextReader implements ITextReader {
	
	private File textFile;
	private Scanner textScanner;
	
	public TextReader(String fileName) {
		this.textFile = new File(fileName);
		try {
			this.textScanner = new Scanner(this.textFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> read() {
		
		ArrayList<String> stopWords = new ArrayList<String>();
		while(this.textScanner.hasNextLine()) {
			String stopWord = this.textScanner.nextLine();
			stopWords.add(stopWord);
		}
		
		return stopWords;
	}
	
	
	
}
