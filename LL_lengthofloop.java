class LL_lengthofloop{
    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {
        if(containsloop(head)){
        Node slow=head;
        Node fast=head;
        int count=0;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                slow=head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                count=1;
                slow=slow.next;
                while(slow!=fast){
                    count++;
                    slow=slow.next;
                }
                break;
            }
            
        }
            return count;
        }
        else{
            return 0;
        }
    }
    
    public boolean containsloop(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}