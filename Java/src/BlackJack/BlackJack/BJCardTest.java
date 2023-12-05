package BlackJack;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.awt.*;

import org.junit.jupiter.api.Test;

class BJCardTest {

     @Test
     void testgetRank() {
         BJCard AceSpades = new BJCard(1,1);
         assertEquals(1, AceSpades.getRank());
     }
     @Test
     void testsetRank() {
         BJCard AceSpades = new BJCard(1,1);
         AceSpades.setRank(3);
         assertEquals(3, AceSpades.getRank());
     }


     @Test
     void testgetSuit() {
         BJCard AceSpades = new BJCard(1,1);
         assertEquals(1, AceSpades.getSuit());
     }
     @Test
     void testsetSuit() {
         BJCard AceSpades = new BJCard(1,1);
         AceSpades.setSuit(2);
         assertEquals(2, AceSpades.getSuit());
     }


     @Test
     void testisHidden() {
         BJCard AceSpades = new BJCard(1,1);
         assertFalse(AceSpades.isHidden());
     }


     @Test
     void testgetText() {
         BJCard AceSpades = new BJCard(1,1);
         assertEquals("A\u2660", AceSpades.getText());
     }


     @Test
     void testfindSuit() {
         BJCard AceSpades = new BJCard(1,1);
         assertEquals("\u2660", AceSpades.findSuit());
     }


     @Test
     void testfindRank() {
         BJCard AceSpades = new BJCard(1,1);
         assertEquals("A", AceSpades.findRank());
     }


     @Test
     void testgetFontColor() {
         BJCard AceSpades = new BJCard(1,1);
         assertEquals(Color.blue, AceSpades.getFontColor());
     }





}
