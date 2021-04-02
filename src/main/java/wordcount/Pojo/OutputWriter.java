package wordcount.Pojo;

import george.WordCount.Interfaces.IOutputWriter;

public class OutputWriter implements IOutputWriter {

	
	public void WriteLine(String output) {
		System.out.println(output);
	}

}
