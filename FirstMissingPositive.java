import java.util.*;

public class FirstMissingPositive
{
    public int firstMissingPositive(int[] nums) {
        int j=1;
        Arrays.sort(nums);
        for(int i:nums){
            if(i==j)
                j++;
        }
        return j;
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int n=x.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
		    a[i]=x.nextInt();
		System.out.println(firstMissingPositive(a));
	}
}
