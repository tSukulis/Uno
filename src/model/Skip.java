 
package model;

/**
 * Skip is a subclass of Card
 * emulates skip type cards in uno
 */
public class Skip extends Card {
        
    Skip(int i){
           this.color=i;
       }
    
    /**
     * 
     * @return color of the card
     */
     
    @Override
    public int getCardColor(){
    return color;}
    
    /** 
     * Postcondition: returns  true if matches or false otherwise
     * @param MatchCard the card we want to find if matches with discard pile
     * @return true or false  
     */
    @Override
    public boolean match(Card MatchCard){
    
    if(MatchCard.getClass()==this.getClass())
            return true;
        
        if( "model.Wild".equals(MatchCard.getClass().getName())){  
            if (this.color==MatchCard.color)
            return true;
        }
        
        if( "model.Draw2".equals(MatchCard.getClass().getName())){
            Draw2 tmp;
            tmp= (Draw2) MatchCard;
            if ( tmp.color==this.color) 
                return true;
            else
                return false;
        }
        
        if( "model.Reverse".equals(MatchCard.getClass().getName())){
            Reverse tmp;
            tmp= (Reverse) MatchCard;
            if ( tmp.color==this.color) 
                return true;
            else
                return false;
        }
        
        if( "model.Wild4".equals(MatchCard.getClass().getName())){
            Wild4 tmp;
            tmp= (Wild4) MatchCard;
            if ( tmp.color==this.color) 
                return true;
            else
                return false;
        }
        
        if( "model.SimpleCard".equals(MatchCard.getClass().getName())){
            SimpleCard tmp;
            tmp= (SimpleCard) MatchCard;
            if ( tmp.color==this.color) 
                return true;
            else
                return false;
        }
        
        return false;
        
    
    


    }
    public boolean match(Card MatchCard,Card[] PlayerCards ){
        return false;
          }
}
