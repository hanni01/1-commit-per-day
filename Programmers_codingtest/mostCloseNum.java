package Programmers_codingtest;

import java.util.Arrays;
import java.util.Scanner;

public class mostCloseNum {
    public static int[] solution(String s) {
        String[] s_arr = s.split("");
        int[] answer = new int[s_arr.length];
        Arrays.fill(answer, -1);

        for(int i = s_arr.length - 1;i > 0;i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (s_arr[i].equals(s_arr[j])) {
                    System.out.println("ok");
                    answer[i] = i - j;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        solution(s);
    }
}
