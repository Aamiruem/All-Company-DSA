#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;

vector<vector<string> > groupAnagrams(vector<string> &strs)
{
    unordered_map<string, vector<string> > map;

    // Iterate over each string in the input vector
    for (string &str : strs)
    {
        string key = str;             // Copy the original string
        sort(key.begin(), key.end()); // Sort the characters to form the key

        // Add the original string to the corresponding anagram group
        map[key].push_back(str);
    }

    // Prepare the result by extracting all values from the map
    vector<vector<string> > result;
    for (auto &entry : map)
    {
        result.push_back(entry.second);
    }

    return result;
}

int main()
{
    vector<string> strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

    vector<vector<string> > groupedAnagrams = groupAnagrams(strs);

    // Print the grouped anagrams
    for (const auto &group : groupedAnagrams)
    {
        cout << "[ ";
        for (const string &s : group)
        {
            cout << s << " ";
        }
        cout << "]\n";
    }

    return 0;
}
