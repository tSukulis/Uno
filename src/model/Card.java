
package model;

/**
 * emulates the game cards 
 * includes methods
 */
public abstract class Card {
    public int color;
    /**
     * @return color of the card
     */
    public abstract int getCardColor();
    
    
    
    /** 
     * Postcondition: returns  true if matches or false otherwise
     * @param MatchCard the card we want to find if matches with discard pile
     * @return true or false  
     */
    public abstract boolean match(Card MatchCard);
    
    public abstract boolean match(Card MatchCard,Card[] PlayerCards );
}
