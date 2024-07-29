#include <bits/std++.h>
#include <vector>
using namespace std;
int mergeSortedArray(vector<int> nums)
{
    int i = 0;
    for (int j = 1; j < nums.size(); j++)
    {

        if (nums[i] < nums[j])
        {
            int temp = num[i + 1];
            nums[i + 1] = nums[j];
            nums[j] = temp;
            i++;
        }
    }
    return i+1;

}
int main(){
    vector<int> nums(7);
    nums[0]=1;
    nums[1]=1;
    nums[2]=1;
    nums[3]=1;
    nums[4]=2;
    nums[5]=2;
    nums[6]=3;
    cout<<mergeSortedArray(nums);
    
}
