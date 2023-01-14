#include <iostream>

using namespace std;

int main()
{
    int N;
    int layer = 1;
    int corner = 0;
    
    cin >> N;
    
    while (N - 1 > 6 * corner)
    {
        corner += layer;
        layer++;
    }
    
    cout << layer;
    
    return 0;
}