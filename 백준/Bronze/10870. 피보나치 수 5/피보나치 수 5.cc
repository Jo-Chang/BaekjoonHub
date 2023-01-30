#include <iostream>

using namespace std;

#define fastio ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);


int get_fibonacci(int);
int main()
{
    int num_input;
    
    cin >> num_input;
    
    cout << get_fibonacci(num_input);
    
    return 0;
}

int get_fibonacci(int num)
{
    if (num == 0 || num == 1)
        return num;
        
    return (get_fibonacci(num - 1) + get_fibonacci(num - 2));
}