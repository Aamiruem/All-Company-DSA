#include <bits/std++.h>

#include<iostream>
using namespace std;
int mergeSortedArray(vector<int> nums){
    int n = nums.size();
    vector<int> temp(n);
    int mid = n/2;
    mergeSort(nums, temp, 0, mid-1);
    mergeSort(nums, temp, mid, n-1);
    merge(nums, temp, 0, mid-1, n-1);
    return nums;
}
