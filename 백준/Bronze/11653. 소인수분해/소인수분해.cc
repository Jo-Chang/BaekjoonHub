#include <iostream>

using namespace std;

int get_min_divisor(int &num);

int main()
{
    int N;
    
    cin >> N;
    while (N > 1)
        cout << get_min_divisor(N) << endl;
    
    return 0;
}

int get_min_divisor(int &num)
{
    int temp_num = num;
    
    for (int i_num = 2; i_num <= num / 2; i_num++)
    {
        if (num % i_num == 0)
        {
            num /= i_num;
            return i_num;
        }
    }
    num /= num;
    return temp_num;
}