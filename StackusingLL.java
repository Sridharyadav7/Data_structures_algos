

public class StackusingLL {
    public static void main(String[] args){
        Mystack s1=new Mystack();
        s1.push(2);
        s1.push(3);
        s1.print();
        System.out.println(s1.pop());
        s1.print();
        System.out.println(s1.size());
    }
    
}

class Mystack{
    Node top;

    public void push(int val){
        if(top==null){
            top=new Node(val);
        }
        else{
            Node temp=new Node(val);
            temp.next=top;
            top=temp;
        }
    }
    public int pop(){
        if(top==null){
            return -1;
        }
        else{
            int val=top.data;
            top=top.next;
            return val;
        }

    }
    public void print(){
        Node temp=top;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }

    public int size(){
        if(top==null){
            return 0;
        }
        else{
            int cnt=0;
            Node temp=top;
            while(temp!=null){
                cnt++;
                temp=temp.next;
            }
            return cnt;
        }
    }
    public int peek(){
        if(top==null){
            return -1;
        }
        else{
            return top.data;
        }
    }

}

class Node{
    int data;
    Node next;

    public Node(){}

    public Node(int data){
        this.data=data;
        this.next=null;
    }
    public Node(int data,Node next){
        this.data=data;
        this.next=next;
    }
}