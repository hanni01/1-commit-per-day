package Programmers_codingtest;

import java.util.HashMap;
import java.util.Scanner;

class 개인정보수집유효기간 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        String[][] tType = new String[terms.length][2];
        String[][] privaciesInfo = new String[privacies.length][2];
        int target;

        for(int i = 0;i< terms.length;i++)
        {
            tType[i] = terms[i].split(" ");
        }
        for(int i = 0;i< privacies.length;i++)
        {
            privaciesInfo[i] = privacies[i].split(" ");
        }

        for(int i = 0;i < privacies.length;i++)
        {
            for(int j = 0;j < tType.length;j++)
            {
                if(privaciesInfo[i][1].equals(tType[j][0]))
                {
                    target = Integer.parseInt(tType[j][1]);
                }
                else
                {
                    continue;
                }
            }
        }

        return answer;
    }
}