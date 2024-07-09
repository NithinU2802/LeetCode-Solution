// 1701. Average Waiting Time
class AverageWaitingTime {
    public double averageWaitingTime(int[][] customers) {
        long s=customers[0][0],r=0;
        for(int i=0;i<customers.length;i++){
            s=Math.max(s,customers[i][0]);
            s+=customers[i][1];
            r+=s-customers[i][0];
        }
        return (r*1.0)/(customers.length*1.0);
    }
}
