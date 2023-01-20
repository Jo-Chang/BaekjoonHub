// #2751. 수 정렬하기 2

#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
    // FILE *pFile = freopen("example/2751.txt", "r", stdin);

    vector<int> v;
    int N;

    cin >> N;
    for (int i = 0; i < N; i++)
    {
        int num;
        cin >> num;
        v.push_back(num);
    }

    sort(v.begin(), v.end());
    // sort(v.begin(), v.end(), less<int>());

    for (int i = 0; i < N; i++)
        cout << v[i] << "\n";

    return 0;
}