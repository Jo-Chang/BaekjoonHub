#include <iostream>

using namespace std;

int main()
{
    int a, b, c;
    
    cin >> a >> b >> c;
    
    if (b >= c)
        cout << -1;
    else
        cout << (unsigned int)a / (c - b) + 1;
    
    return 0;
}