import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        String input = new BufferedReader(new InputStreamReader(System.in)).readLine();

        String[] elements = input.split("[+=]");

        System.out.println(
                Integer.parseInt(elements[0].trim()) + Integer.parseInt(elements[1].trim())
                        == Integer.parseInt(elements[2].trim()) ? "YES" : "NO"
        );
    }

}