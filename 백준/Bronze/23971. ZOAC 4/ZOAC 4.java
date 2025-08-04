import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();
        int N = sc.nextInt();
        int M = sc.nextInt();

        sc.close();

        int maxPeople = 0; // 1, 1 기준으로 셈
        int currentH = 0;
        int currentW = 0; // 인덱스 기준

        for (int i = 0; i < H; i += N + 1) {
            for (int j = 0; j < W; j += M + 1) {
                maxPeople++;
            }
        }
        System.out.println(maxPeople);
    }
}
