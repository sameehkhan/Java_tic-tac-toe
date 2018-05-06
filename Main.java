import java.util.*;
public class Main{
   public static void main(String args[]){
   
   
      Scanner in = new Scanner(System.in);
      TTTBoard board = new TTTBoard();
      TTTAI ai = new TTTAI();      
      System.out.println("Welcome,This board uses (x,y) values to play the game, enter character you want to play as:    ");
      char human = in.next().charAt(0); 
      
      System.out.println("Enter the ai character:     ");
      char comp = in.next().charAt(0);
      
      System.out.println("Now enter cordinates your x cordinate:  ");
      int x = in.nextInt();
      
      System.out.println("And your y coridinate: ");
      int y = in.nextInt();
      board.set(x,y,human);
      ai.move(board, comp);
      System.out.println(board.toString());

      System.out.print("Enter another x value... ");
      
      while (in.hasNextLine() && board.winner() != human || board.winner() != comp){
      
            x = in.nextInt();
      
            System.out.println("Now enter another y value");
      
            y = in.nextInt();
            board.set(x,y,human);
            ai.move(board, comp);
            System.out.println(board.toString());
            System.out.println("Enter you X, press ENTER, then pick your Y value:   ");
      
               if (board.winner() == comp || board.winner() == human){
                        System.out.println("Congrats to " + board.winner() + " for winning!");
                        break;
                        }
                       else{ continue;} 
                        
               
       }
          

    }  
}