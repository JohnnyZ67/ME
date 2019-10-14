
public class ParallelSearch
{	
	public static void main(String[] args) 
	{
		int[] array = new int[20];
		for(int i = 0; i < array.length; i++)
		{
			array[i] = (int)(Math.random()*10);
		}
		
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
		
		int midpoint = array.length/2;
		
		SearchThread t1 = new SearchThread(0, midpoint, array, 5);
		SearchThread t2 = new SearchThread(midpoint, array.length, array, 5);
		t1.start();
		t2.start();
	}
}
