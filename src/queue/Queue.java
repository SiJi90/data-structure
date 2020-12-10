package queue;

/**
 * 自定义队列
 *
 * @author: slm
 */
public class Queue {

    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;


    public Queue(int maxSize) {
        this.maxSize = maxSize;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(int num) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queArray[++rear] = num;
        nItems++;
    }

    public long remove() {
        long temp = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return temp;
    }

    public long peek() {
        return queArray[front];
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == maxSize;
    }

    public int size() {
        return nItems;
    }
}

class QueueApp {
    public static void main(String[] args) {
        Queue queue = new Queue(3);
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.remove();
        queue.insert(50);
        queue.insert(50);
        queue.insert(50);
        queue.insert(50);
        queue.insert(50);
        queue.insert(50);

        System.out.println("queue.size() = " + queue.size());

        while (!queue.isEmpty()) {
            System.out.println("queue.remove() = " + queue.remove());
        }
    }
}