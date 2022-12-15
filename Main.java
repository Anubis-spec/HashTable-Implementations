public class Main {
    public static void main(String[] args) {
        NaiveImplementation naive = new NaiveImplementation();
        HashTableBase base = new HashTableBase();
        HashTableChaining chain = new HashTableChaining();
        HashTableLinearProbing linear = new HashTableLinearProbing();
    }
}