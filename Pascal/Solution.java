class Solution {
    public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> a=new ArrayList<List<Integer>>();
    List<Integer> s=new ArrayList<>();
    s.add(1);
    a.add(s);
    if(numRows==1)
        return a;
    s=new ArrayList<>();
    s.add(1);
    s.add(1);
    a.add(s);
    for(int i=2;i<numRows;i++){ 
        List<Integer> b=new ArrayList<>();
        b.add(1);
        for(int j=0;j<s.size()-1;j++)
            b.add(s.get(j)+s.get(j+1));
        b.add(1);
        a.add(b);
        s=b; 
    }
    return a;
    }
}