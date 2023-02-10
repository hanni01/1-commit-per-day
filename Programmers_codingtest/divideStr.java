package Programmers_codingtest;

class divideStr {
    public int solution(String s) {
        int answer = 0;
        int s_length = s.length();
        char target;
        int same = 0, diff = 0;

        for(int i = 0;i < s_length;i++)
        {
            target = s.charAt(i);
            same += 1;
            answer += 1;
            for(int j = i+1;j < s_length;j++)
            {
                if(target == s.charAt(j)) { same += 1; }
                else { diff += 1; }

                if(same == diff)
                {
                    i = j;
                    break;
                }
                if(j + 1 == s_length)
                {
                    i = j;
                }
            }
        }
        return answer;
    }
}
