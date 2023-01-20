// #25305. 커트라인

#include <iostream>
#include <vector>
#include <cstdio>
#include <algorithm>

using namespace std;

int main()
{
    // FILE *pFile = freopen("example/25305.txt", "r", stdin);
    // if (pFile == NULL)
    // {
    //     cout << "Can't open such file\n";
    //     return 0;
    // }

    vector<int> v;
    int N, k;

    cin >> N >> k;
    for (int i = 0; i < N; i++)
    {
        int num;
        cin >> num;
        v.push_back(num);
    }

    sort(v.begin(), v.end(), greater<int>());
    
    cout << v[k - 1];

    return 0;
}