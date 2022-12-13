import java.util.ArrayList;

public class HashTableChaining {
    private int counter = 0;
    private ArrayList<String> keysList = new ArrayList<>();
    private double MAX_LOAD = 0.6;

    private ArrayList<Entry>[] arr = new ArrayList[100];

    public void put(String key, String value) {
        if (counter > (MAX_LOAD * arr.length)) {
            arr = overflow();
        }
        Entry e = new Entry(key, value);
        int index = hash(key, arr.length);
        if (arr[index] != null) {
            System.err.println("Collision at index (Adding to arraylist): " + index);
            arr[index] = new ArrayList<>();
            arr[index].add(e);
        }
        arr[index] = new ArrayList<>();
        arr[index].add(e);
        counter++;
        if (!keysList.contains(key)) keysList.add(key);
    }
    public String get(String key) {
        int index = hash(key, arr.length);
        for (int i = 0; i < arr[index].size(); i++) {
            if (arr[index].get(i).getKey().equals(key)) {
                Entry e = arr[index].get(i);
                return e.getVal();
            }
        }
        return null;
    }
    public ArrayList<String> keySet() {
        return keysList;
    }
    private ArrayList<Entry>[] overflow() {
        ArrayList<Entry>[] newArr = new ArrayList[arr.length*2];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                for (int j = 0; j < arr[i].size(); j++) {
                    int newIndex = hash(arr[i].get(j).getKey(), newArr.length);
                    newArr[newIndex] = new ArrayList<>();
                    newArr[newIndex].add(arr[i].get(j));
                }
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