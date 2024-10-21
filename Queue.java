public class Queue {
    public static void main(String[] agrs){
        Myqueue q=new Myqueue();
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.print();
        System.out.println(q.dequeue());
        q.print();
        q.enqueue(6);
        System.out.println(q.size());
        q.enqueue(7);
    }
}

class Myqueue{
    public int[] queue;
    public int start;
    public int end;

    public Myqueue(){
        queue=new int[5];
        start=0;
        end=-1;
    }
    public void enqueue(int data){
        if(size()==queue.length){
            System.out.println("Queue is full");
        }
        else if(start!=0){
            int i=start;
            start=0;
            while(i<=end){
                queue[start]=queue[i];
                queue[i]=0;
                i++;
                start++;
            }
            start=0;
            queue[end]=data;
            System.out.println(data+" is pushed");
        }
        else{
            queue[++end]=data;
            System.out.println(data+" is pushed");
        }
    }
    public int size(){
        if((end-start)+1<1 || end-start==0){
            return 0;
        }
        else{
            return (end-start)+1;
        }
    }
    public int dequeue(){
        if(size()==0){
            return -1;
        }
        else{
            int popped=queue[start];
            queue[start]=0;
            start++;
            return popped;
        }
    }
    public int peek(){
        return queue[end];
    }
    public void print(){
        for(int i=start;i<=end;i++){
            System.out.print(queue[i]+" ");
        }
        System.out.println("");
    }
}