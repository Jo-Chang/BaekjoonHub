#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

#define N_MAX 123456 * 2

vector<bool> init_sieve(vector<bool> &sieve);

int main()
{
    int N;
    vector<bool> sieve;
    
    init_sieve(sieve);
    while (true)
    {
        cin >> N;
        if (N == 0)
            break;
        
        int cnt = 0;
        for (int i_num = N + 1; i_num <= 2 * N; i_num++)
            if (sieve[i_num])
                cnt++;
                
        cout << cnt << "\n";
    }
    
    return 0;
}

vector<bool> init_sieve(vector<bool> &sieve)
{
    // vector<bool> sieve;
    
    sieve.assign(N_MAX + 1, true);
    sieve[0] = false;
    sieve[1] = false;
    for (int i_num = 2; i_num <= sqrt(N_MAX); i_num++)
    {
        if (!sieve[i_num])
                continue;
        for (int j_num = i_num * 2; j_num <= N_MAX; j_num += i_num)
        {
            sieve[j_num] = false;
        }
    }
    
    return sieve;
}