import java.util.Arrays;
import java.util.Scanner;

public class GCD
{
    public static void main(String[] args)
{
    Scanner sc=new Scanner(System.in);
    int num1=sc.nextInt();
    int num2=sc.nextInt();
    int n;

    if(num2>num1)
    {
        num1=num1+num2;
        num2=num1-num2;
        num1=num1-num2;
    }

    while(num2!=0)
    {
        n=num2;
        num2=num1%num2;
        num1=n;
    }
    System.out.println(num1);
}
}
