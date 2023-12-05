/**
* Assignment: Lab 9b
* File: PlayBlackJack.java
* Description: This is the main class. 
* Lessons Learned: Comment our previos code and tyoe new code that shows all the cards. 
*
* Instructor's Name: Barbara Chamberlin
*
* @author: Dereck Angeles
* @since: 11/16/2022
*/
package BlackJackTest;

import java.awt.Color;

import BlackJack.BJCard;
import BlackJack.BJDeck;
import BlackJack.BJHand;
import BlackJackBase.PGame;

public class PlayBlackJack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*CardTest.run(new BJCard(BJCard.ACE, BJCard.HEART));
		CardTest.run(new BJCard(BJCard.QUEEN, BJCard.DIAMOND));
		CardTest.run(new BJCard(BJCard.TWO, BJCard.HEART));
		CardTest.run(new BJCard(BJCard.ACE, BJCard.HEART));
		CardTest.run(new BJCard(BJCard.THREE, BJCard.HEART));
		CardTest.run(new BJCard(BJCard.ACE, BJCard.SPADE));
		CardTest.run(new BJCard(BJCard.TWO, BJCard.SPADE));*/
		
//		DeckTest.run(new BJDeck());
		
//		HandTest.run(new BJDeck(), new BJHand());
		
		
		PGame.setBackgroundColor(new Color(0, 138, 0));           
		       
		PGame.setBannerColor(Color.BLACK); 
		                
        PGame.setBannerTextColor(Color.WHITE);  
                           
        PGame.setStatusTextColor(Color.WHITE);  
        
        PGame.setButtonColor(Color.BLACK);  
        
        PGame.setButtonHighlightColor(Color.LIGHT_GRAY);  
        
        PGame.setButtonTextColor(Color.WHITE); 
        
        PGame.setFont("Tahoma");
    
        PGame.run(new BJDeck(), new BJHand(), new BJHand()); 

	}

}
