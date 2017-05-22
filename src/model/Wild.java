 
package model;

/**
 * Wild is a subclass of Card
 * emulates Wild type cards in uno
 */
public class Wild extends Card {
        
  /**
     * Sets the color of the card before play it 
     * Postcondition: returns the color of card  
     * @param color the color's id
     * @return color 
     */
    public void SetColor(int color){
    this.color=color;
    }
    
    /** 
     * Postcondition: returns  true because Wild type card matches everytime
     * @param MatchCard the card we want to find if matches with discard pile
     * @return true    
     */
    @Override
    public boolean match(Card MatchCard){
    return true;}
    
    /**
     * @return color of the card
     */
    @Override
    public  int getCardColor(){
    return color;}
    
    public boolean match(Card MatchCard,Card[] PlayerCards ){
        return false;
          }
}
