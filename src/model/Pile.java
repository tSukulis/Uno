 
package model;

/**
 * the abstract class of the two card stucks
 * 
 */
public abstract class Pile {
    
    /**
     *  
     * Postconditions: Return true or false if Pile is empty or not
     * @return true or false  
     */
    public abstract boolean  isEmpty();
    
    /** 
     * Postconditions: add card to the  stuck
     * @param card 
     */
    public abstract void pushCard(Card card);
    
    /** 
     * Postconditions:Pop card from the stuck and return it 
     * @param card
     * @return the card
     */
    public abstract Card popCard();
      
    
    /**
     * Postconditions:Delete the stuck
     */
  //  abstract public void clearAll();
    
    
    
    
}