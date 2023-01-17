package Programmers_codingtest;

import java.util.Scanner;

public class divisorCalculate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = 0;
        int result = 0;
        int left = sc.nextInt();
        int right = sc.nextInt();

        for(int i = left;i <= right;i++)
        {
            for(int j = 1;j * j <= i;j++)
            {
                if(j * j == i) cnt++;
                else if(i % j == 0) cnt += 2;
            }
            if(cnt % 2 == 0) result += i;
            else result -= i;
            cnt = 0;
        }
        System.out.println(result);
    }
}
