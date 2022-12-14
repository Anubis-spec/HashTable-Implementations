public class Main {
    public static void main(String[] args) {
        NaiveImplementation naive = new NaiveImplementation();
        HashTableBase base = new HashTableBase();
        HashTableChaining chain = new HashTableChaining();
        HashTableLinearProbing linear = new HashTableLinearProbing();

        chain.put("Vishy", "93");
        chain.put("Khan", "73");
        chain.put("Daniel", "34");
        System.out.println(chain.size());
        System.out.println(chain.keySet());
    }
}