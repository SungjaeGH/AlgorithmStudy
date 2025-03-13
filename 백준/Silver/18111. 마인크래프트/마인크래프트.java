import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static class Result {
        public int time;
        public int height;

        public Result(int time, int height) {
            this.time = time;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputLine = br.readLine();
        String[] inputs = inputLine.split(" ");

        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        int B = Integer.parseInt(inputs[2]);

        int[][] map = new int[N][M];
        int min = 256, max = 0;

        for (int row = 0; row < N; row++) {

            inputLine = br.readLine();
            inputs = inputLine.split(" ");

            for (int col = 0; col < M; col++) {

                int target = Integer.parseInt(inputs[col]);

                map[row][col] = target;
                max = Math.max(max, target);
                min = Math.min(min, target);
            }
        }

        Result result = new Result(Integer.MAX_VALUE, 256);

        for (int height = max; height >= min; height--) {
            blockCheck(height, map, B, result);
        }

        System.out.println(result.time + " " + result.height);
    }

    private static void blockCheck(int height, int[][] map, int B, Result result) {

        int time = 0;
        int remainBlock = B;

        for (int row = 0; row < map.length; row++) {

            for (int col = 0; col < map[0].length; col++) {

                if (time > result.time) {
                    return;
                }

                if (map[row][col] > height) {
                    // 땅 파기
                    int sub = map[row][col] - height;
                    time += 2 * sub;
                    remainBlock += sub;

                } else if (map[row][col] < height) {
                    // 땅 놓기
                    int sub = height - map[row][col];
                    time += sub;
                    remainBlock -= sub;
                }
            }
        }

        // 최소 시간 비교하기
        if (remainBlock >= 0 && result.time > time) {
            result.time = time;
            result.height = height;
        }
    }
}