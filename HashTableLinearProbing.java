import java.util.ArrayList;
import java.util.Arrays;

public class HashTableLinearProbing {
    private int counter = 0;
    private ArrayList<String> keysList = new ArrayList<>();
    private double MAX_LOAD = 0.6;
    private int STORAGE = 100;
    private Entry[] arr = new Entry[STORAGE];

    public void put(String key, String value) {
        if (counter > (MAX_LOAD * arr.length)) {
            overflow();
        }
        Entry e = new Entry(key, value);
        int index = hash(key, arr.length);
        while (arr[index] != null) {
            index++;
            index = index % arr.length;
        }
        arr[index] = e;
        counter++;
        keysList.add(key);
    }
    public String get(String key) {
        int index = hash(key, arr.length);
        Entry e = arr[index];
        while (arr[index] != null && !arr[index].key.equals(key)) {
            index++;
            index = index % arr.length;
        }

        if (arr[index] == null) return null;
        return arr[index].value;
    }
    public ArrayList<String> keySet() {
        return keysList;
    }
    private Entry[] overflow() {
        Entry[] newArr = new Entry[arr.length*2];
        for (Entry entry : arr) {
            if (entry != null) {
                int newIndex = hash(entry.getKey(), newArr.length);
                newArr[newIndex] = entry;
            }
        }
        arr = newArr;
        return arr;
    }
    public int size() {
        System.out.println(Arrays.toString(arr));
        return counter;
    }
    private int hash(String in, int n) {
        long hash = 0;
        for (int i = 0; i < in.length(); i++){
            hash = (hash * 31) + (int)in.charAt(i);
        }
        return (int)(hash % n);
    }
}