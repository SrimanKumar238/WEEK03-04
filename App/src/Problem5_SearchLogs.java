public class Problem5_SearchLogs {

    public static void main(String[] args) {

        String[] arr = {"accA", "accB", "accB", "accC"};

        System.out.println("Linear: " + linear(arr, "accB"));
        System.out.println("Binary: " + binary(arr, "accB"));
        System.out.println("Count: " + count(arr, "accB"));
    }

    static int linear(String[] arr, String target) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i].equals(target)) return i;
        return -1;
    }

    static int binary(String[] arr, String target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) return mid;
            else if (arr[mid].compareTo(target) < 0) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    static int count(String[] arr, String target) {
        int c = 0;
        for (String s : arr)
            if (s.equals(target)) c++;
        return c;
    }
}