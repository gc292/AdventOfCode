import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class adventday1 {
	static String input = "/home/gc292/eclipse-workspace/input.txt";
	
	public static void main (String[] args) {
		day1p1();
		day1p2();
		
	}
	
	static public void day1p1 () {
		int sumTotal = 0;
		
		try {
		
		Scanner sus = new Scanner(new File(input));
			
		    while(sus.hasNextLine()) {
		    	
		    	char c1 = 0, c2 = 0;
		    	String line = sus.nextLine();
		        char[] array = line.toCharArray();
		        
		        
		        for (int i = 0; i < line.length(); i++) {
	                if (Character.isDigit(array[i])) {
	                    c1 = array[i];
	                    break;
	                }
	            }

	            for (int j = line.length() - 1; j >= 0; j--) {
	                if (Character.isDigit(array[j])) {
	                    c2 = array[j];
	                    break; 
	                }
	            }
	            sumTotal += Integer.parseInt(String.valueOf(c1) + String.valueOf(c2));
	            
	            }
		   
		 
		    sus.close();
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
			e.printStackTrace();
		}
			
		   System.out.println(sumTotal);
	}
	
	public static void day1p2 () {
		Map<String, String> numeros = new HashMap<>();	
		numeros.put("one", "one1one");
		numeros.put("two", "two2two");
		numeros.put("three", "three3three");
		numeros.put("four", "four4four");
		numeros.put("five", "five5five");
		numeros.put("six", "six6six");
		numeros.put("seven", "seven7seven");
		numeros.put("eight", "eight8eight");
		numeros.put("nine", "nine9nine");
		
	int sumTotal = 0;
			
			try {
			
			Scanner sus = new Scanner(new File(input));
				
			    while(sus.hasNextLine()) {
			    	
			    	char c1 = 0, c2 = 0;
			    	String line = sus.nextLine();
			    	System.out.println("primeiro:    " + line);
			    	for(Map.Entry<String, String> entry : numeros.entrySet()) {
						line = line.replace(entry.getKey(), entry.getValue());
						System.out.println(line);
					}
			        char[] array = line.toCharArray();
			        
			        
			        for (int i = 0; i < line.length(); i++) {
		                if (Character.isDigit(array[i])) {
		                    c1 = array[i];
		                    break;
		                }
		            }
	
		            for (int j = line.length() - 1; j >= 0; j--) {
		                if (Character.isDigit(array[j])) {
		                    c2 = array[j];
		                    break; 
		                }
		            }
		            sumTotal += Integer.parseInt(String.valueOf(c1) + String.valueOf(c2));
		            
		            }
			   
			 
			    sus.close();
			} catch (FileNotFoundException e) {
				System.out.println("file not found");
				e.printStackTrace();
			}
				
			   System.out.println(sumTotal);
		}
		
	
}
