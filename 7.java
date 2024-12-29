class Solution {
    public int reverse(int x) {
        if(x==0) return 0;
        int original=x;
        if(x<0){ x=x*-1;}
        if((x%10)==0){
            x=remove_zeroes(x);
        }
        int reversed=0;
        while(x>0){
            int last_digit=x%10;
            if(reversed > Integer.MAX_VALUE/10) return 0;
            reversed=(reversed*10)+last_digit;
            x=x/10;
        }
    
        if(original<0) return -1*reversed;
        else return reversed;
        
    }

    public int remove_zeroes(int num){
        String s=Integer.toString(num);
        int j=s.length()-1;
        while(s.charAt(j)=='0'){
            j--;
        }
        return Integer.parseInt(s.substring(0,j+1)); 
        }
}