import java.util.ArrayList;

public class Card {
	
	ArrayList<Integer> winners = new ArrayList<>();
	private int cardNumber;
	private int copies = 1;
	private int points = 0;
	private int wins = 0;
	
//	Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
	public Card (String line) {
		String[] arr = line.split(":");
		this.cardNumber = Integer.parseInt(arr[0].replace("Card", "").trim());
		String[] winarr = arr[1].split("\\|");

		for (String c : winarr[0].split(" ")) {
			if (c.isBlank()) continue;
			winners.add(Integer.parseInt(c));
		}
		for (String c : winarr[1].split(" ")) {
			if (c.isBlank()) continue;
			if (winners.contains(Integer.parseInt(c))) {
				wins++;
				if (points == 0) {
					points++;
				}
				else {
					points *= 2;
				}
		
			}
		}
		
	}

	public int getPoints() {
		return points;
	}

	public int getCopies() {
		return copies;
	}

	public int getWins() {
		return wins;
	}

	public int getCardNumber() {
		return cardNumber;
	}
	
	public void addCopies(int copies) {
		this.copies += copies;
	}

}
