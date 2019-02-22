public class SolutionTest{
	
	public static void main (String[] args){
		Solution solution = new Solution(3,2);
		Solution rand = new Solution(solution);
		rand.setNext(true);
		System.out.println(rand.isSuccessful());
		rand.setNext(false);
		System.out.println(rand.isSuccessful());
		
		rand.stillPossible(true);
		System.out.println(rand.isSuccessful());

	}
}