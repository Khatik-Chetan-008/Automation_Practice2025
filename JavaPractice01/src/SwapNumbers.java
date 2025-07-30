
public class SwapNumbers {

	public static void main(String[] args) {
		// swap two numbers without using third variable
		
		int a =250;
		int b=580;
		 a=a+b;
		 b=a-b;
		 a=a-b;
		 
		 System.out.println("value of a after swap:" + a);
		 System.out.println("value of b after swap:" + b);
		
		//swap tow numbers uyisng third variable 
		 
		 int x =10;
		 int y=20;
		 int temp=0;
		 
		temp=x;
		x=y;
		y=temp;
		
		 System.out.println("value of x after swap:" + x);
		 System.out.println("value of y after swap:" + y);
	}

}
