public class Problem4_Portfolio {

    static class Asset {
        String name;
        double returnRate;

        Asset(String n, double r) {
            name = n;
            returnRate = r;
        }
    }

    public static void main(String[] args) {

        Asset[] arr = {
                new Asset("AAPL", 12),
                new Asset("TSLA", 8),
                new Asset("GOOG", 15)
        };

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Merge Sort:");
        for (Asset a : arr)
            System.out.println(a.name + " " + a.returnRate);
    }

    static void mergeSort(Asset[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    static void merge(Asset[] arr, int l, int m, int r) {
        Asset[] temp = new Asset[r - l + 1];
        int i = l, j = m + 1, k = 0;

        while (i <= m && j <= r)
            temp[k++] = (arr[i].returnRate <= arr[j].returnRate) ? arr[i++] : arr[j++];

        while (i <= m) temp[k++] = arr[i++];
        while (j <= r) temp[k++] = arr[j++];

        for (int x = 0; x < temp.length; x++)
            arr[l + x] = temp[x];
    }
}