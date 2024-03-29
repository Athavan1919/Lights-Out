import java.util.ArrayList;


/**
 * The class <b>LightsOut</b> is the
 * class that implements the method to
 * computs solutions of the Lights Out game.
 * It contains the main of our application.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

public class LightsOut {

    // Your variables here
    public static ArrayListSolutionQueue partialSolutions;
    //public static ArrayList<Solution> solutions;


    /**
     * The method <b>solve</b> finds all the 
     * solutions to the <b>Lights Out</b> game 
     * for an initially completely ``off'' board 
     * of size <b>widthxheight</b>, using a  
     * Breadth-First Search algorithm. 
     *
     * It returns an <b>ArrayList&lt;Solution&gt;</b> 
     * containing all the valid solutions to the 
     * problem.
     *
     * This version does not continue exploring a 
     * partial solution that is known to be
     * impossible
     *
     * During the computation of the solution, the 
     * method prints out a message each time a new 
     * solution  is found, along with the total time 
     * it took (in milliseconds) to find that solution.
     *
     * @param width
     *  the width of the board
     * @param height
     *  the height of the board
     * @return
     *  an instance of <b>ArrayList&lt;Solution&gt;</b>
     * containing all the solutions
     */
    public static ArrayList<Solution> solve(int width, int height){

        long start, stop, elapsed;

        Solution current;
        ArrayList<Solution> solutions = new ArrayList<Solution>();
        partialSolutions = new ArrayListSolutionQueue();

        Solution partial = new Solution(width,height);
        partialSolutions.enqueue(partial);
        
        start = System.currentTimeMillis(); 
    
        while (partialSolutions.isEmpty() != true){
           
            current = partialSolutions.dequeue();
            
            if (current.isReady()){
                if (current.isSuccessful()){
                    
                    solutions.add(current);
                    
                    stop = System.currentTimeMillis(); 
                    elapsed = stop - start;
                    System.out.println("Solution found in " + elapsed+ " ms");
                }

            }else{

                if (current.stillPossible(true) && current.stillPossible(false)){
                    Solution newPartial = new Solution(current);
                
                    current.setNext(false);
                    newPartial.setNext(true);

                    partialSolutions.enqueue(current);
                    partialSolutions.enqueue(newPartial);
                    
                }else{
                    if (current.finish()){
                        partialSolutions.enqueue(current);
                    }

                }

            }
        }
        return solutions;
        
    }

    /**
     * <b>main</b> method  calls the method <b>solve</b> 
     * and then prints out the number of solutions found,
     * as well as the details of each solution.
     *
     * The <b>width</b> and <b>height</b> used by the 
     * main are passed as runtime parameters to
     * the program. If no runtime parameters are passed 
     * to the program, or if the parameters are incorrect,
     * then the default values are used.
     *
     * @param args
     *  Strings array of runtime parameters
     */
    public static void main(String[] args) {

        StudentInfo.display();
        System.out.println("");
        
        for (int i=0; i<args.length; i++) {
            Integer.parseInt(args[i]);              
        }
        
        if (args.length <= 0){
            System.out.println("Invalid width, using default ...");
            System.out.println("Invalid height, using default ...");

            System.out.println("*****");
            
            System.out.println(solve(3,3));
            System.out.println("In a board of 3x3: 1 Solution");

        }
        
        else if(Integer.parseInt(args[0])<=0 || Integer.parseInt(args[1])<=0) {
            System.out.println("Invalid width, using default ...");
            System.out.println("Invalid height, using default ...");

            System.out.println("*****");
            
            System.out.println(solve(3,3));
            System.out.println("In a board of 3x3: 1 Solution");
        }
        else {
            
            ArrayList<Solution> answer = solve(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
            

            for (int i = 0; i < answer.size(); i++){
            System.out.println(answer.get(i));
            System.out.println("*****");
            }
            
            System.out.println("In a board of " + Integer.parseInt(args[0]) +"x" + Integer.parseInt(args[1]) + ": " +
            answer.size() + " Solutions");
        }
        
    }
}


