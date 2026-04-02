import java.util.*;

public class Problem1_Transaction {

    static class Transaction {
        String id;
        double fee;
        String timestamp;

        Transaction(String id, double fee, String timestamp) {
            this.id = id;
            this.fee = fee;
            this.timestamp = timestamp;
        }
    }

    public static void main(String[] args) {

        List<Transaction> list = new ArrayList<>();
        list.add(new Transaction("id1", 10.5, "10:00"));
        list.add(new Transaction("id2", 25.0, "09:30"));
        list.add(new Transaction("id3", 5.0, "10:15"));

        bubbleSort(list);

        System.out.println("Bubble Sort:");
        for (Transaction t : list)
            System.out.println(t.id + " " + t.fee);

        insertionSort(list);

        System.out.println("\nInsertion Sort:");
        for (Transaction t : list)
            System.out.println(t.id + " " + t.fee + " " + t.timestamp);

        System.out.println("\nHigh Fee:");
        for (Transaction t : list)
            if (t.fee > 50)
                System.out.println(t.id);
    }

    static void bubbleSort(List<Transaction> list) {
        for (int i = 0; i < list.size() - 1; i++)
            for (int j = 0; j < list.size() - i - 1; j++)
                if (list.get(j).fee > list.get(j + 1).fee)
                    Collections.swap(list, j, j + 1);
    }

    static void insertionSort(List<Transaction> list) {
        for (int i = 1; i < list.size(); i++) {
            Transaction key = list.get(i);
            int j = i - 1;

            while (j >= 0 &&
                    (list.get(j).fee > key.fee ||
                            (list.get(j).fee == key.fee &&
                                    list.get(j).timestamp.compareTo(key.timestamp) > 0))) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }
}