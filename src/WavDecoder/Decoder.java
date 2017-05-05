package WavDecoder;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Decoder {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);

		//System.out.println("Which file would you like to process?");
		
		try {
			WavData data = new WavData("/home/bharmath/Dokumentumok/ch24/"
					+ "PROBLEMSET_15_PREEC/input/P/0.wav");
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		}
		System.out.println("Goodbye!");
		//scanner.next();
		scanner.close();
	}
}
