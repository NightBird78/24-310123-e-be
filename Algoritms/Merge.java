public class Merge {

    public static void main(String[] args) {
        int[] arr1 = {100, 112, 256, 349, 770};
        int[] arr2 = {72, 86, 113, 119, 265, 445, 892};

//        System.out.println(Arrays.toString(merge(arr1, arr2)));

        System.out.println(mergeEndGet(arr1, arr2, 7));

    }



    public static int[] merge(int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int n = 0;

        while (arr1.length > i && arr2.length > j) {
            if (arr1[i] <= arr2[j]) {
                arr[n++] = arr1[i++];
            } else {
                arr[n++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            arr[n++] = arr1[i++];
        }
        while (j < arr2.length) {
            arr[n++] = arr2[j++];
        }

        return arr;
    }


    public static int mergeEndGet(int[] arr1,  int[] arr2, int k){
        return merge(arr1, arr2)[k-1];


    }


}
