class Solution {
    List<String> list;
    int N;

    public List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        N = n;
        StringBuilder sb = new StringBuilder();
        check(sb, 0, 0);
        return list;
    }
    public void check(StringBuilder sb, int cnt, int max) {
        if (sb.length() == 2 * N) {
            list.add(sb.toString());
            return;
        }

        if (cnt == 0) {
            sb.append("(");
            check(sb, cnt+1, max+1);
            sb.deleteCharAt(sb.length()-1);
        }

        else if (cnt > 0 && max < N) {
            sb.append("(");
            check(sb, cnt+1, max+1);
            sb.deleteCharAt(sb.length()-1);
            
            sb.append(")");
            check(sb, cnt-1, max);
            sb.deleteCharAt(sb.length()-1);
        }
        else if (cnt > 0 && max == N) {
            sb.append(")");
            check(sb, cnt-1, max);
            sb.deleteCharAt(sb.length()-1);
        }
    } 
}