import java.util.ArrayList;

public class NaiveImplementation {
    ArrayList<String> names = new ArrayList<>();
    ArrayList<Integer> ages = new ArrayList<>();
    public void put(String name, int age) {
        if (names.contains(name)) {
            int index = names.indexOf(name);
            ages.set(index, age);
        } else {
            names.add(name);
            ages.add(age);
        }
    }
    public Integer get(String name) {
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equals(name)) {
                return ages.get(i);
            }
        }
        System.err.println("Key doesn't exist");
        return null;
    }
}
