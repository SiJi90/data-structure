package array;


import java.util.Arrays;

/**
 * @author: slm
 */
public class HighArr<E> {

    private Object[] arr;

    private int index;

    private int max;
    private static final int MIN = 0;

    public HighArr(int max) {
        assert max >= MIN : "max >= 0";
        arr = new Object[max];
        index = 0;
        this.max = max;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) arr[index];
    }

    public void inset(E value) {
        assert index < max : "数组下表越界异常: " + max;
        arr[index] = value;
        index++;
    }

    public boolean find(E value) {
        for (int i = 0; i < index; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    public boolean delete(E value) {
        for (int i = 0; i < index; i++) {
            if (arr[i] == value) {
                for (int j = i; j < index - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[index - 1] = 0;
                index--;
                return true;
            }
        }
        return false;
    }

    /**
     * 冒泡排序: 两两比较， 每完成一轮比较则会得到一个最大值
     */
    public void bubbleSort() {
        for (int i = 0; i < index; i++) {
            for (int j = 0; j < index - i - 1; j++) {
                if (!(arr[i] instanceof Integer)) {
                    return;
                }
                if ((Integer) arr[j] > (Integer) arr[j + 1]) {
                    Integer temp = (Integer) arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序： 每遍历一次会得到一个最小值，依次排列
     */
    public void selectSort() {
        for (int i = 0; i < index; i++) {
            Integer min = (Integer) arr[i];
            for (int j = i + 1; j < index; j++) {
                if (!(arr[0] instanceof Integer)) {
                    return;
                }
                if (min > (Integer) arr[j]) {
                    min = (Integer) arr[j];
                    arr[j] = arr[i];
                    arr[i] = min;
                }
            }
        }
    }

    /**
     * 插入排序： 从第二个元素开始， 前面的都视为有序， 遍历后面的值挨个比较插入对应位置
     */
    public void insertSort() {
        for (int i = 1; i < index; i++) {
            int temp = (Integer) arr[i];
            int j = i - 1;
            //for (j = i - 1; j >= 0; j--) {
            //    if ((Integer) arr[j] > temp) {
            //        arr[j + 1] = arr[j];
            //    } else {
            //        arr[j+1] = temp;
            //        break;
            //    }
            //}
            while (j > 0 && (Integer) arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }


    public void display() {
        System.out.println(Arrays.toString(arr));
    }
}

class HighArrApp {
    public static void main(String[] args) {
        HighArr<Integer> arr = new HighArr<>(18);
        arr.display();
        arr.inset(1);
        arr.inset(6);
        arr.inset(2);
        arr.inset(4);
        arr.inset(3);
        arr.inset(5);
        arr.inset(8);
        arr.inset(7);
        arr.inset(27);
        arr.inset(17);
        arr.inset(37);
        arr.inset(7);
        arr.inset(37);
        arr.inset(67);
        System.out.println("arr.delete(5) = " + arr.delete(5));
        arr.display();
        arr.inset(9);
        System.out.println("arr.find(3) = " + arr.find(3));
        System.out.println("arr.find(5) = " + arr.find(9));
        arr.display();
        HighArr<String> stringHighArr = new HighArr<>(9);
        stringHighArr.inset("hello");
        stringHighArr.inset("world");
        stringHighArr.display();
        //arr.bubbleSort();
        //arr.selectSort();
        System.out.println("排序前。。。");
        arr.display();
        System.out.println("排序后。。。");
        arr.insertSort();
        arr.display();

    }
}
