public class Problem2_ClientRisk {

    static class Client {
        String name;
        int riskScore;

        Client(String n, int r) {
            name = n;
            riskScore = r;
        }
    }

    public static void main(String[] args) {

        Client[] arr = {
                new Client("A", 20),
                new Client("B", 50),
                new Client("C", 80)
        };

        bubbleSort(arr);

        System.out.println("Bubble Sort:");
        for (Client c : arr)
            System.out.println(c.name + " " + c.riskScore);

        insertionSort(arr);

        System.out.println("\nInsertion Sort:");
        for (Client c : arr)
            System.out.println(c.name + " " + c.riskScore);
    }

    static void bubbleSort(Client[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - i - 1; j++)
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    static void insertionSort(Client[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].riskScore < key.riskScore) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}