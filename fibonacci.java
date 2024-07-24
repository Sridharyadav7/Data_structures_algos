import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        if(n==1)
        {
            System.out.println(0);
        }
        else if(n==3 || n==2)
        {
            System.out.println(1);
        }
        else
        {
            arr[0]=0;
            arr[1]=1;
            for(int i=2;i<n;i++)
            {
                arr[i]=arr[i-1]+arr[i-2];
            }
        System.out.println(arr[n-1]);
        }
        
    }
    
}
