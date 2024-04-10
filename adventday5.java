import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class adventday5 {

	public static void main (String[] args) {
		String input = "/home/gc292/eclipse-workspace/inputDay5.txt";
		day5p1(input);
		//day4p2(input);
		//<>
		
		
	}
	
	private static void day5p1(String input) {
		
		ArrayList<Long> seeds = new ArrayList<>();
		try {
			BufferedReader reader= new BufferedReader(new FileReader(input));
			
			for (String line : reader.lines().toList()) {
				if(line.isBlank()) continue;
				if(line.startsWith("seeds") ) {
					for (String seed : line.replace("seeds:", "").trim().split(" ")) {
						seeds.add(Long.parseLong(seed));
					}
				} else {
					if(line.matches("^\\d.*")) {
						System.out.print(line);
					}
				}
				
				
				
				
				
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("File Not Found");
		}
	}
}