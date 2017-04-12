
public class Student implements Comparable<Object>
{
	private String name;
	private String id;
	
	public Student() // generic
	{
		name = "N/A";
		id = "s000000";
	}
	
	public Student(String n, String i) // Parameters Constructor
	{
		name = n;
		id = i;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getId()
	{
		return id;
	}
	
	public String toString()
	{
		return name + ":" + id;
	}

	public int compareTo(Object arg0) 
	{
		Student other = (Student) arg0;
		
		String[] list1 = this.getName().split(" ");
		String[] list2 = other.getName().split(" ");
		
		return list1[1].compareTo(list2[1]);
	}
}
