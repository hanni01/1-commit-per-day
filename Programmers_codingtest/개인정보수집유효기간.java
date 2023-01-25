package Programmers_codingtest;

import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        String[][] tType = new String[terms.length][2];
        String[][] privaciesInfo = new String[privacies.length][2];
        String[] dateToday = new String[3];
        String[] datePrivacy = new String[3];
        int target = 0;

        for(int i = 0;i< terms.length;i++)
        {
            tType[i] = terms[i].split(" ");
        }
        for(int i = 0;i< privacies.length;i++)
        {
            privaciesInfo[i] = privacies[i].split(" ");
        }

        dateToday = today.split("\\.");

        for(int i = 0;i < privacies.length;i++)
        {
            datePrivacy = privaciesInfo[i][0].split("\\.");
            for(int j = 0;j < tType.length;j++)
            {
                if(privaciesInfo[i][1].equals(tType[j][0]))
                {
                    target = Integer.parseInt(tType[j][1]);
                }
            }
            int calM = Integer.parseInt(datePrivacy[1]) + target;
            int calY = Integer.parseInt(datePrivacy[0]);
            if(calM > 12) {
                int plusY = calM / 12;
                int resultM = calM % 12;
                calY += plusY;
                calM = resultM;
                if(resultM == 0)
                {
                    calY -= 1;
                    calM = 12;
                }
            }
            if(Integer.parseInt(dateToday[0]) > calY)
            {
                list.add(i + 1);
            }
            else if(Integer.parseInt(dateToday[0]) == calY)
            {
                if(Integer.parseInt(dateToday[1]) > calM)
                {
                    list.add(i + 1);
                }
                else if(Integer.parseInt(dateToday[1]) == calM)
                {
                    if(Integer.parseInt(dateToday[2]) >= Integer.parseInt(datePrivacy[2]))
                    {
                        list.add(i + 1);
                    }
                }
            }
        }
        Collections.sort(list);
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}