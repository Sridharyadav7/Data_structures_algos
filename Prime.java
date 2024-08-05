import java.util.*;

public class Prime
{
    public static void main(String[] args)
{
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    check obj=new check();
    boolean result=obj.prime(n);
    System.out.println(result);   
}
}

 class check
{
    public boolean prime(int n)
    {
    int sqroot=(int)Math.sqrt(n);
    ArrayList<Integer> divisors=new ArrayList<Integer>();
    for(int i=1;i<=sqroot;i++)
    {
        if(n%i==0)
        {
            divisors.add(i);
            if(i!=n/i)
            {
                divisors.add(n/i);
            }
        }
    }

    if(divisors.size()==2)
    {
        return true;
    }
    else{
        return false;
    }
    }
}