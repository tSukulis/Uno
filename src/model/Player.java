
package model;

/**
 * emulates the game players 
 * 
 */
public class Player {
    public Card PlayerCards[];
    /**
     * Postcondition: initialise players card array
     * @param playersCards array with  cards
     */
    public Player(Card  Cards[]){
        this.PlayerCards=Cards;
    
    
    }
    
    /**
     * Postcondition:returns points of player's cards 
     * @return points of player
     */
    public int playerPoints(){
        int sum=0;
        SimpleCard temp = null;
        for(int index=0;index<this.PlayerCards.length;index++){
            if(this.PlayerCards[index]!=null){
                if("model.SimpleCard".equals(this.PlayerCards[index].getClass().getName())){
                    temp=(SimpleCard) this.PlayerCards[index];
                    sum+=temp.number;}
                
                if("model.Draw2".equals(this.PlayerCards[index].getClass().getName()) || "model.Reverse".equals(this.PlayerCards[index].getClass().getName()) || "model.Skip".equals(this.PlayerCards[index].getClass().getName()))
                    sum+=20;
                
                
                if(("model.Wild".equals(this.PlayerCards[index].getClass().getName())) ||("model.Wild".equals(this.PlayerCards[index].getClass().getName())))
                    sum+=50;
            
            
            }
                }
            return sum;
    }
    
    /**
     * Postcondition: add card to player's card array
     * @param card card that player takes
     */
    public void takeCard(Card card){
        int index;
        for(index=0;index<this.PlayerCards.length;index++){
            if(this.PlayerCards[index]==null){
            this.PlayerCards[index]=card;
            break;}}
    }

    /**
     * Precondition: index exists
     * Postcondition: deletes card object at index position
     * @param index card position in array
     */
    public void deleteCard(int index){}
    
    
    
    public void sortarray (){
        for(int i=0;i<this.PlayerCards.length;i++)
            if(this.PlayerCards[i]==null){
                for(int j=i;j<this.PlayerCards.length;j++){
                    if(this.PlayerCards[j]!=null){
                        this.PlayerCards[i]=this.PlayerCards[j];
                        this.PlayerCards[j]=null;
                        break;}
                }
                    
            }
    }
    
   
    
}
