import java.util.Scanner;

/**
 * Created by yhj on 02/07/2017.
 */
public class BoardCover {

    public static void main(String[] args) {
        int [][] board;

        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int [] results = new int[number];

        for (int i=0; i<number; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();

            board = new int[h][w];

            // 각 케이스별 Board 채우기
            for (int j=0; j<h; j++) {
                String words = sc.next();
                for (int k=0; k<words.length(); k++) {
                    if (words.charAt(k) == '#') {
                        board[j][k] = 1;
                    } else {
                        board[j][k] = 0;
                    }
                }
            }

            results[i] = cover(board);
        }

        for (int i=0; i<number; i++) {
            System.out.println(results[i]);
        }
    }

    static int[][][] coverType = {
            {{0, 0}, {1, 0}, {0, 1}},
            {{0, 0}, {0, 1}, {1, 1}},
            {{0, 0}, {1, 0}, {1, 1}},
            {{0, 0}, {1, 0}, {1, -1}},
    };

    // 보드판을 덮는 경우의 수를 리턴
    // board[i][j] = 1 : 이미 덮힌 칸 or 검은 칸
    // board[i][j] = 0 : 아직 덮히지 않은 칸
    private static int cover(int[][] board) {
        int x = -1;
        int y = -1;
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                if (board[i][j] == 0) {
                    y = i;
                    x = j;
                    break;
                }
            }
            if (y != -1) {
                break;
            }
        }

        if (y == -1)    return 1;   // 이미 다 채워진 기저사례

        int ret = 0;
        for (int type=0; type<coverType.length; type++) {
            if (set(board, y, x, type, 1)) {
                ret += cover(board);
            }

            set(board, y, x, type, -1);
        }

        return ret;
    }

    private static boolean set(int[][] board, int y, int x, int type, int delta) {
        boolean ok = true;

        // L 블록 좌표의 유효성 체크
        for (int i=0; i<3; i++) {
            int ny = y + coverType[type][i][0];
            int nx = x + coverType[type][i][1];

            if (ny < 0 || ny >= board.length || nx < 0 || nx >= board[0].length) {
                ok = false;
            } else if ((board[ny][nx] += delta) > 1) {
                ok = false;
            }
        }

        return ok;
    }
}
