#include <iostream>
#include <map>

using namespace std;
/*
    Question: Given an array of integers find the maximum length of subsequence such that each element in subsequence
    is +1 of the previous element.
    Brute force approach TC: O(n*n)
    Optimized approach TC: O(n), SC: O(n)
*/

class Solution {
    public:
    int maxLengthOfSubsequence(vector<int>& array) {
        if(array.size() < 2) return array.size();
        //init a DP array each elem initialized to 1
        //because each element can be a subsequence in it self, of lenght 1
        vector<int> dp(array.size(), 1);

        //init maxLen
        int maxLen = 1;

        //declare a map that will hold index of each element as we encounter them
        map<int,int> targetIdxMap;

        //iterate over the input array, check if elem+1 is present and update dp[i] accordingly
        for(int i = 0; i < array.size(); i++) {
            int num = array[i];
            int target = num-1;
            if(targetIdxMap.count(target) == 1) {
                dp[i] = max(dp[i], dp[targetIdxMap[target]] + 1);
                maxLen = max(dp[i], maxLen);
            }
            targetIdxMap[num] = i;
        } 

        return maxLen;
    }
};

int main() {
    Solution* s = new Solution();
    vector<int> input = {1,4,5,0,6};
    int res = s->maxLengthOfSubsequence(input);
    cout<<"Res: "<<res<<endl;
    input = {0,0,5,0,6};
    res = s->maxLengthOfSubsequence(input);
    cout<<"Res: "<<res<<endl;
    input = {1,2,3,4,5,6};
    res = s->maxLengthOfSubsequence(input);
    cout<<"Res: "<<res<<endl;
    input = {6,5,4,3,2,1};
    res = s->maxLengthOfSubsequence(input);
    cout<<"Res: "<<res<<endl;
    return 0;
}