 
package model;

 /**
 * Wild4 is a subclass of Card
 * emulates Wild 4 type cards in uno
 */
public class Wild4 extends Card {
       
    public Wild4()
    {this.color=-1;
    }   
    /** 
     * Postcondition: returns  true because Wild type card matches everytime
     * @param MatchCard the card we want to find if matches with discard pile
     * @return true    
     */
    
    @Override
    public boolean match(Card MatchCard,Card[] PlayerCards ){
        int i;
        for (i=0;i<30;i++){
            if (PlayerCards[i]!=null){
            if (PlayerCards[i].color==MatchCard.color)
                return false;}
          }
        return true;
    }
    
    /**
     * Sets the color of the card before play it 
     * Postcondition: returns the color of card  
     * @param color the color's id
     * 
     */
    public void SetColor(int color){
    this.color=color;}
    
     @Override
    public  int getCardColor(){
     return color;}
     
    @Override
     public  boolean match(Card MatchCard){return false;}
}
