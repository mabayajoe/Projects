/**
* Assignment: Lab 9b
* File: BJDeck.java
* Description: Creates a new java class that implements PDeck
* Lessons Learned: Implements PDeck. It will contain an arraylist and we created a method that creates all the cards. 
*
* Instructor's Name: Barbara Chamberlin
*
* @author: Dereck Angeles
* @since: 11/14/2022
*/
package BlackJack;

import java.util.ArrayList;
import java.util.Collections;

import BlackJackBase.PCard;
import BlackJackBase.PDeck;

public class BJDeck implements PDeck{
	
	ArrayList<BJCard> cards;
	
	public BJDeck() {
		cards = new ArrayList<BJCard>();
		
		for (int mycard = 1; mycard < 15; mycard++) {
			for (int mysuit = 1; mysuit <= 4; mysuit++) {
				cards.add(new BJCard(mycard,mysuit));
			}
		}
		
	}
	
	

	@Override
	public void shuffle() {
		Collections.shuffle(cards);
	}

	
	@Override
	public void addCard(PCard card) {
		cards.add(cards.size(), (BJCard) card);
	}

	
	@Override
	public PCard dealCard() {
		if (!cards.isEmpty()) {
			return cards.remove(cards.size()-1);
			}
		return null;
	}

	
	@Override
	public PCard dealHiddenCard() {
		if (!cards.isEmpty()) {
			BJCard last_card = cards.get(cards.size()-1);
			last_card.hideCard();
			}
		return null;
	}

	
	@Override
	public int cardCount() {
		return cards.size();
	}

}
