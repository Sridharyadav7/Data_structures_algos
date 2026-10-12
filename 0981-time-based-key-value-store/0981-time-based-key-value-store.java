class TimeMap {
    Map<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        int low = 0;
        int high = map.get(key).size() - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if (map.get(key).get(mid).timestamp <= timestamp) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        if (high < 0) {
            return "";
        }

        return map.get(key).get(high).val;
    }
}

class Pair {
    int timestamp;
    String val;

    public Pair (int _timestamp, String _val) {
        this.timestamp = _timestamp;
        this.val = _val;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */