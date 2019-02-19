public class SolutionTest{
	
	public static void main (String[] args){
		Solution solution = new Solution(2,2);
		Solution rand = new Solution(solution);
		rand.setNext(false);
		solution.setNext(true);
		System.out.println(rand);
		System.out.println(solution);
	}
}