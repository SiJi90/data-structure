package stack;

/**
 * 基于数组的 栈
 *
 * @author: slm
 */
public class StackX {
    private int maxSize;
    private long[] stackArray;
    private int top;


    public StackX(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new long[maxSize];
        top = -1;
    }

    public void push(long num) {
        if (full()) {
            System.out.println("can't insert, stack is full!");
            return;
        }
        stackArray[++top] = num;
    }

    public long pop() {
        return stackArray[top--];
    }

    public long peek() {
        if (top < 0) {
            throw new RuntimeException("栈内还没任何元素");
        }
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean full() {
        return top == maxSize - 1;
    }

}

class Reverser {
    private String input;
    private StringBuilder output;

    public Reverser(String in) {
        this.input = in;
    }

    public String reserve() {
        int stackSize = input.length();
        StackX stack = new StackX(stackSize);
        for (int i = 0; i < stackSize; i++) {
            char c = input.charAt(i);
            stack.push(c);
        }

        output = new StringBuilder(stackSize);
        while (!stack.isEmpty()) {
            output.append((char) stack.pop());
        }
        return output.toString();

    }
}

class StackApp {
    public static void main(String[] args) {
        StackX stack = new StackX(2);
        System.out.println("stack.isEmpty() = " + stack.isEmpty());
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("stack.peek() = " + stack.peek());
        while (!stack.isEmpty()) {
            System.out.println("stack = " + stack.pop());
        }
        Reverser reverser = new Reverser("hello, world!!!");
        System.out.println("reverser.reserve() = " + reverser.reserve());
    }
}
