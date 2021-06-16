package Streams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFiles {

	public static void main(String[] args) throws IOException {

		File file = new File("C:\\Users\\nites\\OneDrive\\Desktop\\FileWriting\\myTestFile.csv");

		FileReader fr = new FileReader(file);

		BufferedReader reader = new BufferedReader(fr);
		String line = null;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		reader.close();

	}

}
