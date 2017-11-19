import java.util.EmptyStackException;
import java.util.Scanner;

public class LinkedStack implements Stack<Double>{
    private Node top; //przechowujemy uchwyt do gory stosu

    @Override
    public void push(Double a) {
        Node newNode = new Node(a);

        //if (top != null) {
            newNode.under = top; //zachowujemy uchwyt do poprzedniego elementu;
       // }
            top = newNode; //nowy uchwyt do gory stosu
        }

//      if(top == null){
//          top = newNode;
//      } else {
//          newNode.under = top; //zachowujemy uchwyt do poprzedniego elementu;
//          top = newNode;
//      }


    @Override
    public void push(Double a) {

    }

    @Override
    public double pop() {

        if (top == null) {
            throw new EmptyStackException();
        }

        double value = top.value; // wartosc aktualnej gory stosu, bo zaraz ja zastapimy
        top = top.under; // podmieniamy stos na element drugi w kolejce
        return top.value;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }


    private static class Node {
        private double value;
        private Node under; // uchwyt fo Node'a pod nim w stosie

        private Node(double value) {
            this.value = value;

        }
    }
    @Override
    public String toString() {

        if(top == null){
            return "";
        }

        StringBuilder result = new StringBuilder();

        Node current = top;

        do {
            result.append(current.value + '\n');
//            current = current.under;
        } while((current = current.under) != null);
        return result.toString().toString();

    }
    public void printStack() {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Enter numbers:");
        int n = scanner.nextInt();
        int counter = 0;
        while (n != 0){
            push(n);
            n = scanner.nextInt();
            counter++;
        }
        for (int i = 0; i < counter; i++) {
            System.out.println(pop());
        //}
        }

    }

}
