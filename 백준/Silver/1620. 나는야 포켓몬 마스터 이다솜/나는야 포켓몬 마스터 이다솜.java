import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] firstInputSplits = br.readLine().split(" ");
    int wordCount = Integer.parseInt(firstInputSplits[0]);
    int outputCount = Integer.parseInt(firstInputSplits[1]);

    HashMap<String, Integer> wordMap = new HashMap<>();
    HashMap<Integer, String> wordIdxMap = new HashMap<>();

    for (int wordIdx = 0; wordIdx < wordCount; wordIdx++) {

      String word = br.readLine();

      wordMap.put(word, wordIdx + 1);
      wordIdxMap.put(wordIdx + 1, word);
    }

    for (int outputIdx = 0; outputIdx < outputCount; outputIdx++) {

      String input = br.readLine();
      if (isNumeric(input)) {
        int targetIdx = Integer.parseInt(input);
        String target = wordIdxMap.get(targetIdx);

        System.out.println(target);

      } else {
        Integer targetIdx = wordMap.get(input);

        System.out.println(targetIdx);
      }
    }
  }

  private static boolean isNumeric(String str) {
    if (str == null || str.isEmpty()) return false;
    try {
      Integer.parseInt(str);
      return true;

    } catch (NumberFormatException e) {
      return false;
    }
  }
}
