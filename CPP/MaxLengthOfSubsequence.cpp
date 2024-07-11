#include <iostream>
#include <map>

using namespace std;

class Solution
{
public:
    /*
        Question: Given an array of integers find the maximum length of subsequence such that each element in subsequence
        is +1 of the previous element.
        Brute force approach TC: O(n*n)
        Optimized approach TC: O(n), SC: O(n)
    */
    int maxLengthOfSubsequence(vector<int> &array)
    {
        if (array.size() < 2)
            return array.size();
        // init a DP array each elem initialized to 1
        // because each element can be a subsequence in it self, of lenght 1
        vector<int> dp(array.size(), 1);

        // init maxLen
        int maxLen = 1;

        // declare a map that will hold index of each element as we encounter them
        unordered_map<int, int> targetIdxMap;

        // iterate over the input array, check if elem+1 is present and update dp[i] accordingly
        for (int i = 0; i < array.size(); i++)
        {
            int num = array[i];
            int target = num - 1;
            if (targetIdxMap.count(target) == 1)
            {
                dp[i] = max(dp[i], dp[targetIdxMap[target]] + 1);
                maxLen = max(dp[i], maxLen);
            }
            targetIdxMap[num] = i;
        }

        return maxLen;
    }

    /*
        Question: Given an array of integers find the maximum length of subsequence such that each element in subsequence
        has a diff of 1 to d from the previous element.
        if d = 3, elements diff can be 1, 2 or 3
        Optimized approach TC: O(nd), SC: O(n)
    */
    int maxLengthOfSubsequence2(vector<int> &array, int d)
    {
        if (array.size() < 2)
            return array.size();
        // init a DP array each elem initialized to 1
        // because each element can be a subsequence in it self, of lenght 1
        vector<int> dp(array.size(), 1);

        // init maxLen
        int maxLen = 1;

        // declare a map that will hold index of each element as we encounter them
        unordered_map<int, int> targetIdxMap;

        // iterate over the input array, check if elem+1 is present and update dp[i] accordingly
        for (int i = 0; i < array.size(); i++)
        {
            int num = array[i];
            int count = d;
            int target = num - 1;
            while (count--)
            {
                if (targetIdxMap.count(target) == 1)
                {
                    dp[i] = max(dp[i], dp[targetIdxMap[target]] + 1);
                    maxLen = max(dp[i], maxLen);
                }
                target--;
            }
            targetIdxMap[num] = i;
        }

        return maxLen;
    }

    /*
        Question: Given an array of integers find the maximum length subsequence vector such that each element in subsequence
        has a diff of 1 to d from the previous element.
        if d = 3, elements diff can be 1, 2 or 3
        Optimized approach TC: O(nd), SC: O(n)
    */
    vector<int> maxLengthOfSubsequence3(vector<int> &array, int d)
    {
        if (array.size() < 2)
            return array;
        // TODO implementation
        return array;
    }

};

int main()
{
    Solution *s = new Solution();
    vector<int> input = {1, 4, 5, 0, 6, 8, 10};
    int res1 = s->maxLengthOfSubsequence(input);
    int res2 = s->maxLengthOfSubsequence2(input, 2);
    cout << "Res1: " << res1 << endl;
    cout << "Res2: " << res2 << endl;
    cout<<"===================="<<endl;

    input = {0, 0, 5, 0, 6};
    res1 = s->maxLengthOfSubsequence(input);
    res2 = s->maxLengthOfSubsequence2(input, 1);
    cout << "Res1: " << res1 << endl;
    cout << "Res2: " << res2 << endl;
    cout<<"===================="<<endl;

    input = {1, 2, 3, 4, 5, 6};
    res1 = s->maxLengthOfSubsequence(input);
    res2 = s->maxLengthOfSubsequence2(input, 2);
    cout << "Res1: " << res1 << endl;
    cout << "Res2: " << res2 << endl;
    cout<<"===================="<<endl;

    input = {6, 5, 4, 3, 2, 1, 1};
    res1 = s->maxLengthOfSubsequence(input);
    res2 = s->maxLengthOfSubsequence2(input, 0);
    cout << "Res1: " << res1 << endl;
    cout << "Res2: " << res2 << endl;
    cout<<"===================="<<endl;
    return 0;
}