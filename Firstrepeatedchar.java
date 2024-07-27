import java.util.Arrays;
import java.util.Scanner;

public class Firstrepeatedchar
{
    public static void main(String[] args)
{
    String str="abcdde";
    int len=str.length();
    int[] test=new int[len];
    boolean flag=false;
    
    for(int i=0;i<len;i++)
    {
        test[i]=0;
    }
    for(int i=0;i<len;i++)
    {
        if(test[str.indexOf(str.charAt(i))]==1)
        {
            flag=true;
            System.out.println("First Repeated character is: "+str.charAt(i));
            break;
        }
        else
        {
            test[i]=1;
        }
    }
    if(flag==false)
    {
        System.out.println("No repeated characters");
    }
   
}
}
