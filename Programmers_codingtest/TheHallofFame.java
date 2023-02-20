package Programmers_codingtest;

import java.util.Arrays;

class TheHallofFame {
    public static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int[] top = new int[k];
        int small = score[0];

        if(k > score.length)
        {
            for(int i = 0;i < score.length;i++)
            {
                top[i] = score[i];
                if(small > top[i]) {small = top[i];}
                answer[i] = small;
            }
        }
        else
        {
            for(int i = 0;i < k;i++)
            {
                top[i] = score[i];
                if(small > top[i]) {small = top[i];}
                answer[i] = small;
            }
            small = compare(top, small);
            for(int i = k;i < score.length;i++)
            {
                System.out.println(Arrays.toString(top));
                if(score[i] > small)
                {
                    int idx = 0;
                    for(int j = 0;j < top.length;j++)
                    {
                        if(top[j] == small)
                        {
                            idx = j;
                        }
                    }
                    top[idx] = score[i];
                }
                small = compare(top, small);
                System.out.println(Arrays.toString(top) + " , "+small);
                answer[i] = small;
            }
        }
        return answer;
    }

    public static int compare(int[] arr, int small)
    {
        small = arr[0];
        for(int i = 1;i < arr.length;i++)
        {
            if(small > arr[i])
            {
                small = arr[i];
            }
        }
        return small;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new int[]{10, 20, 100, 120, 30})));
    }
}
