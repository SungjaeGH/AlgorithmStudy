import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int maxSumResult = 0;    // 수들의 합의 최대값
    static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};   // 상하좌우
    static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputLine = br.readLine();
        String[] inputs = inputLine.split(" ");

        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        map = new int[N][M];

        for (int row = 0; row < N; row++) {

            inputLine = br.readLine();
            inputs = inputLine.split(" ");

            for (int col = 0; col < M; col++) {

                int target = Integer.parseInt(inputs[col]);
                map[row][col] = target;
            }
        }

        boolean[][] visited = new boolean[N][M];

        // ㅗ 모양을 제외한 나머지 도형에 대한 최대값 구하기
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {

                visited[row][col] = true;
                findMaxTetromino(row, col, 1, map[row][col], visited);
                visited[row][col] = false;

                // ㅗ 모양에 대한 최대값 구하기
                findTShape(row, col);
            }
        }

        System.out.println(maxSumResult);
    }

    private static void findMaxTetromino(
            int row,
            int col,
            int count,
            int sum,
            boolean[][] visited
    ) {

        if (count == 4) {
            maxSumResult = Math.max(maxSumResult, sum);
            return;
        }

        for (int idx = 0; idx < 4; idx++) {

            int nextRow = row + move[idx][0];
            int nextCol = col + move[idx][1];

            if (nextRow < 0 || nextRow >= map.length || nextCol < 0 || nextCol >= map[0].length) {
                continue;
            }

            if (visited[nextRow][nextCol]) {
                continue;
            }

            visited[nextRow][nextCol] = true;
            findMaxTetromino(
                    nextRow,
                    nextCol,
                    count + 1,
                    sum + map[nextRow][nextCol],
                    visited
            );
            visited[nextRow][nextCol] = false;
        }
    }

    private static void findTShape(int row, int col) {

        int[][][] tShapes = {
                {{0, -1}, {0, 1}, {-1, 0}}, // ㅗ
                {{0, -1}, {0, 1}, {1, 0}},  // ㅜ
                {{-1, 0}, {1, 0}, {0, -1}}, // ㅓ
                {{-1, 0}, {1, 0}, {0, 1}}   // ㅏ
        };

        for (int[][] tShapeRow : tShapes) {

            int sum = map[row][col];
            boolean isValid = true;

            for (int[] tShapeCol : tShapeRow)  {

                int nextRow = row + tShapeCol[0];
                int nextCol = col + tShapeCol[1];

                if (nextRow < 0 || nextRow >= map.length || nextCol < 0 || nextCol >= map[0].length) {
                    isValid = false;
                    break;
                }

                sum += map[nextRow][nextCol];
            }

            if (isValid) {
                maxSumResult = Math.max(maxSumResult, sum);
            }
        }
    }
}