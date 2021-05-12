package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author Sunidhi Thakur
 *
 */
public class BasicOperations {

    public static void main(String[] args) throws IOException {
        BasicOperations B = new BasicOperations();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter numbers in array separated by space");
        String[] elements = br.readLine().trim().split("\\s+");
        int A[] = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            A[i] = Integer.parseInt(elements[i]);
        }
        int num, pos, ch;
        String cont = "Y";
        while (cont.equalsIgnoreCase("Y")) {
            System.out.println("1 -> Insert element at specific position");
            System.out.println("2 -> Delete a specific element");
            System.out.println("3 -> Delete an element present at a specific position");
            System.out.println("4 -> Delete from end");
            System.out.println("5 -> Sort the array");
            System.out.println("6 -> Search an element");

            System.out.println("\nEnter Choice");
            ch = Integer.parseInt(br.readLine());
            System.out.println();

            switch (ch) {
                case 1:
                    System.out.println("Enter the number to be inserted");
                    num = Integer.parseInt(br.readLine());
                    System.out.println("Enter the position");
                    pos = Integer.parseInt(br.readLine());
                    if (pos < 1 || pos > elements.length) {
                        System.out.println("Position should be between 1-" + elements.length);
                    }
                    B.insertAtPosition(A, num, pos);
                    B.print(A, A.length);
                    break;
                case 2:
                    System.out.println("Enter the number to be deleted");
                    num = Integer.parseInt(br.readLine());
                    B.deleteElement(A, num);
                    B.print(A, A.length - 1);
                    break;
                case 3:
                    System.out.println("Enter the position");
                    pos = Integer.parseInt(br.readLine());
                    if (pos < 1 || pos > elements.length) {
                        System.out.println("Position should be between 1-" + elements.length);
                    }
                    B.deleteAtPosition(A, pos);
                    B.print(A, A.length - 1);
                    break;
                case 4:
                    B.deleteAtPosition(A, A.length);
                    break;
                case 5:
                    int[] temp = A.clone();
                    Arrays.sort(temp);
                    B.print(temp, temp.length);
                    break;
                case 6:
                    System.out.println("Enter the element to search");
                    num = Integer.parseInt(br.readLine());
                    B.search(A, num);
                    break;
                default:
                    System.out.println("Wrong choice");
            }
            System.out.println("\nPress Y to continue. \nPress any key to terminate");
            cont = br.readLine();
        }
    }

    private void insertAtPosition(int[] A, int num, int pos) {
        for (int i = A.length - 1; i >= pos; i--) {
            A[i] = A[i - 1];
        }
        A[pos - 1] = num;
    }

    private void print(int[] A, int N) {
        System.out.print("The array elements are: [");
        for (int i = 0; i < N; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.print("]\n");
    }

    private void deleteElement(int[] A, int num) {
        int flag = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == num) {
                flag = 1;
                while (i < A.length - 1) {
                    A[i] = A[++i];
                }
                System.out.println(num + " deleted");
            }
        }
        if (flag == 0) {
            System.out.println("Number is not present in Array");
        }
    }

    private void deleteAtPosition(int[] A, int pos) {
        int num = A[pos - 1];
        for (int i = pos - 1; i < A.length - 1; i++) {
            A[i] = A[i + 1];
        }
        System.out.println(num + " at position " + pos + " deleted");
    }

    private void search(int[] A, int num) {
        for (int i = 1; i <= A.length; i++) {
            if (A[i - 1] == num) {
                System.out.println(num + " found at position " + i);
                return;
            }
        }
        System.out.println("Element is not present in array");
    }
}

/**
 * Output:
 * 
 * Enter numbers in array separated by space
 * 
 * 455 35 357 951 2684 2486
 * 
 * 1 -> Insert element at specific position
 * 
 * 2 -> Delete a specific element
 * 
 * 3 -> Delete an element present at a specific position
 * 
 * 4 -> Delete from end
 * 
 * 5 -> Sort the array
 * 
 * 6 -> Search an element
 * 
 * Enter Choice
 * 
 * 5
 * 
 * The array elements are: [35 357 455 951 2486 2684 ]
 * 
 * Press Y to continue. 
 * 
 * Press any key to terminate
 * 
 * y
 * 
 * 1 -> Insert element at specific position
 * 
 * 2 -> Delete a specific element
 * 
 * 3 -> Delete an element present at a specific position
 * 
 * 4 -> Delete from end
 * 
 * 5 -> Sort the array
 * 
 * 6 -> Search an element
 * 
 * Enter Choice
 * 
 * 2
 * 
 * Enter the number to be deleted
 * 
 * 2684
 * 
 * 2684 deleted
 * 
 * The array elements are: [455 35 357 951 2486 ]
 * 
 * Press Y to continue. 
 * 
 * Press any key to terminate
 * 
 * n
 */