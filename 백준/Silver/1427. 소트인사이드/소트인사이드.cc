#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
    vector<char> v;
    string word;
    
    cin >> word;
    for (int i = 0; i < word.size(); i++)
    {
        v.push_back(word[i]);
    }
    sort(v.begin(), v.end(), greater<char>());
    
    for (int i = 0; i < v.size(); i++)
        cout << v[i];
    
    return 0;
}