#include <iostream>
#include <set>
using namespace std;

#define fastio ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

int main()
{
    fastio;
    set<int> s;
    int *arr;
    int n, m, num;
    
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> num;
        s.insert(num);
    }
    
    cin >> m;
    arr = new int[m];
    for (int i = 0; i < m; i++)
        cin >> arr[i];
    
    for (int i = 0; i < m; i++)
    {
        if (s.find(arr[i]) == s.end())
            cout << 0 << " ";
        else
            cout << 1 << " ";
    }

    return 0;
}