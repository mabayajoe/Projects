package BlackJack;

import java.awt.Color;

import BlackJackBase.PCard;

public class BJCard extends PCard {
	int rank;
	int suit;
	boolean hidden;
	
	public static final int ACE = 1;
	public static final int TWO = 2;
	public static final int THREE = 3;
	public static final int FOUR = 4;
	public static final int FIVE = 5;
	public static final int SIX = 6 ;
	public static final int SEVEN = 7;
	public static final int EIGHT = 8;
	public static final int NINE = 9;
	public static final int TEN = 10;
	public static final int JACK = 11;
	public static final int QUEEN = 12;
	public static final int KING = 13;
	public static final int KNIGHT = 14;
	
	
	public static final int SPADE = 1;
	public static final int HEART = 2;
	public static final int DIAMOND = 3;
	public static final int CLUB = 4;
	
	
	public BJCard(int r, int s){
		rank = r;
		suit = s;
		hidden = false;
		
	}
	
	
	
	public int getRank(){
		return rank;
	}
	public int getSuit() {
		return suit;
	}
	
	
	public void setRank(int r) {
		rank = r;
	}
	public void setSuit(int s) {
		suit = s;
	}



	@Override
	public void hideCard() {
		// TODO Auto-generated method stub
		hidden = true;
		
	}



	@Override
	public void showCard() {
		// TODO Auto-generated method stub
		hidden = false;
		
	}



	@Override
	public boolean isHidden() {
		// TODO Auto-generated method stub
		return hidden;
	}



	/*@Override
	public String getText() {
		// TODO Auto-generated method stub
		String card = "";
		
		switch (this.rank) {
		case ACE:
			card = "A";
			break;
		case TWO:
			card = "2";
			break;
		case THREE:
			card = "3";
			break;
		case FOUR:
			card = "4";
			break;
		case FIVE:
			card = "5";
			break;
		case SIX:
			card = "6";
			break;
		case SEVEN:
			card = "7";
			break;
		case EIGHT:
			card = "8";
			break;
		case NINE:
			card = "9";
			break;
		case TEN:
			card = "10";
			break;
		case JACK:
			card = "J";
			break;
		case QUEEN:
			card = "Q";
			break;
		case KING:
			card = "K";
			break;
		}
		
		switch (this.suit) {          //This is for the colors
		case SPADE:
			card += "\\u2660";
			break;
		case CLUB:	
			card += "\\u2663";
			break;
		case HEART:
			card += "\\u2665";
			break;
		case DIAMOND:
			card += "\\u2667";
			break;
			
		}
		
		return card;
	}*/
	public String getText() {
		String unicode = findRank() + findSuit();
		return unicode;
	}

	
	public String findSuit(){
		String card = "";

		switch(suit) {
			case SPADE:
				card = "\u2660";
				break;
			case HEART:
				card = "\u2665";
				break;
			case DIAMOND:
				card = "\u2666";
				break;
			case CLUB:
				card = "\u2663";
				break;
		}
		return card;
	}

	
	public String findRank(){
		String card = "";

		switch(rank) {
			case ACE:
				card = "A";
				break;
			case TWO:
				card = "2";
				break;
			case THREE:
				card = "3";
				break;
			case FOUR:
				card = "4";
				break;
			case FIVE:
				card = "5";
				break;
			case SIX:
				card = "6";
				break;
			case SEVEN:
				card = "7";
				break;
			case EIGHT:
				card = "8";
				break;
			case NINE:
				card = "9";
				break;
			case TEN:
				card = "10";
				break;
			case JACK:
				card = "J";
				break;
			case KNIGHT:
				card = "Kn";
				break;
			case QUEEN:
				card = "Q";
				break;
			case KING:
				card = "K";
				break;
		}
		return card;
	}
	
	public Color getFontColor(){

		Color color = null;

		switch(suit) {
			case SPADE:
				color = Color.black;
				break;
			case HEART:
				color = Color.red;
				break;
			case DIAMOND:
				color = Color.red;
				break;
			case CLUB:
				color = Color.black;
				break;
		}
		return color;
	}

	public Color getFaceColor() {
		return Color.WHITE;
	}
	public Color getBorderColor() {
		return Color.blue;
	}
	public Color getStripeColor() {
		return new Color(0, 0, 153);
	}

}
