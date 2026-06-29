import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        MyLinkedList ml = new MyLinkedList();
        
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
            case "push_front":
                ml.push_front(Integer.parseInt(input[1]));
                break;
            case "push_back":
                ml.push_back(Integer.parseInt(input[1]));
                break;
            case "pop_front":
                System.out.println(ml.pop_front());
                break;
            case "pop_back":
                System.out.println(ml.pop_back());
                break;
            case "size":
                System.out.println(ml.size());
                break;
            case "empty":
                System.out.println(ml.empty());
                break;
            case "front":
                System.out.println(ml.front());
                break;
            case "back":
                System.out.println(ml.back());
                break;
            }
        }

    }

}

class MyLinkedList {
    private Node head = new Node(-1);
    private Node tail = new Node(-1);
    private int size = 0;

    public MyLinkedList() {
        head.next = tail;
        tail.prev = head;
    }

    private static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }

        Node(int data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    public void push_front(int input) {
        Node newNode = new Node(input, head, head.next);

        head.next.prev = newNode;
        head.next = newNode;
        size++;
    }

    public void push_back(int input) {
        Node newNode = new Node(input, tail.prev, tail);

        tail.prev.next = newNode;
        tail.prev = newNode;
        size++;
    }

    public int pop_front() {
        int result = 0;

        if (size != 0) {
            result = head.next.data;
            head.next.next.prev = head;
            head.next = head.next.next;
            size--;
        }

        return result;
    }

    public int pop_back() {
        int result = 0;

        if (size != 0) {
            result = tail.prev.data;
            tail.prev.prev.next = tail;
            tail.prev = tail.prev.prev;
            size--;
        }

        return result;
    }

    public int size() {
        return size;
    }

    public int empty() {
        if (size == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public int front() {
        int result = 0;

        if (size != 0) {
            result = head.next.data;
        }

        return result;
    }

    public int back() {
        int result = 0;

        if (size != 0) {
            result = tail.prev.data;
        }

        return result;
    }

}
