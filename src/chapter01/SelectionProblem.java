package chapter01;

import java.util.Arrays;
import java.util.Random;

/**
 * @author: slm
 */
public class SelectionProblem {

    public static void main(String[] args) {
        //int[] arr = initData();
        ////System.out.println("未排序数组" + Arrays.toString(arr));
        //Instant start = Instant.now();
        ////bubbleSort(arr);
        //sort(arr);
        //Instant end = Instant.now();
        //System.out.println("总耗时: " + Duration.between(start, end).getSeconds() + "秒");

    }

    public static int[] initData(int length) {
        System.out.println("数据生成中...");
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new Random().nextInt(length);
        }
        System.out.println("数据生成完成!");
        return arr;
    }

    public static int[] initData() {
        return initData(50 * 1000);
    }

    public static void bubbleSort(int[] arr) {
        System.out.println("数据排序中...");
        for (int i = 0; i < arr.length; i++) {
            // 标志是否进行交换
            boolean flag = true;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        System.out.println("排序完成!");
        System.out.println(Arrays.toString(arr));
    }


    public static void sort(int[] arr) {
        int length = 50;
        int[] maxArr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            if (i < length) {
                maxArr[i] = arr[i];
            }

            for (int k = 0; k < length; k++) {
                if (arr[i] > maxArr[k]) {
                    maxArr[k] = arr[i];
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(maxArr));
    }

}
