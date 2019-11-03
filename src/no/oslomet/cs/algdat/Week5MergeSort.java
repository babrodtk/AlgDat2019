package no.oslomet.cs.algdat;

public class Week5MergeSort {

    /**
     * Merges values[begin, mid) with values[mid, end)
     * @param values
     * @param begin
     * @param mid
     * @param end
     */
    public static void merge(int[] values, int[] tmp, int begin, int mid, int end) {
        //Already sorted
        if (values[mid-1] <= values[mid]) {
            return;
        }

        int n = mid - begin;

        //Kopier fra values inn i temp
        System.arraycopy(values, begin, tmp, 0, n);

        //Int i teller i tmp-variabelen
        int i = 0;

        //j-telleren er i values, starter fra midten
        int j = mid;

        //k-telleren er i values - men brukes som output. Starer på begin
        int k = begin;

        //Så lenge i er innenfor intervallet til "a"
        while (i < n && j < end) {
            if (tmp[i] < values[j]) {
                values[k] = tmp[i];
                ++i;
                ++k;
            }
            else {
                values[k] = values[j];
                ++j;
                ++k;
            }
        }

        //Legg inn resterende tall
        while (i < n) {
            values[k] = tmp[i];
            ++i;
            ++k;
        }
    }

    public static void mergeSort(int[] values, int[] tmp, int begin, int end) {
        int mid = (begin + end) / 2;

        if (end - begin < 2) {
            return;
        }

        //Sort left interval
        mergeSort(values, tmp, begin, mid);

        //Sort right interval
        mergeSort(values, tmp, mid, end);

        //Merges values into a single table
        merge(values, tmp, begin, mid, end);
    }

    /**
     * Starter rekursjonen
     * @param values
     */
    public static void mergeSort(int[] values) {
        int[] tmp = new int[values.length/2];

        mergeSort(values, tmp, 0, values.length);
    }
}
