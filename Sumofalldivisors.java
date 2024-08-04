import java.util.*;

public class Sumofalldivisors
{
    public static void main(String[] args)
{
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] sum=new int[n];
    int final_sum=0;
    for(int j=1;j<=n;j++)
    {
        int sum_divisor=0;
        int num=j;
        ArrayList<Integer> divisors = new ArrayList<Integer>();
        int sqroot=(int) Math.sqrt(j);
        for(int i=1;i<=sqroot;i++)
        {
            if(num%i==0)
            {
                divisors.add(i);

                if(i!=num/i)
                {
                    divisors.add(num/i);
                }
            }
        }
        for(int i=0;i<divisors.size();i++)
        {
            sum_divisor=sum_divisor+divisors.get(i);
        }
        sum[j-1]=sum_divisor;
        divisors.clear();
    }
    for(int i=0;i<sum.length;i++)
    {
        final_sum=final_sum+sum[i];
    }
    System.out.print(final_sum);
}
}
