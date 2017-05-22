
package model;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random; 
import java.util.Scanner;

/**
 * unogame class first initilises players, cards
 * starts game then finds the winner and ends the game
 */
   
public class UnoGame {
     
    public static Card[] ALLcards=new Card[108];
    public static DiscardPile Discard=new DiscardPile();
    public static DrawPile Draw=new DrawPile() ;
      public static Player  ALLplayers[ ];

    static  Card[] init_array(Card CA[]){
 

int color,number,index=0;
  
  for(color=0;color<=3;color++){
      for(number=0;number<10;number++){
          if (number!=0){
              CA[index]=new SimpleCard(color,number);
               index++;
          } 
         CA[index]=new SimpleCard(color,number);   
      index++;} 
      
      CA[index]=new Draw2(color);
       index++;
      CA[index]=new Draw2(color);
      index++;
      CA[index]=new Wild();
      index++;
      CA[index]=new Wild4();
      index++;
      CA[index]=new Skip(color);
       index++;
      CA[index]=new Skip(color);
       index++;
      CA[index]=new Reverse(color);
      index++;
      CA[index]=new Reverse(color);
      index++;}
       return CA;
}
    
    
    
    
  public static  void main(String[] args) throws IOException {
  int players=2,i,fylo,vima=1,j=0,index,choice,rounds=1,currentRound=0, colorchoice,q,flag=-1,pontoi=0, counter=0;
  Wild tempwild;
  Wild4 tempwild4;
  Scanner cs = new Scanner(System.in);
  
  System.out.println("Epelekse ton ari8mo twn paiktwn : ");
  Scanner skan = new Scanner(System.in);
  players = skan.nextInt();
  
  System.out.println("===Neo paixnidi=== ( paiktes: "+players+" )");
  
  
  ALLcards=init_array(ALLcards);
     
  ALLplayers= new Player[players];    
  for(i=0;i<players;i++){
           ALLplayers[i]=new Player(init_players_cards());}
  
  
  
           for(int w=0;w<ALLplayers.length;w++){
               System.out.println();
               System.out.println("paikths:"+w );
           for(index=0;index<ALLplayers[w].PlayerCards.length;index++){
          
          if(ALLplayers[w].PlayerCards[index]!=null)
           System.out.println("karta paikth  " +  ALLplayers[w].PlayerCards[index].getClass().getName()+"    "+ ALLplayers[w].PlayerCards[index].color );}}
 
           
   Random r = new Random(); //init Discard pile
  fylo=r.nextInt(109);
  while(ALLcards[fylo]==null)
      fylo=r.nextInt(108);
  Discard.pushCard(ALLcards[fylo]);
  ALLcards[fylo]=null;
  
   
  
  for( i=0;i<108-(players*7)-1;i++){
      fylo=r.nextInt(108);
  while(ALLcards[fylo]==null)
      fylo=r.nextInt(108);
  Draw.pushCard(ALLcards[fylo]);
  ALLcards[fylo]=null; 
  
  }
  
   
  
  
  for(j=0;j<=ALLplayers.length; )
  {
       
      
      for(int u=0;u<ALLplayers.length;u++){
          counter=0;
          for( q=0;q<ALLplayers[u].PlayerCards.length;q++){
            if(ALLplayers[u].PlayerCards[q]!=null)
                counter++;}
          if(counter!=0) continue;
          else {System.out.println("Nikise o paikths:"+ u +" !!!!!!!!!!!!!!!!");
             flag=u;
              break;}
          
        }
      
      if (flag!=-1){
        for(q=0;q<ALLplayers.length;q++){
            if(q==flag)continue;
            pontoi+= ALLplayers[q].playerPoints();
            }
        System.out.println("Oi pontoi tou paikth: "+ flag +" einai: " + pontoi+" !!!");
        break;
        
      }
      
      System.out.println("=======================================");
      System.out.print("Katw :"+Discard.peekCard().getClass().getName()+"Color : " + Discard.peekCard().color);
      if ("model.SimpleCard".equals(Discard.peekCard().getClass().getName())){
            SimpleCard teeemp = (SimpleCard) Discard.peekCard();
            System.out.print(" number : "+teeemp.number);}
      System.out.println();
      System.out.println();
      
      System.out.println("paikths ="+j);
      System.out.println();
      for(index=0;index<ALLplayers[j].PlayerCards.length;index++){
          
          
          
          if(ALLplayers[j].PlayerCards[index]!=null){
            System.out.print(  "Karta:"+index +"  /"+ALLplayers[j].PlayerCards[index].getClass().getName()+"  c0lor="+ ALLplayers[j].PlayerCards[index].color );
          
            if ("model.SimpleCard".equals(ALLplayers[j].PlayerCards[index].getClass().getName())){
            SimpleCard teeemp = (SimpleCard) ALLplayers[j].PlayerCards[index];
            System.out.print(" number : "+teeemp.number);}
            System.out.println();
          }
      }
          
          
          
          
            System.out.println("Epelekse to xarti pou thes: ");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            
            if ( playerplay(ALLplayers[j].PlayerCards,Discard.peekCard())==true){
          
          
          
      
            while((ALLplayers[j].PlayerCards[choice]!=null) && ((ALLplayers[j].PlayerCards[choice].match(Discard.peekCard())==false) || ( ("model.Wild4".equals(ALLplayers[j].PlayerCards[choice].getClass().getName())) && (ALLplayers[j].PlayerCards[choice].match(Discard.peekCard(),ALLplayers[j].PlayerCards)) )) ){
                
               
                
                if( "model.Wild4".equals(ALLplayers[j].PlayerCards[choice].getClass().getName()) && ALLplayers[j].PlayerCards[choice].match(Discard.peekCard(),ALLplayers[j].PlayerCards) ){
                     System.out.println("PROBLEM?");break;}
                choice = sc.nextInt();
                    }
               
                
                if ("model.Reverse".equals(ALLplayers[j].PlayerCards[choice].getClass().getName()))
                    vima=-vima;
                if ("model.Wild".equals(ALLplayers[j].PlayerCards[choice].getClass().getName())){
                                System.out.println("Dwse xrwma :");
                                colorchoice = cs.nextInt();
                                tempwild= (Wild) ALLplayers[j].PlayerCards[choice];
                                 tempwild.SetColor(colorchoice);}
                
                if ("model.Wild4".equals(ALLplayers[j].PlayerCards[choice].getClass().getName())){
                                currentRound=rounds;
                                System.out.println("Dwse xrwma :");
                                colorchoice = cs.nextInt();
                                tempwild4= (Wild4) ALLplayers[j].PlayerCards[choice];
                                 tempwild4.SetColor(colorchoice);}

		if(   "model.Skip".equals(Discard.peekCard().getClass().getName())){
				currentRound=rounds;}	

                
                if ("model.Draw2".equals(ALLplayers[j].PlayerCards[choice].getClass().getName())|| "model.Skip".equals(ALLplayers[j].PlayerCards[choice].getClass().getName())) 
                        currentRound=rounds;
                
                 Discard.pushCard(ALLplayers[j].PlayerCards[choice]);
                ALLplayers[j].PlayerCards[choice]=null; 
                ALLplayers[j].sortarray ();
                }
            else{
                 Card temp=Draw.popCard(); 
                ALLplayers[j].takeCard(temp);
                System.out.print("Phres thn karta : "+ temp.getClass().getName() +"  "+ temp.color);
                if ("model.SimpleCard".equals(temp.getClass().getName())){
            SimpleCard teeemp = (SimpleCard) temp;
            System.out.print(" number : "+teeemp.number);}
                System.out.println();
                
                for(int num=0;num<ALLplayers[j].PlayerCards.length;num++){
                    if(ALLplayers[j].PlayerCards[num]==temp){
                        choice=num;
                        break;}
                }
              
                
               
                if ((temp.match(Discard.peekCard())) || (temp.match(Discard.peekCard(),ALLplayers[j].PlayerCards) && "model.Wild4".equals(ALLplayers[j].PlayerCards[choice].getClass().getName()) )){
                        if ("model.Wild".equals(ALLplayers[j].PlayerCards[choice].getClass().getName())){
                                System.out.println("Dwse xrwma :");
                                colorchoice = cs.nextInt();
                                tempwild= (Wild) ALLplayers[j].PlayerCards[choice];
                                 tempwild.SetColor(colorchoice);}
                        
                        if ("model.Wild4".equals(ALLplayers[j].PlayerCards[choice].getClass().getName())){
                            currentRound=rounds;
                            System.out.println("Dwse xrwma :");    
                            colorchoice = cs.nextInt();
                                tempwild4= (Wild4) ALLplayers[j].PlayerCards[choice];
                                 tempwild4.SetColor(colorchoice);}
                        
                       if ("model.Draw2".equals(ALLplayers[j].PlayerCards[choice].getClass().getName())|| "model.Skip".equals(ALLplayers[j].PlayerCards[choice].getClass().getName())) 
                        currentRound=rounds;

                       
                        
                        if ("model.Reverse".equals(ALLplayers[j].PlayerCards[choice].getClass().getName()))
                        
                            vima=-vima;
                        
                        Discard.pushCard(ALLplayers[j].PlayerCards[choice]);
                        ALLplayers[j].PlayerCards[choice]=null;
                         ALLplayers[j].sortarray ();
                        
                       // if (j==0 && vima==-1){ j=(ALLplayers.length-1) ;
                
                        
                        
                
                
            }
            }
            counter=0;
            for( q=0;q<ALLplayers[j].PlayerCards.length;q++){
            if(ALLplayers[j].PlayerCards[q]!=null)
                counter++;}
            
          String input ;  
          if(counter==1) {
                BufferedReader stdinp = new BufferedReader( new InputStreamReader( System.in ) ); 
                input = stdinp.readLine(); 
          
                if(!input.contains("uno")&&!input.contains("UNO")&& !input.contains("Uno")){
                    ALLplayers[j].takeCard(Draw.popCard());
                    ALLplayers[j].takeCard(Draw.popCard());
                    
                System.out.println("Den egrapses 'UNO' . Phres 2 kartes ");}}
                    
                    
              
            
            //System.out.println("VIMA="+ vima);
            j=j+vima;
            //System.out.println("J= "+ j);
            
            
            if(   "model.Skip".equals(Discard.peekCard().getClass().getName()) && rounds==currentRound){
                
          if (j==ALLplayers.length && vima==1){ j=1;rounds++; continue;}
          if (j<0 && vima==-1){ j=(ALLplayers.length-1)-1;rounds++; continue;}
          j=j+vima;
          rounds++;
          if (j==ALLplayers.length && vima==1) 
          j=0; 
          if (j<=0 && vima==-1)
          j=(ALLplayers.length-1); 
          continue;
      }
      
      if(   "model.Draw2".equals(Discard.peekCard().getClass().getName())&& rounds==currentRound){
          if (j==ALLplayers.length && vima==1){ 
           j=0;
          Card temp=Draw.popCard();
          ALLplayers[j].takeCard(temp);
          temp=Draw.popCard();
          ALLplayers[j].takeCard(temp);
          j=j+vima;
          rounds++;
          continue;
          }
          if (j<0 && vima==-1){ 
          j=(ALLplayers.length-1); 
          Card temp=Draw.popCard();
          ALLplayers[j].takeCard(temp);
          temp=Draw.popCard();
          ALLplayers[j].takeCard(temp);
          j=j+vima;
          rounds++;
          continue;}
          
          Card temp=Draw.popCard();
          ALLplayers[j].takeCard(temp);
          temp=Draw.popCard();
          ALLplayers[j].takeCard(temp);
          j=j+vima;
          rounds++;
          if (j==ALLplayers.length && vima==1) 
          j=0; 
          if (j<=0 && vima==-1)
          j=(ALLplayers.length-1); 
          continue;
      }
      
      
      
      
      if(   "model.Wild4".equals(Discard.peekCard().getClass().getName())&& rounds==currentRound){
          if (j==ALLplayers.length && vima==1){ 
          j=0; 
          for( int aaa=0;aaa<4;aaa++)
          ALLplayers[j].takeCard(Draw.popCard());
          j=j+vima;
          rounds++;
          continue;
          }
          if (j<0 && vima==-1){ 
          j=(ALLplayers.length-1); 
          for( int aaa=0;aaa<4;aaa++)
          ALLplayers[j].takeCard(Draw.popCard());
          j=j+vima;
          rounds++;
          continue;}
          
          for( int aaa=0;aaa<4;aaa++)
          ALLplayers[j].takeCard(Draw.popCard());
          j=j+vima;
          rounds++;
          if (j==ALLplayers.length && vima==1) 
          j=0; 
          if (j<=0 && vima==-1)
          j=(ALLplayers.length-1); 
          continue;
      }
      
      
      
            
      
      
      if (j==ALLplayers.length && vima==1){ j=0;rounds++;continue;}
      if (j<0 && vima==-1){ j=(ALLplayers.length-1);rounds++;continue;}
      //if(j)      
            
            
            rounds++;
            
      }
  
  }
  
    
/**
     * Precondition: valid parameters
     * Postcondition: initilises players and card stucks
     * @param players the number of players
     * @param allcards an array with all posible cards in game
     */
public  static    Card[]   init_players_cards(){
    
    int i,fylo,j;
    Card Playercards[];
    Playercards=new Card[30];
     
    
        Random r = new Random();
        
        for (j=0;j<7;j++){
        fylo  =	r.nextInt(108);	
        //System.out.println(fylo);
        
        if (ALLcards[fylo]!=null){
            Playercards[j]=ALLcards[fylo];
            ALLcards[fylo]=null;}
        else{
            while(ALLcards[fylo]==null)
               fylo  =	r.nextInt(108); 
        Playercards[j]=ALLcards[fylo];
                ALLcards[fylo]=null;}
        }
           
    return Playercards;
    }



public static boolean playerplay(Card array[],Card karta){
    int index;
    Wild4 temporary;
    for(index=0;index<array.length;index++){
        
        if(array[index]!=null){
            
            if("model.Wild4".equals(array[index].getClass().getName())){
                
                temporary=(Wild4) array[index];
                if(temporary.match(karta,array)){
                    
                    return true;
                }
            }
                
                if(array[index].match(karta)==true)
                    return true;
        
                    }
        }
    return false;
            }
   



}   



