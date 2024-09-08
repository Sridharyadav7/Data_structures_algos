import java.util.*;

public class LL_intro
{
    public static void main(String[] args)
{
    // Create two Nodes separately and connect them
    Node head=new Node(2);
    Node obj2=new Node(3);
    head.next=obj2;
    Node temp=head;
    //Print
    while(temp!=null)
    {
        System.out.println(temp.data+" ");
        temp=temp.next;
    }

    //Convert an array to a linked list and print with the length of the linked list 
    int[] nums={1,2,3,4};
    Node arr2LL = new Node();
    Node head2=arr2LL.array2LL(nums);
    Node temp2=head2;
    int count=0;
    while(temp2!=null)
    {
        System.out.print(temp2.data+" ");
        temp2=temp2.next;
        count++;
    }
    System.out.println("\n"+count);

}
}

class Node
{
    int data;
    Node next;

    public Node(int data,Node next)
    {
        this.data=data;
        this.next=next;
    }
    public Node()
    {

    }
    public Node(int data)
    {
        this.data=data;
        this.next=null;
    }

    //Convert array to linked list
    public Node array2LL(int[] arr)
    {
        Node head=new Node(arr[0]);
        Node mover=head;
        for(int i=1;i<arr.length;i++)
        {
            Node temp=new Node(arr[i]);
            mover.next=temp;
            mover=temp;
        }
        return head;
    }
}





