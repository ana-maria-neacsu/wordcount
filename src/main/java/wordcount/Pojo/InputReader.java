package wordcount.Pojo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import george.WordCount.Interfaces.IInputReader;

public class InputReader implements IInputReader {
	
	private BufferedReader reader;
	
	public InputReader() {
		this.reader = new BufferedReader(
	            new InputStreamReader(System.in));
	}
	
	
	public String readLine() {
		String line = "";
		try {
			line = reader.readLine();
			return line;
		} catch (IOException e) {
			e.printStackTrace();
			return line;
		}	
	}

}
