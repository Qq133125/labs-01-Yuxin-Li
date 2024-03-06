//_01_MyStackTest class

package lab03.stacksqueues;

import utils.MyStack;

public class _01_MyStackTest {
    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();
        
        System.out.println("Before pushing elements:");
        System.out.println(stack);
        
        stack.push("Red");
        stack.push("Orange");
        stack.push("Yellow");
        stack.push("Green");
        stack.push("Blue");
        stack.push("Indigo");
        stack.push("Violet");
        
        System.out.println("After pushing elements:");
        System.out.println(stack);
    }
}
