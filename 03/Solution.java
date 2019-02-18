
/**
 * The class <b>Solution</b> is used
 * to store a (partial) solution to the game
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */
public class Solution {


    // Your variables here


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

        //Your code here
        
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

        //Your code here
        
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

        //Your code here
        
    }


    /** 
    * returns <b>true</b> if the solution 
    * has been entirely specified
    *
    * @return
    * true if the solution is fully specified
    */
    public boolean isReady(){

        //Your code here
        
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

        //Your code here
        
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

        //Your code here
        

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

        //Your code here
        

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

        //Your code here
        
    }


    /**
     * returns a string representation of the solution
     *
     * @return
     *      the string representation
     */
    public String toString() {
 
        //Your code here
        
    }

}

