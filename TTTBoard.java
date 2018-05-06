/*
 *This program is a Tic Tac Toe game and can use any characters to play. The constructor should take an int parameter indicating the size of the TTT board to 
 *be used. The other constructor takes no arguments, indicating that a standard size 3 board should be used. If size is less than 1, 
 *the program throws an IllegalArgumentException. 
 * @author Sameeh Khan
 * @version 1.0
 * @date 2/11/16
 */
import java.util.*;

public class TTTBoard { 
    private int size;
    public static final int DEFAULT_SIZE = 3;
    public char[][] arr;
    
   /* 
    * @params int size of the board 
    * Constructor, iniitializes board as well as character array and throws exception if size < 1
    * @return none
    * @throws IllegalArgumentException()
    */
    public TTTBoard(int size){
        this.size = size;
        this.arr = new char[size][size];
        if (size < 1)
           throw new IllegalArgumentException();
    
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
            
                arr[i][j] = ' ';
            }
        }
    }
   /*
    *@param none
    * this method initializes a board to the default size of three
    * as well as filling in space characters
    * @return none
    */
    public TTTBoard(){
        
        this.size = DEFAULT_SIZE;
        this.arr = new char[DEFAULT_SIZE][DEFAULT_SIZE];
        
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                arr[i][j] = ' '; 
            }
        }
    }
   /*
    *@param int x & int y
    *@return character array at the chosen indexes x and y
    *this method retrieves the chosen position at (x,y)
    */
    public char get(int x, int y){
      return arr[y][x];
    }
   /*
    *@param int x, int y, char ch
    *@return charcter array at position x,y
    *@throws IndexOutOfBoundsException()
    *this program throws an IndexOutofBoundsException if size or x,y do not stay within 
    *proper bounds
    */     
    public void set(int x, int y, char ch){
       if (x > size-1 || y > size-1 || x < 0 || y < 0){
           throw new IndexOutOfBoundsException();
       }
       else 
       arr[y][x] = ch;
    }
   /*
    * @param none
    * @return int size of board
    */
    public int size(){
        
        return size;
    }
   /*
    * @param none
    * @return char c 
    * helper method that checks to see if row has
    * size amount of same character
    */
    public char RowWinner(){
       
       boolean b = false;
       for (int i = 0; i < size; i++){
           b = true;
           for (int j = 0; j < size-1; j++){
           if (arr[i][j] == ' ' || arr[i][j] != arr[i][j+1]) 
               b = false;           
           }
           if (b)
           return arr[i][0];
           
       }
       
        return ' ';
    }
   /*
    *@param none
    *@return charcter 
    *helper method that checks to see if
    *columns have size amount of same character 
    */
    public char ColWinner(){
        
     
       boolean b = false;;
       for (int i = 0; i < size; i++){//each row
           b = true; 
           for (int j = 0;j < size-1; j++){//each column
            if (arr[j][i] == ' ' || arr[j][i] != arr[j+1][i])
                b = false;
        }
        if (b)
         return arr[0][i];
    }
        return ' ';
    }
   /*
    *@param none
    *@return boolean 
    * Helper method to the winner method
    * uses two diag helper methods to (one in reverse and forward)
    * to determine daig winner
    */
    public boolean DiagWinner(){
        
    if (RightDiagWinner() || LeftDiagWinner())
        return true;
        
        else return false;
    }
   /*
    *@param none
    *@return boolean 
    *helper method to DaigWinner
    *loop itereates from left to right to check DiagWinner
    */ 
    public boolean RightDiagWinner(){
        
        for (int i = 0; i < size-1; i++){
            
            if (arr[i][i] == ' ' || arr[i][i] != arr[i+1][i+1]){                
                    return false;
            }
        }
        return true;
    }
   /* 
    *@return none 
    *@param none
    *decremented loop that checks size amouint of char
    *I found a solution using arr(size-1-l) online 
    *here is the URL to credit the work: 
    *http://www.cs.toronto.edu/~hojjat/108w07/lectures/mar16/TicTacToe.java
    * in order to stay consistant, size-l-1 allows for 
    */
    public boolean LeftDiagWinner(){
        
        for(int j=size-1; j>0; j--){
            if(  arr[j][size - j - 1] == ' ' || arr[j][size - j - 1] != arr[j - 1][size - j] )
                 return false;
            
        }
        return true;
    }
    /*
     *@param none
     *@return character 
     *Checks helper methods
     * winer method utilizes the three helper methods in order 
     *
     */
    public char winner(){

        char c  = ' ';
            c = ColWinner();
            if(c != ' ')
                return c;
            
            c = RowWinner();
            if(c != ' ')
                    return c; 
           
            if (DiagWinner() == true)
                    return arr[1][1];
           
       
        return c;
    }
   /*
    *@param int k (numer of rows)
    *@return String s concatenated 
    *helper method for toString() prints out | | spaces
    */
    public String row(int k){
        
        String s = "";
        for (int i = 0; i < size-1; i++){
           
            s = s + arr[k][i] + "|";
        }
        s = s + arr[k][size - 1];  
        return s;
    }
   /*
    *@param none
    *@return String 
    *helper method for toString(), uses String concatination
    *seperates each row with -+
    */
    public String sep(){
        
        String s = "\n";
        
        for (int i = 0; i < size-1; i++){
            
            s = s + "-+";
        }
        s = s + "-\n";
        return s;
    }
   /*
    *@param none  
    *@return none
    * uses helper methods row() and seperator()
    * to print the board with any character
    * some of the solution was done with Piazza
    */
    public String toString(){
        
        String s  = "";
        for (int i  = 0; i < size-1; i++){
            
            s = s + row(i);
            s = s + sep();
        }
        s = s + row(size-1);
        s = s + "\n"; 
        return s;
    }
    
}