// 1598. Crawler Log Folder
class MinOperations {
    public int minOperations(String[] logs) {
        int res=0;
        for(String i:logs){
            if(i.charAt(0)=='.'){
                if(i.charAt(1)=='.' && res>0)
                    res--;
            }else
                res++;
        }
        return res;
    }
}
