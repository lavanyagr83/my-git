package arrays;

public class Average {

	public static void main(String[] args) {
	int a[]= {10,20,30,40,50};
	int s=0;
	int A;
	for(int i:a)
	{
		s=s+i;
		
	}
	A=s/a.length;
	
	System.out.print("Average:"+A);

	}

}
