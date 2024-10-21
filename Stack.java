import java.util.*;

public class Stack {

    public static void main(String[] args){
    Mystack st=new Mystack();
    st.push(2);
    st.push(3);
    st.push(4);
    st.print();
    System.out.println("Popped "+st.pop());
    st.print();
    System.out.println(st.size());
    }
    
}

class Mystack{

    public int[] stack; 
    public int top;

    public Mystack(){
        stack=new int[100];
        top=-1;
    }
    public void push(int data){
        if(Stackoverflow()){
            System.out.println("Stack Overflow !");
        }
        else{
            stack[++top]=data;
            System.out.println(data +" pushed");
        }
    }
    public int pop(){
        if(Stackunderflow()){
            return -1;
        }
        else{
            int popped=stack[top];
            stack[top]=0;
            top--;
            return popped;
        }
    }
    public boolean Stackoverflow(){
        return top==stack.length-1;
    }
    public boolean Stackunderflow(){
        return top==-1;
    }
    public int peek(){
        return stack[top];
    }
    public void print(){
        for(int i=0;i<=top;i++)
        {
            System.out.print(stack[i]+" ");
        }
        System.out.println("");
    }
    public int size(){
        return top+1;
    }

}