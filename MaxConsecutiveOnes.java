import java.util.*;

public class MaxConsecutiveOnes
{
    public static void main(String[] args)
{
    int[] arr={1, 0, 1, 1, 0, 1};
    int n=arr.length;
    int i=0;
    int prev_cnt=0;
    int cur_cnt=0;
    while(i<n)
    {
        if(arr[i]==1)
        {
            cur_cnt++;
            i++;
        }
        else if(arr[i]==0)
        {
            if(cur_cnt>prev_cnt)
            {
                prev_cnt=cur_cnt;
                cur_cnt=0;
                i++;
            }
            else
            {
                cur_cnt=0;
                i++;
            }
        }
    }
    System.out.println(Math.max(prev_cnt,cur_cnt));
}
}



