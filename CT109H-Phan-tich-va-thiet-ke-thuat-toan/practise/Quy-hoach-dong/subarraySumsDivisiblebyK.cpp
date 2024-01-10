//https://leetcode.com/problems/subarray-sums-divisible-by-k/
//leetcode #974
class Solution {
public:
    int subarraysDivByK(vector<int>& A, int k) {
        vector<int> counts(k,0);
	    int sum = 0;
	    for (vector<int>::iterator it = A.begin(); it != A.end(); ++it ) 
        { 
            int x = *it;
            sum += (x%k + k)%k;
            counts[sum%k]++;
        }

        int result = counts[0];
        for(int i = 0; i<k; i++) 
            result += (counts[i]*(counts[i]-1))/2;
        return result;
    }
};
