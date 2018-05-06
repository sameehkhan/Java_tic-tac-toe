import java.util.*;
/*
 *This program is an AI for Tic Tac Toe that plays against a human player.
 *The program passes in TTTBoard and uses its methods to play
 *Brute force algorithm that iterates though TTTBoard to find best moves
 * @author Sameeh Khan
 * @date 3/6/16
 * @version 1.0
 * No constructors or fields in this class
 */
public class TTTAI {
   public TTTAI(){      
   }   
  /*
   * @param: TTTBoard board
   * @return int count representing number of empty spaces
   */
   private static int emptyCount(TTTBoard board, char who){ //counts how many positions in board are empty
      int count = 0;
      for (int i = 0; i < board.size(); i++){
         for (int j = 0; j < board.size(); j++){
            if (board.get(i,j) == ' ' && board.get(i,j) != who)
               count++;
         }
      }
      return count;     
   }
   /*
    *@param TTTBoard board, char who, char put
    *@return boolean
    * helper method that checks every spot in the board
    * fills every blank space with char who
    * if char who == winner, then set put
    * then set every other space with a blank char
    */
   private static boolean findWinner(TTTBoard board, char who, char put) {
         
      for (int i = 0; i < board.size(); i++){
         for (int j = 0; j < board.size(); j++){  
            
            if (board.get(i,j) == ' '){
            board.set(i,j,who); 
                        
            if (board.winner() == who){
               board.set(i,j,put);
               return true;
            }   
               board.set(i,j, ' ');
         }
        
      }
   }
   return false;
   }
  /* 
   * @parem TTTBoard board, char who
   * @return char human
   * iterates through who board, if char is not who or space
   * then it is assumed to be human
   */
   private static char findOpponent(TTTBoard board, char who) 
   {
         
      char ai = who;
      char human = '?';
      for (int i = 0; i < board.size(); i++){
         for (int j = 0; j < board.size(); j++){
            if (board.get(i,j) != ' ' && board.get(i,j) != ai)
               human = board.get(i,j);
         }
      }
      return human;  
   }
    /*
     *@param TTTBoard board, char who, int x, int y
     *@return none
     * method sets char who at random position if offensive or defensive strategies aren't needed
     */ 
   private static void randomMove(TTTBoard board, char who)
   {
     
      Random rand  = new Random();
      int x = rand.nextInt(board.size());
      int y = rand.nextInt(board.size());
      
      while (board.get(x,y) != ' ')
      {
         x = rand.nextInt(board.size());
         y = rand.nextInt(board.size());
      }
      board.set(x,y,who);
   } 
   
     /*
      *@param TTTBoard board, char who
      *@return  none
      * move is the main method within the TTTAI class. The method calls upon other helper methods and 
      * TTTBoard to pick the best move. Wins, blocks and sets randomly 
      */
   public static void move(TTTBoard board, char who)
   {
     
      char human = findOpponent(board,who);
           
      if (emptyCount(board, who) == 0 || board.winner() != ' '){
            
         System.out.println("There are no spaces or there is a winner");
         throw new IllegalArgumentException();
      }         
      if (findWinner(board, who, who))
         return;
      
      else if (findWinner(board, human, who))
         return;               
      else
      {
         randomMove(board,who);
         return; 
      }    
                       
   }
   public static void main(String[] args){
   
      TTTBoard board = new TTTBoard();
      TTTAI ai = new TTTAI();
      
    
      board.set(2,2,'x');     
      ai.move(board,'0');
      System.out.println(board.toString());
         
     board.set(2,1,'x');
      System.out.println(board.toString());
      ai.move(board,'0');  
      System.out.println(board.toString());
     
      /*board.set(2,1,human);
      ai.move(board,comp);
      System.out.println(board.toString());
      */   
   }

}
    

