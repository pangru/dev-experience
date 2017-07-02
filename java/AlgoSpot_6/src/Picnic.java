import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Arrays;
import java.util.Scanner;

/*
  @Description
   입력의 첫 줄에는 테스트 케이스의 수 C (C <= 50) 가 주어집니다.
   각 테스트 케이스의 첫 줄에는 학생의 수 n (2 <= n <= 10) 과 친구 쌍의 수 m (0 <= m <= n*(n-1)/2) 이 주어집니다.
   그 다음 줄에 m 개의 정수 쌍으로 서로 친구인 두 학생의 번호가 주어집니다.
   번호는 모두 0 부터 n-1 사이의 정수이고, 같은 쌍은 입력에 두 번 주어지지 않습니다.
   학생들의 수는 짝수입니다.

   각 테스트 케이스마다 한 줄에 모든 학생을 친구끼리만 짝지어줄 수 있는 방법의 수를 출력합니다.

   @Input
   3
   2 1
   0 1
   4 6
   0 1 1 2 2 3 3 0 0 2 1 3
   6 10
   0 1 0 2 1 2 1 3 1 4 2 3 2 4 3 4 3 5 4 5

   @Output
   1
   3
   4

 */
public class Picnic {
    static int [] output;
    static Boolean [] takens;
    static Boolean [][] areFriends;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        output = new int[number];
        for (int i=0; i<number; i++) {
            int students = sc.nextInt();
            int couples = sc.nextInt();
            areFriends = new Boolean[students][students];
            takens = new Boolean[students];

            for (int j=0; j<areFriends.length; j++) {
                Arrays.fill(areFriends[j], Boolean.FALSE);
            }
            Arrays.fill(takens, Boolean.FALSE);

            for (int j=0; j<couples * 2; j=j+2) {
                int y = sc.nextInt();
                int x = sc.nextInt();

                areFriends[y][x] = true;
            }

            output[i] = countPairing(takens);
        }

        for (int i=0; i<number; i++) {
            System.out.println(output[i]);
        }
    }

    public static int countPairing(Boolean[] takens) {
        int n = takens.length;
        int freeIndex = -1;
        for (int i=0; i<n; i++) {
            if (!takens[i]) {
                freeIndex = i;
                break;
            }
        }
        if (freeIndex == -1)    return 1;

        int ret = 0;
        for (int i=freeIndex + 1; i<n; ++i) {
            if (!takens[i] && areFriends[freeIndex][i]) {
                takens[freeIndex] = takens[i] = true;
                ret += countPairing(takens);
                takens[freeIndex] = takens[i] = false;
            }
        }
        return ret;
    }
}
