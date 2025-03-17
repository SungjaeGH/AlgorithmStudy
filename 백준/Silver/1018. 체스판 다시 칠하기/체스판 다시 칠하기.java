import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputLine = br.readLine();
        String[] inputs = inputLine.split(" ");

        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        String[][] map = new String[N][M];

        for (int row = 0; row < N; row++) {

            inputLine = br.readLine();
            inputs = inputLine.split("");

            for (int col = 0; col < M; col++) {
                map[row][col] = inputs[col];
            }
        }

        int minCount = Integer.MAX_VALUE;

        for (int row = 0; row <= N - 8; row++) {

            for (int col = 0; col <= M - 8; col++) {

                int fixCountByColorBlack = findSquareCount(map, row, col, row + 8, col + 8, "B");
                int fixCountByColorWhite = findSquareCount(map, row, col, row + 8, col + 8, "W");

                minCount = Math.min(minCount, fixCountByColorBlack);
                minCount = Math.min(minCount, fixCountByColorWhite);
            }
        }

        System.out.println(minCount);
    }

    private static int findSquareCount(
            String[][] map,
            int startRow,
            int startCol,
            int endRow,
            int endCol,
            String startColor
            ) {

        int count = 0;

        for (int row = startRow; row < endRow; row++) {

            String color = startColor;

            if (row % 2 != 0) {
                color = (startColor.equals("B") ? "W" : "B");
            }

            for (int col = startCol; col < endCol; col++) {

                if (col % 2 == 0) {
                    if (!color.equals(map[row][col])) {
                        count++;
                    }

                } else {
                    if (color.equals(map[row][col])) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}