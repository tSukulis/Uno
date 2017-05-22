 
package view;

/**
 *
 *  
 */
public interface PileListener {
    /**
     * Postconditions:Get enabled when Discardpile condition changes
     * @param card 
     */
    public abstract void pileStatusChanged(Card card);
}

