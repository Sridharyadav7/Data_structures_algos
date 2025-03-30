class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        int cnt=1;
        int i=1;
        List<Meeting> list=new ArrayList<>();
        for(int j=0;j<end.length;j++){
            list.add(new Meeting(start[j],end[j]));
        }
        Collections.sort(list, (a,b) -> Integer.compare(a.end,b.end));
        for(int j=0;j<list.size();j++){
            start[j]=list.get(j).start;
            end[j]=list.get(j).end;
        }
        int prevEnd=end[0];
        while(i<end.length){
            if(start[i]>prevEnd){
                cnt++;
                prevEnd=end[i];
            }
            i++;
        }
        return cnt;
    }
}


class Meeting{
    int start,end;
    Meeting(int start,int end){
        this.start=start;
        this.end=end;
    }
}