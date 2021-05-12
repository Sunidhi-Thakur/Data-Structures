package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Sunidhi Thakur
 */
public class BinarySearch {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the elements of array separated by space");
        String[] a = br.readLine().trim().split("\\s+");
        int[] A = new int[a.length];
        int num;
        for (int i = 0; i < a.length; i++) {
            A[i] = Integer.parseInt(a[i]);
        }
        String ch = "Y";
        while (ch.equalsIgnoreCase("Y")) {
            System.out.println("Enter the number to search");
            num = Integer.parseInt(br.readLine());
            int pos = search(A, num, 0, A.length);
            if (pos == -1) {
                System.out.println("Element does not exists");
            } else {
                System.out.println("Number " + num + " found at position " + pos);
            }
            System.out.println("Press N to terminate, Y to search");
            ch = br.readLine();
        }
    }

    private static int search(int[] A, int num, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (A[mid] == num) {
            return mid + 1;
        } else if (A[mid] > num) {
            return search(A, num, low, mid - 1);
        } else {
            return search(A, num, mid + 1, high);
        }
    }
}
/**
 * Output:
 * 
 * Enter the elements of array separated by space
 * 
 * 10 20 30 40 50 60 70
 * 
 * Enter the number to search
 * 
 * 30
 * 
 * Number 30 found at position 3
 * 
 * Press N to terminate, Y to search
 * 
 * y
 * 
 * Enter the number to search
 * 
 * 34
 * 
 * Element does not exists
 * 
 * Press N to terminate, Y to search
 * 
 * n
 */