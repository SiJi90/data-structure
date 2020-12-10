package array;

import java.util.Arrays;

/**
 * @author: slm
 */
public class LongArr {

    private long[] arr;

    public LongArr(int size) {
        assert size >= 0 : "size must >= 0";
        arr = new long[size];
    }


    public void setItem(int index, long value) {
        assert index >= 0 : "index must >= 0";
        arr[index] = value;
    }

    public long getItem(int index) {
        assert index >= 0 : "index must >= 0";
        return arr[index];
    }

    public boolean isEmpty() {
        return arr.length <= 0;
    }

    public String showArr() {
        return Arrays.toString(arr);
    }

    public int length() {
        return arr.length;
    }
}

class App {
    public static void main(String[] args) {
        LongArr arr = new LongArr(8);
        arr.setItem(0, 10L);
        System.out.println("arr.length() = " + arr.length());
        System.out.println("arr.isEmpty() = " + arr.isEmpty());
        System.out.println("arr.getItem(0) = " + arr.getItem(-1));
        System.out.println("arr.showArr() = " + arr.showArr());
    }
}