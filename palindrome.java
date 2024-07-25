import java.util.Scanner;

public class palindrome {
    public static  void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int num=sc.nextInt();
        if(check(num))
        {
            System.out.println("Palindrome");
        }
        else
        {
            System.out.println("No");
        }
    }

    static boolean check(int num)
    {
        int original_num=num;
        int reverse=0;
        int last_digit;
        while(num>0)
        {
            last_digit = num%10;
            reverse = (reverse*10) + last_digit;
            num = num/10;
        }
        if(original_num==reverse)
            return true;
        else
            return false;

    }
    
}
