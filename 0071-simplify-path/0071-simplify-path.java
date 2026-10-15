class Solution {
    public String simplifyPath(String path) {
        int n = path.length();
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        list.add("/");
        String arr[] = path.split("/");

        for (int i = 1; i < arr.length; i++) {

            if (arr[i].equals("") || arr[i].equals(".")) {
                continue;
            }
            else if (arr[i].equals("..")) {
                if (list.size() > 1) {
                    list.remove(list.size() - 1);
                }
                if (list.size() > 1) {
                    list.remove(list.size() - 1);
                }
            }
            else {
                list.add(arr[i]);
                list.add("/");
            }

        }

        if (list.size() == 0) {
            return "/";
        }

        if (list.size() > 1 && list.get(list.size() - 1) == "/") {
            list.remove(list.size() - 1);
        }
        
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }

        return sb.toString();
    }
}