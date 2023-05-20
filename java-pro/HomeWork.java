import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeWork {

    public static void main(String[] args) {
        int[] array = {1, -2, 3, 4, 3, -2, 1};
        System.out.println(sum(array));
        System.out.println(max(array));
        System.out.println(enumNum(array));
        System.out.println(symmetric(array));
        System.out.println(product(array));
        System.out.println(repeated(array));
        System.out.println(Arrays.toString(sort(array)));
        System.out.println(palindrome(array));
        System.out.println(rmNeg(array));
        System.out.println(Arrays.toString(minMaxChange(array)));
        System.out.println(moreThenMid(array));
        System.out.println(checkSort(array));
        System.out.println(secondBiggest(array));
        System.out.println(Arrays.toString(revers(array)));
        System.out.println(findSmallestSum(array));
    }

    public static int sum(int[] list) {
        int sum = 0;
        for (int j : list) {
            sum += j;
        }
        return sum;

    }


    public static int max(int[] list) {
        int max = 0;
        for (int j : list) {
            if (max < j) {
                max = j;
            }
        }
        return max;
    }


    public static int enumNum(int[] list) {
        int count = 0;
        for (int j : list) {
            if (j % 2 == 0) {
                count++;
            }
        }
        return count;
    }


    public static boolean symmetric(int[] list) {
        int counter;
        int centerL;
        int centerR;
        if (list.length % 2 == 0) {
            centerL = list.length / 2 - 1;
            centerR = list.length / 2;
            counter = list.length / 2;

        } else {
            centerL = list.length / 2;
            centerR = list.length / 2;
            counter = list.length / 2 + 1;
        }
        for (int i = 0; i < counter; i++) {
            if (list[centerL - i] != list[centerR + i]) {
                return false;
            }
        }
        return true;
    }


    public static int product(int[] list) {
        int prod = 1;
        for (int j : list) {
            prod *= j;
        }
        return prod;
    }

    public static boolean repeated(int[] list) {
        List<Integer> DRList = new ArrayList<>();
        for (int k : list) {
            int count = 0;
            for (int i : list) {
                if (k == i && !DRList.contains(k)) {
                    count++;
                    if (count > 1) {
                        return true;
                    }
                }
            }
            if (count != 0) {
                DRList.add(k);
            }
        }
        return false;


    }

    public static int[] sort(int[] list) {
        int[] lis = list.clone();
        for (int i = 0; i < lis.length - 1; i++) {
            for (int j = i + 1; j < lis.length; j++) {
                if (lis[i] > lis[j]) {
                    int c = lis[i];
                    lis[i] = lis[j];
                    lis[j] = c;
                }
            }
        }
        return lis;
    }

    public static boolean palindrome(int[] list) {
        int[] list2 = new int[list.length];

        for (int i = 0; i < list.length; i++) {
            list2[list.length - 1 - i] = list[i];
        }

        int n = 0;
        while (n < list2.length) {
            if (list[n] != list2[list2.length - 1 - n]) {
                return false;
            }
            n++;
        }
        return true;

    }


    public static ArrayList<Integer> rmNeg(int[] list) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int j : list) {
            if (j >= 0) {
                arr.add(j);
            }
        }
        return arr;
    }


    public static int[] minMaxChange(int[] list) {
        int[] lis = list.clone();

        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 0; i < lis.length; i++) {
            if (lis[maxIndex] < lis[i]) {
                maxIndex = i;
            }
            if (lis[minIndex] > lis[i]) {
                minIndex = i;
            }
        }

        int ch = lis[maxIndex];
        lis[maxIndex] = lis[minIndex];
        lis[minIndex] = ch;

        return lis;
    }


    public static int moreThenMid(int[] list) {
        int mid = sum(list) / list.length;
        ArrayList<Integer> MidList = new ArrayList<>();

        for (int i : list) {
            if (i > mid) {
                MidList.add(i);
            }
        }
        return MidList.size();
    }

    public static boolean checkSort(int[] lis) {
        for (int i = 0; i < lis.length - 1; i++) {
            if (lis[i] <= lis[i + 1]) {
                return false;
            }
        }
        return true;
    }


    public static int secondBiggest(int[] list) {

        int[] list2 = sort(list);
        int max = max(list2);
        for (int i : list2) {
            if (max > i) {
                return i;
            }
        }
        return 0;
    }


    public static int[] revers(int[] list) {
        int[] list2 = new int[list.length];

        for (int i = 0; i < list.length; i++) {
            list2[list.length - 1 - i] = list[i];
        }
        return list2;
    }


    public static int findSmallestSum(int[] list) {
        int smallestSum = 0;

        for (int i = 0; i < list.length - 1; i++) {
            int sum = list[i] + list[i + 1];
            if (smallestSum > sum) {
                smallestSum = sum;
            }
        }
        return smallestSum;
    }
}