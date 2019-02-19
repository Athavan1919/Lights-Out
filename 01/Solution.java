
/**
 * The class <b>Solution</b> is used
 * to store a (partial) solution to the game
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */
public class Solution {


    private int row;
    private int column;
    
    private int inital_row = 0;
    private int inital_column = 0;
    private int counter = 0;
    
    private boolean[][] gameArray;
    private int [][] oddCounter; 
    

    /**
     * Constructor. Creates an instance of Solution 
     * for a board of size <b>widthxheight</b>. That 
     * solution does not have any board position
     * value explicitly specified yet.
     *
     * @param width
     *  the width of the board
     * @param height
     *  the height of the board
     */
    public Solution(int width, int height) {

        row = height;
        column = width;
        gameArray = new boolean[row][column];
        oddCounter = new int[row][column];

    }

   /**
     * Constructor. Creates an instance of Solution 
     * wich is a deep copy of the instance received
     * as parameter. 
     *
     * @param other
     *  Instance of solution to deep-copy
     */
     public Solution(Solution other) {
     	row =other.row;
    	column = other.column;
    
    	inital_row = other.inital_row;
    	inital_column =other.inital_column;
    	counter =other.counter;
    
    	gameArray = new boolean[row][column];
    	for (int i = 0; i < row; i++){
    		for (int j = 0; j < column; j++){
    			gameArray[i][j] =  other.gameArray[i][j];
    		}
    	}

    	oddCounter = new int [row][column];
    	for (int x = 0; x < row; x++){
    		for (int y = 0; y < column; y++){
    			oddCounter[x][y] = other.oddCounter[x][y];
    		}
    	}
   

    }


    /**
     * returns <b>true</b> if and only the parameter 
     * <b>other</b> is referencing an instance of a 
     * Solution which is the ``same'' as  this 
     * instance of Solution (its board as the same
     * values and it is completed to the same degree)
     *
     * @param other
     *  referenced object to compare
     */

    public boolean equals(Object other){

        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        return true;        
    }


    /** 
    * returns <b>true</b> if the solution 
    * has been entirely specified
    *
    * @return
    * true if the solution is fully specified
    */
    public boolean isReady(){

        int max = row*column;
        if (counter == max) {
            return true;
        }
        return false;
        
            
    }

    /** 
    * specifies the ``next'' value of the 
    * solution. 
    * The first call to setNext specifies 
    * the value of the board location (1,1), 
    * the second call specifies the value
    *  of the board location (1,2) etc. 
    *
    * If <b>setNext</b> is called more times 
    * than there are positions on the board, 
    * an error message is printed out and the 
    * call is ignored.
    *
    * @param nextValue
    *  the boolean value of the next position
    *  of the solution
    */
    public void setNext(boolean nextValue) {

    	if (nextValue == true){
        		oddCounter[inital_row][inital_column] += 1;
        
	        	if ((0 <= (inital_row-1)) && ((inital_row-1) < row)){
	        		oddCounter[inital_row-1][inital_column] += 1;
	        	}

	        	if ((0 <= (inital_row+1)) && ((inital_row+1) < row)){
	        		oddCounter[inital_row+1][inital_column] += 1;
	        	}

	        	if ((0 <= (inital_column-1)) && ((inital_column-1) <= column)){
	        		oddCounter[inital_row][inital_column-1] += 1;
	        	}

	        	if ((0 <= (inital_column+1)) && ((inital_column+1) < column)){
	        		oddCounter[inital_row][inital_column+1] += 1;
	        	}

       	}	

        
        gameArray[inital_row][inital_column] = nextValue;
        inital_column++;
        
        
        if(inital_column == column) {
            inital_column = 0;
            inital_row++;
            if (inital_row == row) {
                inital_row = 0;
            }
        }
        
        if (inital_column > column || inital_row > row) {
            System.out.println("Max column or row is reached");
        }
        
        counter++;


    } 
    
    /**
    * returns <b>true</b> if the solution is completely 
    * specified and is indeed working, thatis, if it 
    * will bring a board of the specified dimensions 
    * from being  entirely ``off'' to being  entirely 
    * ``on''.
    *
    * @return
    *  true if the solution is completely specified
    * and works
    */
    public boolean isSuccessful(){

        for (int i = 0; i < row; i++){
        	for (int j = 0; j < column; j++){
        		//System.out.println(oddCounter[i][j]);
        		if (oddCounter[i][j] % 2 == 0){
        			return false;
        		}
        	}
        }
        return true;
        

    }


    /**
     * returns a string representation of the solution
     *
     * @return
     *      the string representation
     */
    public String toString() {
 
        String aString = "";
          for(int row = 0; row < gameArray.length; row++) {
             for(int col = 0; col < gameArray[row].length; col++) {
                    aString += " " + gameArray[row][col];
             }
          }
          return "[" + aString + "]";        
    }

}