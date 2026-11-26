package temp;

public class Temp3 {

	public static void main(String[] args) {
		//1st change in in main repository
		int no = 153;
		int temp = no;
		int rem = 0;
		int sum = 0;
		
		while(temp!=0)
		{
			rem = temp%10;
			temp = temp/10;
			sum = sum+rem*rem*rem;
		}
		
		System.out.println(sum);
		
	}
}
