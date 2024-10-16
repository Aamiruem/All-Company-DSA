// #include <bits/std++.h>
// #include <vector>
// using namespace std;
// int mergeSortedArray(vector<int> nums)
// {
//     int i = 0;
//     for (int j = 1; j < nums.size(); j++)
//     {

//         if (nums[i] < nums[j])
//         {
//             int temp = num[i + 1];
//             nums[i + 1] = nums[j];
//             nums[j] = temp;
//             i++;
//         }
//     }
//     return i+1;

// }
// int main(){
//     vector<int> nums(7);
//     nums[0]=1;
//     nums[1]=1;
//     nums[2]=1;
//     nums[3]=1;
//     nums[4]=2;
//     nums[5]=2;
//     nums[6]=3;
//     cout<<mergeSortedArray(nums);
    
// }




#include <bits/stdc++.h>
#include <vector>
using namespace std;

int mergeSortedArray(vector<int> &nums)
{
    if (nums.empty())
        return 0;

    int i = 0; // points to the last unique element
    for (int j = 1; j < nums.size(); j++)
    {
        if (nums[i] != nums[j]) // if a new distinct element is found
        {
            i++;               // move to the next position
            nums[i] = nums[j]; // place the distinct element at the next position
        }
    }
    return i + 1; // the new length of the array with unique elements
}

int main()
{
    vector<int> nums = {1, 1, 1, 1, 2, 2, 3};

    int newLength = mergeSortedArray(nums);

    cout << "The new length of the array after removing duplicates is: " << newLength << endl;

    // Printing the modified array
    cout << "Array after removing duplicates: ";
    for (int i = 0; i < newLength; i++)
    {
        cout << nums[i] << " ";
    }

    return 0;
}
