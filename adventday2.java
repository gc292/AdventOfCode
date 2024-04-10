import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class adventday2 {
	static String input = "/home/gc292/eclipse-workspace/inputDay2.txt";
	
	public static void main (String[] args) {
		day2p1();
		day2p2();
		
	}

	private static void day2p1() {
		int sumGames= 0;
		try {
			Scanner scan = new Scanner(new File(input));
			
			
			while (scan.hasNextLine()) {
				
				boolean validGame = true;
			    String line = scan.nextLine().trim();
			    String correctedLine = line.replace("Game", "").trim();
			    String[] elements = correctedLine.split("[\\s | :;,]"); 
			    
			    
			    for (int i = 0; i < elements.length; i++) {
			    	
			    	 switch (elements[i]) {
	                    case "blue":
	                        if (i > 0 && Integer.parseInt(elements[i - 1]) > 14) {validGame = false; }
	                     
	                        break;

	                    case "red":
	                    	if (i > 0 && Integer.parseInt(elements[i - 1]) > 12) {validGame = false; }
	                    	
	                        break;

	                    case "green":
	                    	if (i > 0 && Integer.parseInt(elements[i - 1]) > 13) {validGame = false; }
	                    	
	                        break;
	                }
			    	
			    }
			   
		    	if(validGame) { sumGames += Integer.parseInt(elements[0]); }
		    	
			}
	

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
		 System.out.println(sumGames);
	}

	private static void day2p2() {
		int sumColors = 0;
		try {
			Scanner scan = new Scanner(new File(input));
			
			
			while (scan.hasNextLine()) {
				int red = 0, blue = 0, green =0 ;
				boolean validGame = true;
			    String line = scan.nextLine().trim();
			    String correctedLine = line.replace("Game", "").trim();
			    String[] elements = correctedLine.split("[\\s | :;,]"); 
			    
			    
			    for (int i = 0; i < elements.length; i++) {
			    	
			    	 switch (elements[i]) {
	                    case "blue":
	                        if (i > 0 && Integer.parseInt(elements[i - 1]) > 14) {validGame = false;}
	                        if (i > 0 && Integer.parseInt(elements[i - 1]) > blue) { blue = Integer.parseInt(elements[i - 1]);}
	                        break;

	                    case "red":
	                        if (i > 0 && Integer.parseInt(elements[i - 1]) > 12) {validGame = false;}
	                        if (i > 0 && Integer.parseInt(elements[i - 1]) > red) { red = Integer.parseInt(elements[i - 1]);}	
	                        break;

	                    case "green":
	                        if (i > 0 && Integer.parseInt(elements[i - 1]) > 13) { validGame = false;}
	                        if (i > 0 && Integer.parseInt(elements[i - 1]) > green) { green = Integer.parseInt(elements[i - 1]);}   
	                        break;
	                }
			    	
			    }
			    
		    	sumColors += (red*blue*green); 
		    	System.out.println(sumColors);
		    	red=0; blue=0; green=0;
		    	
			}
	

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
		 System.out.println(sumColors);
		
	}
	
	//static private void gameSet(Boolean validGame) {validGame = false;}
}
