import java.util.Arrays;

public class Level5 {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int n = sc.nextInt();
        char[][] ch = new char[n][2 * n - 1];
        for (int i=0; i< n; i++) {
            Arrays.fill(ch[i], ' ');
        }

        star(ch, n, 0, (2 * n - 1) / 2);

        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < ch[i].length; j++)
                System.out.print(ch[i][j]);
            System.out.println();
        }
    }

    static void star(char[][] ch, int size, int x, int y) {
        if (size == 3) {
            ch[x][y] = '*';
            ch[x + 1][y - 1] = '*';
            ch[x + 1][y + 1] = '*';
            ch[x + 2][y - 2] = '*';
            ch[x + 2][y - 1] = '*';
            ch[x + 2][y] = '*';
            ch[x + 2][y + 1] = '*';
            ch[x + 2][y + 2] = '*';
        } else {
            star(ch, size / 2, x, y);
            star(ch, size / 2, x + (size / 2), y + (size / 2));
            star(ch, size / 2, x + (size / 2), y - (size / 2));
        }
    }
}
