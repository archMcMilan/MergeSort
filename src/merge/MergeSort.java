package merge;

/**
 * Created by Артем on 25.05.2016.
 */
public class MergeSort {
    private static int n = 10;

    public static void main(String[] args) {

        int[] mass = { 1, 3, 4, 9, 2, 6, 5, 8, 7, 0 };
        mass = sortMerge(mass);
        print(mass, 0);
    }

    public static int[] sortMerge(int[] mas) {
        if (mas.length < 2)
            return mas;
        int middle = mas.length / 2;
        int[] leftHalf = new int[middle];
        int[] rightHalf = new int[mas.length - middle];
        for (int i = 0; i < leftHalf.length; i++) {
            leftHalf[i] = mas[i];
        }
        for (int i = 0; i < rightHalf.length; i++) {
            rightHalf[i] = mas[i + middle];
        }
        mas = merge(sortMerge(leftHalf), sortMerge(rightHalf));
        return mas;

    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int i1 = 0, i2 = 0;
        int[] result = new int[arr1.length + arr2.length];
        for (int i = 0; i < result.length; i++) {
            if (i1 < arr1.length && i2 < arr2.length) {
                if (arr1[i1] > arr2[i2]) {
                    result[i] = arr2[i2];
                    i2++;
                } else {
                    result[i] = arr1[i1];
                    i1++;
                }
            } else if (i1 < arr1.length) {
                result[i] = arr1[i1];
                i1++;
            } else if (i2 < arr2.length) {
                result[i] = arr2[i2];
                i2++;
            }
        }
        return result;
    }

    private static void print(int[] mas, int i) {
        if (i < mas.length) {
            System.out.println(mas[i]);
            i++;
            print(mas, i);
        }
    }
}
