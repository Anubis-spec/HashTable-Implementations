public class Main {
    public static void main(String[] args) {
        NaiveImplementation naive = new NaiveImplementation();
        HashTableBase base = new HashTableBase();
        HashTableChaining chain = new HashTableChaining();
        HashTableLinearProbing linear = new HashTableLinearProbing();

        linear.put("David", "45");
        linear.put("Vishy", "93");
        linear.put("Khan", "73");
        linear.put("Daniel", "34");
        System.out.println(linear.size());
        System.out.println(linear.keySet());
    }
}