public class SolutionTest{
	
	public static void main (String[] args){
		Solution solution = new Solution(3,2);
		Solution rand = new Solution(solution);
		rand.setNext(false);
		rand.setNext(false);
		rand.setNext(true);
		rand.setNext(true);
		
		System.out.println(rand.stillPossible(true));

	}
}