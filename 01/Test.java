public class Test{
	public static void main (String[] args){
		Solution solution;
		solution = new Solution(2,2);
		solution.setNext(true);
		solution.setNext(true);
		solution.setNext(false);
		System.out.println("Midway - The solution is ready: " + solution.isReady());
		solution.setNext(true);
		//solution.setNext(true);
		//solution.setNext(false);
		System.out.println("The solution is ready: " + solution.isReady());
		System.out.println("The solution is: ");
		System.out.println(solution);
		System.out.println("Solution is successful: " + solution.isSuccessful());

	}
}