//_02_MyQueueTest class

package lab03.stacksqueues;

import utils.MyQueue;
import utils.MyStack;

import java.util.EmptyStackException;

public class _02_MyQueueTest {

    public static void main(String[] args) {
        // Test changing a stack to a queue
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        
        MyQueue<Integer> queueFromStack = changeStackToQueue(stack);
        System.out.println("After changing stack to queue: " + queueFromStack);
        
        // Test changing a queue to a stack
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        
        MyStack<Integer> stackFromQueue = changeQueueToStack(queue);
        System.out.println("After changing queue to stack: " + stackFromQueue);
        
        // Test removeMin method
        MyStack<Integer> testStack = new MyStack<>();
        testStack.push(24);
        testStack.push(15);
        testStack.push(38);
        testStack.push(4);
        testStack.push(11);
        testStack.push(6);
        testStack.push(18);
        testStack.push(12);
        
        System.out.println("Before removeMin: " + testStack);
        int min = removeMin(testStack);
        System.out.println("Removed min value: " + min);
        System.out.println("After removeMin: " + testStack);
    }

    public static MyQueue<Integer> changeStackToQueue(MyStack<Integer> stack) {
        MyQueue<Integer> queue = new MyQueue<>();
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        return queue;
    }

    public static MyStack<Integer> changeQueueToStack(MyQueue<Integer> queue) {
        MyStack<Integer> stack = new MyStack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        return stack;
    }

    public static int removeMin(MyStack<Integer> stack) {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        
        int min = Integer.MAX_VALUE;
        MyStack<Integer> tempStack = new MyStack<>();
        
        while (!stack.isEmpty()) {
            int value = stack.pop();
            if (value < min) {
                min = value;
            }
            tempStack.push(value);
        }
        
        while (!tempStack.isEmpty()) {
            int value = tempStack.pop();
            if (value != min) {
                stack.push(value);
            }
        }
        
        return min;
    }
}
