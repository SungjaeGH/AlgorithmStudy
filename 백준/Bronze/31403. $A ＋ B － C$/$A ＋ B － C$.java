import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int first = Integer.parseInt(br.readLine());
        int second = Integer.parseInt(br.readLine());
        int third = Integer.parseInt(br.readLine());

        System.out.println(first + second - third);
        System.out.println(Integer.parseInt(first + "" + second) - third);
    }
}