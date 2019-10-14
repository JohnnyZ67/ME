
public class SearchThread extends Thread
{
	private int bI;
	private int eI;
	private int[] array;
	private int target;
	
	public SearchThread(int b, int e, int[] a, int t)
	{
		bI = b;
		eI = e;
		array = a;
		target = t;
	}
	
	public void run()
	{
		for(int i = bI; i < eI; i++)
		{
			if(array[i] == target)
				System.out.println("The target is located at index: " + (i+1));
			
			//System.out.println("HEY");
		}
	}
}
