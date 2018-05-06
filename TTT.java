/*
 *  
 * @author Sameeh Khan
 * @version 5/21/16
 *  -changed class Name to TTT and changed 
 * variables int x and int y to global variables
 */

import java.util.*;
public class TTT
{
   public static void main(String args[])
   {
   
      Scanner in = new Scanner(System.in);
      boolean play = false;
      boolean hasWinner = false;
      System.out.println("Welcome to Alecs game!");
      String input = "";
      int y = -1;
      int x = -1;
      
   
      while(!(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n")))
      {
      
         System.out.println("- Enter [y] to play the game ");
         System.out.println("- Enter [n] to opt out "); 
         input = in.next();
         if (!(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n")))
            System.out.println("incorrect output");
      }
      if (input.equalsIgnoreCase("y"))
      {  play = true;      } 
      else {play = false; }    
     
     /////////////////////////////////////////////////////////////////////////////////////////////
   /////////////////////////////////////////////////////////////////////////////////////////////////
      while (play){
      
         System.out.println("\nThank you for choosing to play!");
         System.out.println("How big do you want the board to be?");
               
         
         int sizecompare = 0;
         do {
            System.out.println("Enter a postive number greater than or equal to 3");
            while (!in.hasNextInt()) 
            {
               System.out.println("That's not a number or your value was less than 3, try again!");
               in.next(); 
            }
            sizecompare = in.nextInt();
         } while (sizecompare < 3);
         System.out.println("The board will be: " + sizecompare + " large");      
      
         
         /////////////////////////////////////////////////////////////////////////////////////////////
        
         TTTBoard board = new TTTBoard(sizecompare);
         TTTAI ai = new TTTAI();        
         System.out.println("Enter the character you would like to use then press ENTER");
         String human = in.next();
         while (human.length() != 1)
         {
            System.out.println("incorrect input, try again");
            human = in.next();
               
         } 
         System.out.println("The char you entered is: " + "[" + human + "]");
         System.out.println();
         
         /////////////////////////////////////////////////////////////////////////////////////////////
      
         System.out.println("Enter the character you would like AI to use then press ENTER\n"+
            "\tMust be ONE character long");
         String comp = in.next();
         while (comp.length() != 1){
                  
            System.out.println("incorrect input, try agian");
            comp = in.next();
         }     
         System.out.println("The char for AI is " + "[" + comp + "]"); 
         System.out.println();
         
          /////////////////////////////////////////////////////////////////////////////////////////////
         hasWinner = true;
         
                     /////////////////////////////////////////////////////////////////////////////////////////
         while (in.hasNextLine() && board.winner() != human.charAt(0) || board.winner() != comp.charAt(0) 
         && hasWinner){ 
            //int x;
            do {
               System.out.println("Enter a X cordinate, but make sure it is within the bounds "+
                  "of the board!");
               while (!in.hasNextInt()) 
               {
                  System.out.println("That's not a number try again!");
                  in.next(); 
               }
               x = in.nextInt();
            } while (x > board.size()-1 || x < 0);
            System.out.println("You chose the X cordinate: " + x); 
         
         
         ///////////////////////////////////////////////////////////////////////////////////////////////
            //int y;
            do {
               System.out.println("Enter a Y cordinate, but make sure it is within the bounds "+
                  "of the board!");
               while (!in.hasNextInt()) 
               {
                  System.out.println("That's not a number or you entered an out of bounds value, try again!");
                  in.next(); 
               }
               y = in.nextInt();
            } while (y > board.size()-1 || y < 0);
            System.out.println("You chose the Y cordinate: " + y); 
         
            
            board.set(x,y,human.charAt(0));
            
            
            if (board.winner() == comp.charAt(0) || board.winner() == human.charAt(0)) {
               System.out.println("GAME OVER!");
               System.out.println("Would you like to play again or give up? I can go all day ;) ");
               hasWinner = false;
               empty(board);
            }
            else if (isFull(board)){
               empty(board);
            }
            ai.move(board, comp.charAt(0));
            System.out.println(board.toString());
         
            if (board.winner() == comp.charAt(0) || board.winner() == human.charAt(0)) {
               System.out.println("GAME OVER!");
               System.out.println("Would you like to play again or give up? I can go all day ;) ");
               hasWinner = false;
               empty(board);
            }
            else if (isFull(board))
               empty(board);
            
            
                 
            if (input.equalsIgnoreCase("y"))
            {  play = true;      } 
            else {play = false; } 
            
         
         }
         if (play == true)
            continue;
         else {
            play = false;
            System.out.println("thanks for playing! Come again soon.");
            break; 
         }
      } 
   }  
                        
      
   private static void empty(TTTBoard board){ 
      for (int i = 0; i < board.size(); i++){
         for (int j = 0; j < board.size(); j++){
            board.set(i,j, ' ');
         }
      }
   }
   private static boolean isFull(TTTBoard board){ 
      for (int i = 0; i < board.size(); i++){
         for (int j = 0; j < board.size(); j++){
            if (board.get(i,j) == ' ')
               return false;
         }
      }
      return true;
   }
}      
      
            

