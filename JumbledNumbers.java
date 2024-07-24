// 2191. Sort the Jumbled Numbers
class Element{
    int data;
    int pre;
    Element(int data,int pre){
        this.data=data;
        this.pre=pre;
    }
}

class JumbledNumbers {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n=nums.length;
        Element[] elements=new Element[n];
        for(int i=0;i<n;i++){
            String d=Integer.toString(nums[i]);
            String r="";
            for(int j=0;j<d.length();j++)
                r+=Integer.toString(mapping[(int)d.charAt(j)-'0']);
            elements[i]=new Element(nums[i],Integer.parseInt(r));
        }
        Arrays.sort(elements,new Comparator<Element>(){
            public int compare(Element a,Element b){
                return Integer.compare(a.pre,b.pre);
            }
        });
        for(int i=0;i<n;i++)
            nums[i]=elements[i].data;
        return nums;
    }
}
