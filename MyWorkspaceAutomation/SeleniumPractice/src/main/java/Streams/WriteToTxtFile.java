package Streams;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToTxtFile {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\nites\\OneDrive\\Desktop\\FileWriting\\myTestFile.html");
		//File file = new File("C:\\Users\\nites\\OneDrive\\Desktop\\FileWriting\\myTestFile.csv");
		//File file = new File("C:\\Users\\nites\\OneDrive\\Desktop\\FileWriting\\myTestFile.txt");

		FileWriter fw = new FileWriter(file, true);

		BufferedWriter writer = new BufferedWriter(fw);
		for (int i = 0; i <= 4; i++) {
			for (int j = 0; j < 3; j++) {
				writer.write(j + ",");
				
			}
		}
		writer.close();
		System.out.println("File created !!!");
	}

}
