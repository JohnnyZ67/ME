
public class ParallelSort 
{
	public static void main(String[] args)
	{
		final int LEN = 30;
		
		int[] array = new int[LEN];
		for(int i = 0; i < array.length; i++)
		{
			array[i] = (int)(Math.random()*10);			// Creating an array of 20 to have single digit numbers throughout
		}
		
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");			// Printing the unsorted array
		System.out.println(" | Unsorted.");
		
		int left = 0;
		int mid = LEN/2;
		
		SortThread t1 = new SortThread(left, mid, array);
		SortThread t2 = new SortThread(mid, array.length, array);
		t1.start();
		t2.start();
		
		while(t1.isAlive() || t2.isAlive());
		{
			// Waits until both the threads are complete
		}
		
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");			// Printing the unsorted array
		System.out.println(" | Threads Sorted.");
		
		int[] temp = new int[LEN];
		
		int[] c1 = t1.getCounts();
		int[] c2 = t2.getCounts();
		int cntr = 0;
		
		for(int i = 0; i < 10; i++)
		{
			int num = c1[i] + c2[i];
			
			while(num > 0)
			{
				temp[cntr] = i;
				cntr++;
				num--;
			}
		}
		
		array = temp;
		
		
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");			// Printing the unsorted array
		System.out.println(" | Fully Sorted.");
	}
}
