package array;

import java.util.Arrays;

/**
 * @author: slm
 */
public class OrderArr {

    private long[] arr;

    private int index;

    private int max;

    public OrderArr(int size) {
        arr = new long[size];
        max = size;
    }

    private int size() {

        return index;
    }

    public int find(long value) {
        return findByDich(0, max, value);
    }

    static int j = 0;

    private int findByDich(int min, int max, long value) {
        System.out.printf("第 %d 次查找\n", ++j);
        int mid = (min + max) / 2;

        if (arr[mid] == value) {
            return mid;
        }

        if (arr[mid] < value) {
            return findByDich(mid, max, value);
        } else {
            return findByDich(min, mid, value);
        }
    }

    public void insert(long value) {
        int i;

        for (i = 0; i < index; i++) {
            if (arr[i] > value) {
                break;
            }
        }

        for (int k = index; k > i; k--) {
            arr[k] = arr[k - 1];
        }
        arr[i] = value;
        index++;
    }

    public void delete(long value) {
        int i;
        for (i = 0; i < index; i++) {
            if (arr[i] == value) {
                break;
            }
        }

        for (int k = i; k < index - 1; k++) {
            arr[k] = arr[k + 1];
        }
        arr[index - 1] = 0;
        index--;
    }

    public void display() {
        System.out.println(Arrays.toString(arr));
    }


}

class OrderArrApp {
    public static void main(String[] args) {
        OrderArr arr = new OrderArr(10);
        arr.insert(10);
        arr.insert(6);
        arr.insert(8);
        arr.insert(9);
        arr.insert(7);
        arr.insert(3);
        arr.insert(5);
        arr.insert(4);
        arr.insert(1);
        arr.insert(2);
        arr.display();
        arr.delete(5);
        arr.display();
        System.out.println("arr.find(6) = " + arr.find(9));
        arr.delete(7);
        arr.display();
    }
}
