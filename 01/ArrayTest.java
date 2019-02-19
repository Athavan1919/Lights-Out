public class ArrayTest{
	public static void main (String[] args){
		ArrayListSolutionQueue queue = new ArrayListSolutionQueue();
		for (int i = 1; i < 5; i++){
			Solution solution = new Solution(i,2);
			queue.enqueue(solution);
		}
		System.out.println(queue.size());
		Solution random = queue.dequeue();
		System.out.println(random);
		System.out.println(queue.size());

	}
}