#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric>

using namespace std;

#define CASE_NUM 5

int main()
{
    vector<int> v;
    
    for (int i = 0; i < CASE_NUM; i++)
    {
        int temp;
        
        cin >> temp;
        v.push_back(temp);
    }
    
    sort(v.begin(), v.end());
    cout << accumulate(v.begin(), v.end(), 0) / (v.end() - v.begin()) << "\n" << v[CASE_NUM / 2];
    
    return 0;
}
