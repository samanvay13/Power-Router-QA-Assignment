import java.util.*;

public class StackUsingQueue {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public StackUsingQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int value) {
        // Move all elements from queue1 to queue2
        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }

        // Add the new element to queue1
        queue1.add(value);

        // Move all elements back to queue1
        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return queue1.poll();
    }

    public int top() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return queue1.peek();
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public void displayStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }

        System.out.print("Stack: ");
        for (int element : queue1) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Return Top");
            System.out.println("4. Display Stack");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to push: ");
                    int element = scanner.nextInt();
                    stack.push(element);
                    break;
                case 2:
                    try {
                        int poppedElement = stack.pop();
                        System.out.println("Popped Element: " + poppedElement);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        int topElement = stack.top();
                        System.out.println("Top Element: " + topElement);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    stack.displayStack();
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
            System.out.println();
        }
    }
}
