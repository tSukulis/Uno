 
package model;
import java.util.Stack;
/**
 * The stuck that player draws a card
 * with methods
 */
public class DrawPile extends Pile {
    Stack Draw = new Stack<Card>();
    /**
     *  
     * Postconditions: Return true or false if Pile is empty or not
     * @return true or false  
     */
    @Override
    public  boolean  isEmpty(){
    return Draw.empty();}
    
    /** 
     * Postconditions: add card to the  stuck
     * @param card 
     */
    @Override
    public  void pushCard(Card card){
    this.Draw.push(card);}
    
    /** 
     * Postconditions:Pop card from the stuck and return it 
     * @param card
     * @return the card
     */
    @Override
    public  Card popCard(){
    Card temp;
    temp= (Card)  Draw.pop();
    return temp;
    }
      
    
    /**
     * Postconditions:Delete the stuck
     */
  //  @Override
    // public void clearAll(){}
    
}
