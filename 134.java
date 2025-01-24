class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int pos=0;
        int total=0;
        int sum=0;
     
        for(int i=0;i<n;i++){
            total+=(gas[i]-cost[i]);
            sum+=(gas[i]-cost[i]);
            if(sum<0){
                pos=i+1;
                sum=0;
            }
        }
        if(total<0) return -1;
        else return pos;
    }
}