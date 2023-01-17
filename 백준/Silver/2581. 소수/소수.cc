#include <iostream>

using namespace std;

int is_prime(int num);

int main()
{
    int M, N;
    int prime_sum = 0, prime_min = 0;
    
    cin >> M >> N;
    for (int i_num = M; i_num <= N; i_num++)
    {
        if(is_prime(i_num))
        {
            if (prime_min == 0)
                prime_min = i_num;
            prime_sum += i_num;
        }
    }
    if (prime_sum == 0)
        cout << -1;
    else
        cout << prime_sum << endl << prime_min;
    
    return 0;
}

int is_prime(int num)
{
    if (num == 1)
        return 0;   // 1 is not prime
        
    for (int i = 2; i <= num / 2; i++)
    {
        if (num % i == 0)
            return 0;   // num is not prime
    }
    return 1;   // num is prime
}