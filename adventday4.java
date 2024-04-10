import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class adventday4 {

	
	public static void main (String[] args) {
		String input = "/home/gc292/eclipse-workspace/inputDay4.txt";
		day4p1(input);
		day4p2(input);
		//<>
		
		
	}

//	Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
//	Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19
//	Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1
//	Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83
//	Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36
//	Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11
	
	private static void day4p1(String input) {
		int sumTotal = 0;
		ArrayList<Card> cartas = new ArrayList<>();
		try {
			Scanner scan = new Scanner(new File(input));
			while (scan.hasNextLine()) {
				cartas.add(new Card(scan.nextLine()));
			}
			
			for( Card c : cartas) {
				sumTotal += c.getPoints();
			}
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File Not Found");
		}
		System.out.println(sumTotal);
		
	}
	
	private static void day4p2 (String input) {
		int sumTotal = 0;
		ArrayList<Card> cartas = new ArrayList<>();
		try {
			Scanner scan = new Scanner(new File(input));
			while (scan.hasNextLine()) {
				cartas.add(new Card(scan.nextLine()));
			}
			
			for(int i = 0; i< cartas.size(); i++) {
				Card c = cartas.get(i);
				int wins = c.getWins();
				int copies = c.getCopies();
				sumTotal += copies;
				for (int v = i + 1; v < i + wins + 1 && v < cartas.size(); v++) {
					cartas.get(v).addCopies(copies);
				}
				
			}
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File Not Found");
		}
		System.out.println(sumTotal);
		
	}
	
	
}


