class TimeMap {
    class Data{
        String val;
        int time;
        Data(String val, int time){
            this.val = val;
            this.time = time;
        }
    }
    HashMap<String, List<Data>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Data(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        String ans = "";
        if(!map.containsKey(key)) return ans;

        List<Data> data = map.get(key);
        int l = 0, r = data.size() - 1 , mid = 0;
        while(l <= r){
            mid = l + (r - l) / 2;
            if (data.get(mid).time <= timestamp){
                ans = data.get(mid).val ;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
