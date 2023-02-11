#include <iostream>
#include <cmath>
using namespace std;

#define fastio ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

int get_min_constructor(int);
int main()
{
    fastio;
    int num_n;
    
    cin >> num_n;
    
    cout << get_min_constructor(num_n);
    
    return 0;
}

int get_min_constructor(int num)
{
    int num_constructor = 1, num_digit = 0;
    int num_temp = num, num_sum;
    
    // Get num digit
    while (num_temp > 0)
    {
        num_digit += 1;
        num_temp /= 10;
    }
    
    // Maximum start value when num is digit
    // num_constructor = pow(10, num_digit - 1) - 9 * num_digit;
    
    // Find minimum constructor num
    while (num_constructor < num)
    {
        num_sum = num_constructor;
        num_temp = num_constructor;
        
        while (num_temp > 0)
        {
            num_sum += num_temp % 10;
            num_temp /= 10;
        }
        
        // Compare construct number with num
        if (num_sum == num)
            return num_constructor;
            
        num_constructor++;
    }
    
    // No constructor return 0
    return 0;
}