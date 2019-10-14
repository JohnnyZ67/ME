
public class SortThread extends Thread
{
	private int bI;
	private int eI;
	private int[] array;
	private int[] counts;
	
	public SortThread(int b, int e, int[] a)
	{
		bI = b;
		eI = e;
		array = a;
		counts = new int[10];
	}
	
	public void run()
	{
		for(int i = 0; i < 10; i++)		// initializes all counts at 0
			counts[i] = 0;
		
		for(int i = bI; i < eI; i++)	// Start of Counter Sort
			counts[array[i]]++;
		
		int ind = bI;
		for(int a = 0; a < counts.length; a++)
		{
			int num = counts[a];
			while(num > 0)
			{
				array[ind] = a;
				ind++;
				num--;			// Recreating the data within the original array
			}
		}
	}
	
	public int[] getCounts()
	{
		return counts;
	}
}
