import java.util.ArrayList;

public class HashTableBase {
    private int counter = 0;
    private ArrayList<String> keysList = new ArrayList<>();
    private Entry[] arr = new Entry[100];

    public void put(String key, String value) {
        if (counter > (0.6 * arr.length)) {
            arr = overflow();
        }
        Entry e = new Entry(key, value);
        int index = hash(key, arr.length);
        if (arr[index] != null) {
            System.err.println("Collision at index: " + index);
        }
        arr[index] = e;
        counter++;
        if (!keysList.contains(key)) keysList.add(key);
    }
    public String get(String key) {
        int index = hash(key, arr.length);
        Entry e = arr[index];
        return e.getVal();
    }
    public ArrayList<String> keySet() {
        return keysList;
    }
    private Entry[] overflow() {
        Entry[] newArr = new Entry[arr.length*2];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                int newIndex = hash(arr[i].getKey(), newArr.length);
                newArr[newIndex] = arr[i];
            }
        }
        return newArr;
    }
    public int size() {
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
