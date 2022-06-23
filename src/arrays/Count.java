package arrays;

public class Count {

	public static void main(String[] args) {
		int a[]= {11,12,13,14,15};
		int e=0;
		int o=0;
		System.out.print("even count:");
		{
		for(int i=0;i<a.length;i++)
		{
			if(a[i]%2==0)
			{
				e++;
			}
		}
		 System.out.println(e);
		
		}
		
		System.out.print("odd count:");
		{
		for(int i=0;i<a.length;i++)
		{
		if(a[i]%2==1)
		{
			o++;
		}
			
		}
			
		System.out.print(o);
}
	}
}
