package Programmers_codingtest;

import java.util.Arrays;
import java.util.Scanner;

public class SubString {
    public static int solution(String t, String p) {
        String[] t_arr = t.split("");
        String[] p_arr = p.split("");
        int t_length = t_arr.length;
        int p_length = p_arr.length;

        int answer = 0;

        String[] result_arr = new String[t_length - p_length + 1];
        Arrays.fill(result_arr, "");

        for(int i = 0;i < result_arr.length;i++)
        {
            for(int j = i;j < i + p_length;j++)
            {
                result_arr[i] = result_arr[i] + t_arr[j];
            }
        }

        for(int i = 0;i < result_arr.length;i++)
        {
            if(Long.parseLong(result_arr[i]) <= Integer.parseInt(p))
            {
                answer+=1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String t = sc.next();
        String p = sc.next();

        System.out.println(solution(t, p));
    }
}
