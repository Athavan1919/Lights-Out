
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
        if (other == null){
            return false;
        }


        if (other instanceof Solution) {
            Solution c = (Solution) other;
            if (this.counter != c.counter){
                return false; 
            }
            if (this.row == c.row && this.column == c.column) {
                    for(int i=0; i<row;i++) {
                        for (int j=0; j<column;j++) {
                            if (this.gameArray[i][j] != c.gameArray[i][j]) {
                                return false;
                            }
                        }
                    }
                    return true;
            }
        }
        return false; 
        
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
        if (counter >= max) {
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
    * specified and is indeed working, that is, if it 
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
                if (oddCounter[i][j] % 2 == 0){
                    return false;
                }
            }
        }
        return true;
        

    }

   /**
    * this method ensure that add <b>nextValue</b> at the
    * currentIndex does not make the current solution
    * impossible. It assumes that the Solution was
    * built with a series of setNext on which 
    * stillPossible was always true.
    * @param nextValue
    *         The boolean value to add at currentIndex
    * @return true if the board is not known to be
    * impossible (which does not mean that the board
    * is possible!)
    */
    public boolean stillPossible(boolean nextValue) {

        /*Basically if the test setNext results in a cell above being changed to off, the solution must be discarded
        in this method we did a nextValue and then reversed it
        */

        boolean possible; 
        boolean before = gameArray[inital_row][inital_column];

        //Nothing can be changed above so it's always valid in the first row
        if (inital_row == 0){
            return true;
        }

        setNext(nextValue);

        //The steps below are to reverse the effects of nextValue
        counter --;

        if ((inital_row == 0)&&(inital_column == 0)){
            inital_row = row-1;
            inital_column =  column -1;
        }else{
            if (inital_column == 0){
                inital_row -= 1;
                inital_column =  column -1;
            }else{
                inital_column -=1;
            }
        }

        //Now we're back at the starting cell and we test to see if the one above is lit or not
        if (oddCounter[inital_row-1][inital_column] % 2 == 0) {
            possible =  false;
        }else{
            possible = true;
        }

        //revert back to original bool value
        gameArray[inital_row][inital_column] = before;

        //No changes to oddArray if it was false and if it was even then we subtract 1 to revert changes 
        if (nextValue == false){
            return possible;
        
        }else{
            oddCounter[inital_row][inital_column] -= 1;
    
            if ((0 <= (inital_row-1)) && ((inital_row-1) < row)){
                oddCounter[inital_row-1][inital_column] -= 1;
            }

            if ((0 <= (inital_row+1)) && ((inital_row+1) < row)){
                oddCounter[inital_row+1][inital_column] -= 1;
            }

            if ((0 <= (inital_column-1)) && ((inital_column-1) <= column)){
                oddCounter[inital_row][inital_column-1] -= 1;
            }

            if ((0 <= (inital_column+1)) && ((inital_column+1) < column)){
                oddCounter[inital_row][inital_column+1] -= 1;
            }

            return possible;

        }

        /*        
        Alternative cleaner but slower solution 
    
        if (inital_row == 0) {
            return true; 
        }
        Solution test = new Solution(this);
            test.setNext(nextValue);
        if ((test.oddCounter[inital_row-1][inital_column] % 2) == 0) {
            return false;
        }
        return true;
        */    

        
    }


    /**
    * this method attempts to finish the board. 
    * It assumes that the Solution was
    * built with a series of setNext on which 
    * stillPossible was always true. It cannot
    * be called if the board can be extended 
    * with both true and false and still be 
    * possible.
    *
    * @return true if the board can be finished.
    * the board is also completed
    */
    public boolean finish(){
        while (true != isReady()){
            if (stillPossible(true)){
                setNext(true);
            }else{
                setNext(false);
            }
        }
        return (isSuccessful());
    }

    /**
     * returns a string representation of the solution
     *
     * @return
     *      the string representation
     */
    public String toString() {
 
        String array_output = "[[";
            for (int row = 0; row < gameArray.length; row++) {
                if (row>0) {
                    array_output += "[";
                }
                
                for(int column = 0; column < gameArray[row].length; column++) {
                    if (column < gameArray[row].length - 1) {
                        array_output += gameArray[row][column] + ", "; 
                    }
                    else {
                        array_output += gameArray[row][column];
                    }
                    
                }
                
                if (row != gameArray.length - 1) {
                    array_output += ("], " + System.lineSeparator());
                }
                
            }
            array_output += "]]";
            return array_output;
        
    }

}

