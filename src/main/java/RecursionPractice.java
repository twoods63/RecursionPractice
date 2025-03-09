import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;

public class RecursionPractice {
    public static void main(String[] args) {
        int[] myArray = new int[] {50, 2, 9, 7, 44, 32, 17, 5};
        mergeSort(myArray, 8);
        for(int i = 0; i < 8; i++) {
            System.out.print(myArray[i] + " ");
        }
    }

    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n/2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    public static void  merge (int[] a, int [] l, int [] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
}