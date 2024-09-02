import java.util.*;

public class LargestOddNuminString
{
    public static void main(String[] args)
{
    String s="10133890";
    int check=s.charAt(s.length()-1)-48;
    int max=Integer.MIN_VALUE; 
    boolean flag=false;
    int end=0;
    if(check%2!=0)
    {
        System.out.println(s); 
    }
    else
    {
        for(int i=s.length()-2;i>=0;i--)
        {
            int temp=s.charAt(i)-48;
            if(temp%2!=0)
            {
                flag=true;
                end=i;
                break;
            }
        }
    }   
    if(flag==true)
    {
        System.out.println(s.substring(0,end+1)); 
    }
    else
    {
        System.out.println(""); 
    }
}
}





