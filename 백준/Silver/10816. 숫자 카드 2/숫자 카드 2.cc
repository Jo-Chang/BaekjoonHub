#include <iostream>
#include <unordered_map>
using namespace std;

#define fastio ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

int main()
{
    fastio;
    unordered_map<int, int> um;
    int n, m, num;
    int i;
    
    cin >> n;
    for (i = 0; i < n; i++)
    {
        cin >> num;
        if (um.find(num) == um.end())
            um[num] = 1;
        else
            um[num]++;
    }
    
    cin >> m;
    for (i = 0; i < m; i++)
    {
        cin >> num;
        cout << um[num] << " ";
    }
    
    return 0;
}