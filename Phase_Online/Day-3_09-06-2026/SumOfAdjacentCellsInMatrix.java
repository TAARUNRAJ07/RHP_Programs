import java.util.Scanner;

public class SumOfAdjacentCellsInMatrix {
    public static void main(String[] args) {
        int[][] dif = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, 1}, {0, -1},
            {1, -1}, {1, 0}, {1, 1}
        };

        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] a = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int sum = 0;
        int row = sc.nextInt();
        int col = sc.nextInt();

        for (int i = 0; i < 8; i++) {
            int x = row - 1 + dif[i][0];
            int y = col - 1 + dif[i][1];

            if (x >= 0 && x < r && y >= 0 && y < c) {
                System.out.print(a[x][y] + " ");
                sum += a[x][y];
            }
        }

        System.out.println(sum);

        sc.close();
    }
}