#include <iostream>
#include <vector>

using namespace std;

void    find_none_selfnum(vector<int> &vec, int n);
void    print_selfnum(vector<int> vec);

int main()
{
    vector<int> vec(10000, 0);
    
    find_none_selfnum(vec, 1);
    print_selfnum(vec);
    
    return 0;    
}

void    find_none_selfnum(vector<int> &vec, int n)
{
    if (n > 10000)
        return;
    int temp_num = n, sum = n;
    
    while (temp_num > 0 && sum <= 10000)
    {
        sum += temp_num % 10;
        temp_num /= 10;
    }
    if (sum <= 10000)
        vec[sum - 1]++;
    find_none_selfnum(vec, n + 1);
}

void    print_selfnum(vector<int> vec)
{
    for (int i = 0; i < 10000; i++)
        if(vec[i] == 0)
            cout << i + 1 << endl;
}