#include <iostream>

using namespace std;

int is_prime(int num);

int main()
{
    int N, num;
    int prime_count = 0;
    
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> num;
        prime_count += is_prime(num);
    }
    cout << prime_count;
    
    return 0;
}

int is_prime(int num)
{
    if (num == 1)
        return 0;
    for (int i = 2; i <= num / 2; i++)
    {
        if (num % i == 0)
            return 0;
    }
    
    return 1;
}