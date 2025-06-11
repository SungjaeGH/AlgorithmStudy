import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int inputCount = Integer.parseInt(br.readLine());
    Map<Integer, List<String>> userMap = new TreeMap<>();

    for (int inputIdx = 0; inputIdx < inputCount; inputIdx++) {

      String[] splitInputs = br.readLine().split(" ");
      int age = Integer.parseInt(splitInputs[0]);
      String name = splitInputs[1];

      List<String> names;
      if (userMap.containsKey(age)) {
        names = userMap.get(age);

      } else {
        names = new ArrayList<>();
      }

      names.add(name);
      userMap.put(age, names);
    }

    for (int age :  userMap.keySet()) {

      List<String> names = userMap.get(age);

      for (String name : names) {
        System.out.println(age + " " + name);
      }
    }
  }
}
