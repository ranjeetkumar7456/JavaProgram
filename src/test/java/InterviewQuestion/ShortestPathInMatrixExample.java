package InterviewQuestion;

import java.util.*;

public class ShortestPathInMatrixExample {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1, 1, 1},
                {0, 0, 1, 0, 1},
                {1, 1, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1}
        };

        int[] startPoint = {0, 0};
        int[] endPoint = {4, 4};

        List<int[]> shortestPath = findShortestPath(matrix, startPoint, endPoint);

        if (shortestPath != null) {
            System.out.println("Shortest Path:");
            for (int[] point : shortestPath) {
                System.out.println("(" + point[0] + ", " + point[1] + ")");
            }
        } else {
            System.out.println("No path found.");
        }
    }

    public static List<int[]> findShortestPath(int[][] matrix, int[] startPoint, int[] endPoint) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (matrix[startPoint[0]][startPoint[1]] == 0 || matrix[endPoint[0]][endPoint[1]] == 0) {
            return null; // Either start or end point is blocked
        }

        boolean[][] visited = new boolean[rows][cols];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up, Down, Left, Right

        Queue<int[]> queue = new LinkedList<>();
        Map<int[], int[]> parentMap = new HashMap<>();

        queue.offer(startPoint);
        visited[startPoint[0]][startPoint[1]] = true;

        while (!queue.isEmpty()) {
            int[] currentPoint = queue.poll();

            if (currentPoint[0] == endPoint[0] && currentPoint[1] == endPoint[1]) {
                break; // Reached the end point
            }

            for (int[] direction : directions) {
                int newRow = currentPoint[0] + direction[0];
                int newCol = currentPoint[1] + direction[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                        && matrix[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                    queue.offer(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                    parentMap.put(new int[]{newRow, newCol}, currentPoint);
                }
            }
        }

        if (!visited[endPoint[0]][endPoint[1]]) {
            return null; // No path found to the end point
        }

        List<int[]> shortestPath = new ArrayList<>();
        int[] currentPoint = endPoint;

        while (currentPoint != null) {
            shortestPath.add(currentPoint);
            currentPoint = parentMap.get(currentPoint);
        }

        Collections.reverse(shortestPath);
        return shortestPath;
    }
}
