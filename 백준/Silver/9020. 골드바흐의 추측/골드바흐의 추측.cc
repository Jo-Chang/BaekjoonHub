#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

#define MAX_NUM 10000

vector<bool> init_sieve(vector<bool> &sieve);

int main()
{
    vector<bool> sieve;
    int T, n;
    
    cin >> T;
    init_sieve(sieve);
    
    for (int test_case = 1; test_case <= T; test_case++)
    {
        cin >> n;
        
        for (int i = n / 2; i > 1; i--)
        {
            if (!sieve[i])
                continue;
                
            if (sieve[n - i])
            {
                cout << i << " " << n - i << "\n";
                break;
            }
        }
    }
    
    
    return 0;
}

vector<bool> init_sieve(vector<bool> &sieve)
{
    // vector<bool> sieve;
    
    sieve.assign(MAX_NUM + 1, true);
    sieve[0] = false;
    sieve[1] = false;
    for (int i_num = 2; i_num <= sqrt(MAX_NUM); i_num++)
    {
        if (!sieve[i_num])
            continue;
            
        for (int j_num = i_num * 2; j_num <= MAX_NUM; j_num += i_num)
            sieve[j_num] = false;
    }
    
    return sieve;
}