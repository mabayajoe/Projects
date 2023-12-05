
package BlackJack.BlackJack;

import java.util.ArrayList;

import BlackJackBase.PCard;
import BlackJackBase.PHand;

public class BJHand implements PHand{
	private final ArrayList<BJCard> hand = new ArrayList<>();
	
	
	public BJHand() {
	}

	
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return hand.size();
	}

	@Override
	public void addCard(PCard card) {
		hand.add(getSize(), (BJCard) card);
		
	}

	@Override
	public PCard getCard(int index) {
		// TODO Auto-generated method stub
		return hand.get(index);
	}

	@Override
	public PCard removeCard(int index) {
		// TODO Auto-generated method stub
		return hand.remove(index);
	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		/*int sum_card = 0;
		int rank_card = 0;
		ArrayList<Integer> ace_cards = new ArrayList<>();
		
		for (BJCard card : hand) {
			rank_card = card.getRank();
			
			if ((card.getRank() == BJCard.JACK) || (card.getRank() == BJCard.QUEEN) || (card.getRank() == BJCard.KING)) {
				rank_card = 10;
			} else if (card.getRank() == 1) {
				ace_cards.add(card.getRank());
				continue;
			}
			sum_card += card.getRank();
		}
		
		
		for (int ace_card : ace_cards) {
			if(sum_card <= 10) {
				sum_card += 11;
			} else {
				sum_card += 1;
			}
		}
		
		return sum_card;*/
		
		int score = 0;
		for (BJCard card : hand) {
			
            switch (card.getRank())
            {
                case 2: 
                	score += 2; 
                	break;
                case 3: 
                	score += 3; 
                	break;
                case 4: 
                	score += 4; 
                	break;
                case 5: 
                	score += 5; 
                	break;
                case 6: 
                	score += 6; 
                	break;
                case 7: 
                	score += 7; 
                	break;
                case 8: 
                	score += 8; 
                	break;
                case 9: 
                	score += 9; 
                	break;
                case 10:
                	score += 10;
                	break;
                case 11:
                case 12:
                case 13:
                case 14: 
                	score += 10; 
                	break;
                case 1:
                    if(score+11 > 21){ 
                    	score +=1; 
                    	
                    }else{
                    	score += 11;
                    }
            }
		}
		return score;
	}

}
