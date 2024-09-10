class Node{
    int data;
    Node next;

    public Node(int data, Node next){
        this.data=data;
        this.next=next;
    }
    public Node(int data){
        this.data=data;
    }
    public Node(){}

}
public class LL_Delete_Insert
{   
    //Convert arrray to Linkedlist
    public static Node arr2LL(int[] arr){
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
    //Print the Likedlist
    public static void print(Node head)
    {
        Node temp=head;
        if(head==null)
            System.out.println("Linked list is empty");
        else{
            while(temp!=null)
            {
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
            System.out.println();
        }
    }

    //Remove kth element from the Linkedlist
    public static Node remove_k(Node head,int k){
        if(head==null) return head;
        else if(k==1){
            head=head.next;
            return head;
        }
        else{
            Node temp=head;
            int count=0;
            Node prev=null;
            while(temp!=null){
                count++;
                if(count==k){
                    prev.next=prev.next.next;
                    break;
                }
                prev=temp;
                temp=temp.next;
            }
            return head;
        }}

        //Remove node with specific value
        public static Node remove_value(Node head,int value){
            if(head==null){
                return head;
            }
            else if(head.data==value){
                head=head.next;
                return head;
            }
            else{
                Node temp=head;
                Node prev=null;
                while(temp!=null){
                    if(temp.data==value){
                        prev.next=prev.next.next;
                        break;
                    }
                    prev=temp;
                    temp=temp.next;
                }
                    return head;
            }
        }

    
    //Remove head of the Linkedlist
    public static Node remove_head(Node head){
        head=head.next;
        return head;
    }

    //Remove tail of the Linkedlist
    public static Node remove_tail(Node head){
        if(head==null)
             return head;
        else{
            Node temp=head;
            while(temp.next.next!=null)
            {
                temp=temp.next;
            }
            temp.next=null;
            return head;
        }
    }

    //Insert element at the head of the Linkedlist
    public static Node insert_head(Node head, int value){
        if(head==null){
            return head;
        }
        else{
                Node temp=new Node(value);
                temp.next=head;
                head=temp;
            
            return head;
        }
    }

    //Insert element at the tail of Linkedlist
    public static Node insert_tail(Node head, int value){
            if(head==null){
                return head;
            }
            else{
                Node temp=head;
                while(temp.next!=null){
                    temp=temp.next;
                }
                Node new_node=new Node(value);
                temp.next=new_node;
                return head;
            }
    }

    //Insert element at kth position
    public static Node insert_k(Node head,int k,int value){
        if(head==null){
            if(k==1){
                return new Node(value);
            }
            else{
                return null;
            }
        }
        else if(k==1){
            Node temp=new Node(value);
            temp.next=head;
            head=temp;
            return head;
        }
        else{
            int count=0;
            Node temp=head;
            while(temp!=null){
                count++;
                if(count==k-1){
                    Node new_node=new Node(value);
                    new_node.next=temp.next;
                    temp.next=new_node;
                }
                temp=temp.next;
            }
            return head;
        }
    }

    //Insert before given value
    public static Node insertbeforek(Node head,int element,int value){
        if(head==null){
            return head;
        }
        else if(head.data==value){
            Node temp=new Node(value);
            temp.next=head;
            head=temp;
            return head;
        }
        else{
            Node temp=head;
            while(temp.next!=null){
                if(temp.next.data==element){
                    Node new_node=new Node(value);
                    new_node.next=temp.next;
                    temp.next=new_node;
                    break;
                }
                temp=temp.next;
            }
            return head;
        }
    }


    public static void main(String[] args)
    {
        int[] arr={3,4,5,6,7};
        Node head=arr2LL(arr);
        print(head);
        head=remove_head(head);
        print(head);
        head=remove_tail(head);
        print(head);
        head=remove_k(head,2);
        print(head);
        head=remove_value(head,6);
        print(head);
        head=insert_head(head,2);
        print(head);
        head=insert_tail(head,5);
        print(head);
        head=insert_k(head, 2, 1);
        print(head);
        head=insertbeforek(head, 4, 3);
        print(head);
    }
}