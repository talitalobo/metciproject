package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadTxt {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Write the path to file: ");
		File file = new File(sc.next());
		readFile(file);
		sc.close();
	}
	
	/**
	 * 
	 * @param file
	 * ex: /home/talita/git/metci/metciproject/data/dicionario.txt
	 */
	private static void readFile(File file) {

		BufferedReader br = null;

		try {
			java.io.FileReader fr = new java.io.FileReader(file);
			br = new BufferedReader(fr);

			String line;

			while ((line = br.readLine()) != null) {
				System.out.println(line);
				// put in the data structure
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + file.toString());
		} catch (IOException e) {
			System.out.println("Unable to read file: " + file.toString());
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				System.out.println("Unable to close file: " + file.toString());
			} catch (NullPointerException ex) {
			}
		}
	}
}