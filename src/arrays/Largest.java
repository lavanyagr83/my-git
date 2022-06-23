package arrays;

public class Largest {

	public static void main(String[] args) {
		int a[]= {10,5,-15,20,-30};
		int l=a[0];
		for(int i=0;i<a.length;i++)
		{
			if(l<a[i])
			{
				l=a[i];
			}
		}
			
		System.out.print("Largest no:"+l);
			
		}
	}

