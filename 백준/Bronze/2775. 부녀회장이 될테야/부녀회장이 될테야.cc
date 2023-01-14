#include <iostream>

using namespace std;

int num_resident(int k, int n);

int main()
{
    int T, k, n;
    
    cin >> T;
    for (int i = 1; i <= T; i++)
    {
        cin >> k >> n;
        cout << num_resident(k, n) << endl;
    }
    return 0;
}

int num_resident(int k, int n)
{
    int sum = 0;
    
    if (k == 0)
        return n;
        
    for(int i = 1; i <= n; i++)
        sum += num_resident(k - 1, i);
        
    return sum;
}