import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    int count = 0, targetCount = 0;
    int[] target = null;

    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    void sol() throws IOException {
        StringBuilder sb = new StringBuilder();
        int n = read();
        targetCount = read();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = read();

        heapSort(arr);

        if (target != null) {
            for (int num: target) sb.append(num).append(" ");
        } else {
            sb.append(-1);
        }

        System.out.println(sb);
    }

    void heapSort(int[] arr) {
        buildMinHeap(arr, arr.length);

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i - 1);
        }
    }

    void buildMinHeap(int[] arr, int n) {
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, i, n - 1);
        }
    }

    void heapify(int[] arr, int k, int n) {
        int left = 2 * k + 1, right = 2* k + 2, smaller = -1;

        if (right <= n) {
            if (arr[left] < arr[right]) {
                smaller = left;
            } else smaller = right;
        } else if (left <= n) {
            smaller = left;
        } else {
            return;
        }

        if (arr[smaller] < arr[k]) {
            swap(arr, k, smaller);
            heapify(arr, smaller, n);
        }
    }

    void swap(int[] arr, int n1, int n2) {
        int tmp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = tmp;

        count++;
        if (count == targetCount) {
            target = arr.clone();
        }
    }

    int read() throws IOException {
        int c = System.in.read(), n = 0, minus = 1;

        if (c == '-') minus = -1;
        else n = c&15;
        while ((c = System.in.read()) > 32) n = (n<<3) + (n<<1) + (c&15);

        return n * minus;
    }

}