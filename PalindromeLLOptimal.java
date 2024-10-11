public class PalindromeLLOptimal {
    public static void main(String[] args){
        Node head=new Node(1);
        head=insert(head,2);
        head=insert(head,2);
        head=insert(head,1);
        print(head);
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node second=reverse(slow);
        Node first=head;
        boolean ispalindrome=true;
        while(second!=null){
            if(first.data!=second.data){
                ispalindrome=false;
                break;
            }
            else{
                first=first.next;
                second=second.next;
            }
        }
        System.out.println(ispalindrome);

    }

    public static Node reverse(Node head){
        Node prev=null;
        Node forward=head;
        while(forward!=null){
            forward=head.next;
            head.next=prev;
            prev=head;
            head=forward;
        }
        return prev;
    }

    


    public static Node insert(Node head,int data){
        if(head.next==null){
            head.next=new Node(data);
            return head;
        }
        else{
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=new Node(data);
            return head;
        }

    }

    public static void print(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
}

class Node{
    int data;
    Node next;

    public Node(){};
    public Node(int data){
        this.data=data;
        this.next=null;
    }
    public Node(int data,Node next){
        this.data=data;
        this.next=next;
    }
    
}
