import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String N = sc.nextLine();

        ArrayList<String> list = new ArrayList<>();
        char[] nChars = N.toCharArray();

        for (char nChar : nChars) {
            list.add(String.valueOf(nChar));
        }

        list.sort(Collections.reverseOrder());
        
        System.out.println(String.join("", list));
    }
}