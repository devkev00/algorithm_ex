import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] gakList = new int[3]; // 세 각이 주어짐

        for (int i = 0; i < 3; i++) {
            gakList[i] = Integer.parseInt(br.readLine());
        }

        int sumOfGak = 0;
        for (int i = 0; i < 3; i++) {
            sumOfGak += gakList[i];
        }

        if (sumOfGak != 180) {
            System.out.println("Error");
        } else if (gakList[0] == gakList[1] && gakList[1] == gakList[2]) {
            System.out.println("Equilateral");
        } else if (gakList[0] == gakList[1] || gakList[0] == gakList[2] || gakList[1] == gakList[2]) {
            System.out.println("Isosceles");
        } else {
            System.out.println("Scalene");
        }
    }
}