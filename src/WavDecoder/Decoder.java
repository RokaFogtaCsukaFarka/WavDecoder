package WavDecoder;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Decoder {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);

		//System.out.println("Which file would you like to process?");
		
		try {
			WavData data = new WavData("input/0.wav");
			
			System.out.print(data.getData());
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		} catch (Exception e) {
			System.out.print(e.toString());
		}
		System.out.println("Goodbye!");
		
		scanner.close();
	}
}
