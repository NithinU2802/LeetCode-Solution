// 1508. Range Sum of Sorted Subarray Sums
class RangeSum {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int m=(n*(n+1))/2,k=0;
        int[] b=new int[m];
        for(int i=0;i<nums.length;i++){
            int s=0;
            for(int j=i;j<nums.length;j++){
                s+=nums[j];
                b[k++]=s;
            }
        }
        Arrays.sort(b);
        long res=0;
        for(int i=left-1;i<right;i++)
            res+=b[i];
        return (int)(res%1000000007);
    }
}
