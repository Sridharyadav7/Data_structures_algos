import java.util.Arrays;
import java.util.Scanner;


public class Armstrong
{
    public static void main(String[] args)
{
    Scanner sc=new Scanner(System.in);
    int num=sc.nextInt();
    int original=num;
    int digits=(int)(Math.log10(num)+1);
    int[] nums=new int[digits];
    int last_digit;
    int[] square=new int[digits];
    for(int i=0;i<digits;i++)
    {
        if(num>=1)
        {   last_digit=num%10;
            nums[i]=(int)Math.pow(last_digit, digits);
            num=num/10;
        }
    }
    
    
    int result=0;
    for(int i=0;i<digits;i++)
    {
        result=result+nums[i];
    }
    if(original==result)
    {
        System.out.println("true");
    }
    else
    {
        System.out.println("false");
    }
}
}
