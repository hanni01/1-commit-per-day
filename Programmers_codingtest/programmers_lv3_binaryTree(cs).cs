using System;
using System.Collections.Generic;

public class Solution
{
    public int[] solution(long[] numbers)
    {

        int[] answer = new int[numbers.Length];

        for (int i = 0; i < numbers.Length; i++)
        {
            answer[i] = Tree(numbers[i]);
        }


        return answer;
    }

    public int Tree(long targetNum)
    {

        List<long> binArr = new List<long>();

        binArr = decToBin(targetNum);

        int rootNodeIdx = binArr.Count / 2;
        List<long> leftSubTree = new List<long>();
        List<long> rightSubTree = new List<long>();

        return binaryTree(binArr, rootNodeIdx, leftSubTree, rightSubTree);

    }

    public int binaryTree(List<long> arr, int root, List<long> left, List<long> right)
    {
        int leftResult = 1;
        int rightResult = 1;

        for (int i = 0; i < root; i++)
        {
            left.Add(arr[i]);
        }
        for (int j = root + 1; j < arr.Count; j++)
        {
            right.Add(arr[j]);
        }

        if (arr[root] == 0)
        {

            if (left.Count != 0)
            {
                if (left.Contains(1))
                {
                    return 0;
                }
            }

            if (right.Count != 0)
            {
                if (right.Contains(1))
                {
                    return 0;
                }
            }

        }
        else
        {
            if (left.Count != 0)
            {
                int rootIdx = left.Count / 2;
                if (left.Count % 2 == 0) rootIdx -= 1;

                List<long> leftsub = new List<long>();
                List<long> rightsub = new List<long>();

                leftResult = binaryTree(left, rootIdx, leftsub, rightsub);
            }
            if (right.Count != 0)
            {

                int rootIdx = right.Count / 2;
                if (right.Count % 2 == 0) rootIdx -= 1;

                List<long> leftsub = new List<long>();
                List<long> rightsub = new List<long>();

                rightResult = binaryTree(right, rootIdx, leftsub, rightsub);
            }
        }
        if (leftResult == 1 && rightResult == 1)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    public List<long> decToBin(long targetNum)
    {
        List<long> binList = new List<long>();

        do
        {
            binList.Add(targetNum % 2);
            targetNum /= 2;
        } while (targetNum > 0);

        if (binList.Count % 2 == 0)
        {
            binList.Add(0);
        }
        binList.Reverse();

        #region 포화 이진트리를 위한 비트 수 조절
        if (binList.Count == 2)
        {
            binList.Insert(0, 0);
        }
        if (3 < binList.Count && binList.Count < 7)
        {
            while (binList.Count < 7)
            {
                binList.Insert(0, 0);
            }
        }
        if (7 < binList.Count && binList.Count < 15)
        {
            while (binList.Count < 15)
            {
                binList.Insert(0, 0);
            }
        }
        if (15 < binList.Count && binList.Count < 31)
        {
            while (binList.Count < 31)
            {
                binList.Insert(0, 0);
            }
        }
        if (31 < binList.Count && binList.Count < 63)
        {
            while (binList.Count < 63)
            {
                binList.Insert(0, 0);
            }
        }
        #endregion

        return binList;
    }
}
