#include <iostream>

#define fastio ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
using namespace std;

int get_recursive_factorial(int);
int main()
{
    fastio;
    int num_input;
    
    cin >> num_input;
    
    cout << get_recursive_factorial(num_input);
    
    return 0;
}

int get_recursive_factorial(int num)
{
    if (num == 1 || num == 0)
        return 1;
    return get_recursive_factorial(num - 1) * num;
}