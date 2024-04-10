import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;

public class adventday3 {
	
	

	public static void main (String[] args) {
		String input = "/home/gc292/eclipse-workspace/inputDay3.txt";
		soma(day3p1(reader(input)));
		soma(day3p2(reader(input)));
		//<>
		
		
	}

	private static List<Integer> day3p1(List<String> inputStrings) {
		
		List<Integer> valores = new ArrayList<>();
		int indice = 0;
			for (String line : inputStrings) {
				boolean isNumValido = false;
				StringBuilder valueToAdd = new StringBuilder();
				for(char c : line.toCharArray())  {
					if (Character.isDigit(c)) {
						if(indiceValido(indice, inputStrings)) { isNumValido = true; }
						valueToAdd.append(c);
						
					} 
					else {
						if (valueToAdd.length() > 0 && isNumValido) {
							valores.add(Integer.valueOf(valueToAdd.toString()));
							valueToAdd.setLength(0);
							isNumValido = false;
						} 
						else {
		                        valueToAdd.setLength(0);
		                }
					}
					indice++;
				}
				if(valueToAdd.length() > 0 && isNumValido){ valores.add(Integer.valueOf(valueToAdd.toString())); }
			}
			return valores;
			}


	

	private static List<Integer> day3p2(List<String> inputStrings) {
		List<Integer> valores = new ArrayList<>();
		
		 Pattern PaNum= Pattern.compile("\\d+");
		 Pattern PaAst= Pattern.compile("\\*");
		int indice = 0; 
	    int totalGearRatio = 0;
	    
	    for (String line : inputStrings) {
	        Matcher MaAst= PaAst.matcher(line);

	        while (MaAst.find()) {
	            int partNumber = Integer.parseInt(MaAst.group());
	            totalGearRatio += findAdjacentGearRatio(indice, inputStrings);
	        }
	    }

	    
		

		
		
		
		return valores;
	}	
	
	
	
	
	private static int findAdjacentGearRatio(int indice, List<String> inputStrings) {
		
		return 0;
	}

	private static  boolean indiceValido(int indice, List<String> inputStrings) {
			
			int schematicLength = inputStrings.get(0).length();
	        int row = indice % schematicLength;
	        int column = indice / schematicLength;
	
	        for (int i = -1; i <= 1; i++) {
	            for (int j = -1; j <= 1; j++) {
	                int columnIndex = Math.min(Math.max(column + i, 0), inputStrings.size() - 1);
	                int rowIndex = Math.min(Math.max(row + j, 0),schematicLength - 1);
	                if(isSymbol(inputStrings.get(columnIndex).charAt(rowIndex))){
	                    return true;
	                }
	            }
	        }
			return false;
		}
	
	
	private static int soma (List<Integer> lista) {
		int soma = 0;
		for(int num : lista)
			soma += num;
		System.out.println(soma);
		return soma;
	}
	
	
	private static List<String> reader(String input) {
		ArrayList<String> SFile= new ArrayList<>();
		
			try {
				Scanner scan = new Scanner(new File(input));
				
				while (scan.hasNextLine()) {
					SFile.add(scan.nextLine());
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("File not found");
			}
			return SFile;
	}
	
	private static boolean isSymbol(char c) { return !Character.isDigit(c) && c != '.'; }
	
	private static boolean isAsterisk(char c) { return c == '*'; }
	
}
