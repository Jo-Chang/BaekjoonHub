import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] input = sc.next().toCharArray();
        int diff = 'a' - 'A';

        for (int i = 0; i < input.length; i++) {
            if ('a' <= input[i] && input[i] <= 'z') input[i] -= diff;
            else if ('A' <= input[i] && input[i] <= 'Z') input[i] += diff;
        }

        System.out.println(input);
    }

}