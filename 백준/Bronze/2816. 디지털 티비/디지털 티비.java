import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        List<String> channels = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            channels.add(sc.next());
        }

        StringBuilder ans = new StringBuilder();

        int idxKBS1 = 0;
        int idxKBS2 = 0;

        for (int i = 0; i < N; i++) {
            if (channels.get(i).equals("KBS1")) {
                for (int j = 0; j < i; j++) {
                    ans.append("4");
                }
                idxKBS1 = i;
                break;
            }
            ans.append("1");
        }
        channels.remove(idxKBS1);
        channels.add(0, "KBS1");

        for (int i = 0; i < N; i++) {
            if (channels.get(i).equals("KBS2")) {
                for (int j = 1; j < i; j++) {
                    ans.append("4");
                }
                idxKBS2 = i;
                break;
            }
            ans.append("1");
        };
        System.out.println(ans);
    }
}