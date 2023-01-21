#include <iostream>
#include <vector>

using namespace std;

#define MAX_NUM 10000

int main()
{
    vector<int> v(MAX_NUM + 1, 0);
    int N;
    
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        int num;
        cin >> num;
        v[num]++;
    }
    
    for (int i = 1; i <= MAX_NUM; i++)
    {
        for (int j = 0; j < v[i]; j++)
        {
            cout << i << "\n";
        }
    }
    
    return 0;
}