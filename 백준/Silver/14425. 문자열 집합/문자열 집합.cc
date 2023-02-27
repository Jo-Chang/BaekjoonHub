#include <iostream>
#include <string>
#include <set>
using namespace std;

#define fastio ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

int main()
{
    fastio;
    set<string> s;
    string word;
    int n, m, cnt=0;
    int i;
    
    cin >> n >> m;
    for (i = 0; i < n; i++)
    {
        cin >> word;
        s.insert(word);
    }
    
    for (i = 0; i < m; i++)
    {
        cin >> word;
        if (s.find(word) != s.end())
            cnt++;
    }
    
    cout << cnt;

    return 0;
}