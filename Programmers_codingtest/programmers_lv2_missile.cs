using System;
using System.Linq;
using System.Collections.Generic;

public class Solution
{
    public int solution(int[,] targets)
    {
        int answer = 0;

        //List<List<int>> intervals = new List<List<int>>();
        var intervals = new List<(int, int)>();
        for (int i = 0; i < targets.GetLength(0); i++)
        {
            intervals.Add((targets[i, 0], targets[i, 1]));
        }

        var sortedList = intervals.OrderBy(o => o.Item1).ToList();

        int tail = int.MaxValue;
        foreach ((int start, int end) point in sortedList)
        {
            if (point.end < tail)
            {
                tail = point.end;
                continue;
            }

            if (point.start >= tail)
            {
                tail = point.end;
                answer += 1;
            }
        }

        return answer + 1;
    }
}