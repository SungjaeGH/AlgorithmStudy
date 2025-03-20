import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcaseCount = Integer.parseInt(br.readLine());
        List<Integer> results = new LinkedList<>();

        for (int testcaseIdx = 0; testcaseIdx < testcaseCount; testcaseIdx++) {

            String[] mapInfo = br.readLine().split(" ");
            int maxRow = Integer.parseInt(mapInfo[0]);
            int maxCol = Integer.parseInt(mapInfo[1]);
            int maxItem = Integer.parseInt(mapInfo[2]);

            int[][] map = setMap(maxRow, maxCol, maxItem, br);
            boolean[][] visited = new boolean[maxRow][maxCol];
            int count = 0;

            for (int row = 0; row < maxRow; row++) {
                for (int col = 0; col < maxCol; col++) {

                    if (visited[row][col]) {
                        continue;
                    }

                    visited[row][col] = true;

                    if (map[row][col] != 1) {
                        continue;
                    }

                    checkEarthwormsSection(row, col, map, visited);
                    count++;
                }
            }

            results.add(count);
        }

        results.forEach(System.out::println);
    }

    private static int[][] setMap(
            int maxRow,
            int maxCol,
            int maxItem,
            BufferedReader br
    ) throws IOException {

        int[][] map = new int[maxRow][maxCol];

        for (int idx = 0; idx < maxItem; idx++) {

            String[] inputs = br.readLine().split(" ");
            int row = Integer.parseInt(inputs[0]);
            int col = Integer.parseInt(inputs[1]);

            map[row][col] = 1;
        }

        return map;
    }

    private static void checkEarthwormsSection(
            int row,
            int col,
            int[][] map,
            boolean[][] visited
    ) {

        int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int maxRow = map.length;
        int maxCol = map[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();

            for (int idx = 0; idx < 4; idx++) {

                int nextRow = curr[0] + move[idx][0];
                int nextCol = curr[1] + move[idx][1];

                if (nextRow < 0 || nextRow >= maxRow || nextCol < 0 || nextCol >= maxCol) {
                    continue;
                }

                if (visited[nextRow][nextCol]) {
                    continue;
                }

                visited[nextRow][nextCol] = true;

                if (map[nextRow][nextCol] != 1) {
                    continue;
                }

                queue.offer(new int[]{nextRow, nextCol});
            }
        }
    }
}