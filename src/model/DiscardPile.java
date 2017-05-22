 
package model;
import java.util.Stack;
import java.util.List; 

/**
 * The stuck that player puts a card
 * icludes methods and listeners 
 */
public class  DiscardPile extends Pile{
    
    Stack Discard = new Stack<Card>();
    
    /**
     *  
     * Postconditions: Return true or false if Pile is empty or not
     * @return true or false  
     */
    @Override
     public boolean isEmpty(){
     return Discard.empty();
     }
    
    /** 
     * Postconditions: add card to the  stuck
     * @param card 
     */
    
    @Override
     public void pushCard(Card card){
      this.Discard.push(card);  }
     
    /** 
     * Postconditions:Pop card from the stuck and return it 
     * @param card
     * @return the card
     */
    @Override
    public Card popCard(){
    Card temp;
    temp= (Card)  Discard.pop();
    return temp;
      }
    
    
    public Card peekCard(){
       Card temp;
    temp= (Card)  Discard.peek();
    return temp;
       
    }
      
    
    /**
     * Postconditions:Delete the stuck
     */
    //public void clearAll(){}
    
    
   // List<PileListener> listeners;
    /**
     * Postconditions : add a PileListener object in the listeners list
     * @param listener 
     */
  //  public void addPileListener(PileListener listener){
        
    }
    /**
     * Postconditions:Notify all listeners about the changes
     */
     
     //void notifyAll();
//
