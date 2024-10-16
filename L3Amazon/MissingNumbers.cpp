// #include<bits++h/stdc++.h>
// #include <vector>
// using namespace std;

// int missingNumber(vector<int> &nums) {
//     // Write your code here
//     int n_xor = nums.size;
//         for (int i = 0; i<n_xor; i++) {
//             n_xor = n_xor ^ i;
//             n_xor = n_xor ^ nums[i];

//         }
//         return n_xor;

// }
// int main(){
//     vector<int> nums(3);
//     nums[0]=1;
//     nums[1]=2;
//     nums[2]=3;
//     vector<int> brr(3);
//     brr[0]=1;
//     brr[1]=2;
//     brr[2]=3;
//     vector<int> ans = missingNumbers(nums,brr);
//     for(int i=0;i<ans.size();i++){
//         cout<<ans[i]<<" ";
//     }
// }















#include <bits/stdc++.h>
#include <unordered_set>
using namespace std;

vector<int> missingNumbers(vector<int> &nums, vector<int> &brr) {
    unordered_set<int> brrSet(brr.begin(), brr.end());
    vector<int> missing;

    for (int num : nums) {
        if (brrSet.find(num) == brrSet.end()) {
            missing.push_back(num);
        }
    }
    return missing;
}

int main() {
    vector<int> nums = {1, 2, 4, 6};
    vector<int> brr = {1, 2, 3, 5};

    vector<int> ans = missingNumbers(nums, brr);
    for (int i = 0; i < ans.size(); i++) {
        cout << ans[i] << " ";
    }
    cout << endl;

    return 0;
}
