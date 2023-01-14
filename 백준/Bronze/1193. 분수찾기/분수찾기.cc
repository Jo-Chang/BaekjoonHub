#include <iostream>

using namespace std;

int main()
{
    int X;
    int layer = 0, corner = 0;
    
    cin >> X;
    
    while (X > corner)
    {
        layer++;
        corner += layer;
    }
    
    if (layer % 2 == 0)
        cout << layer - (corner - X) << "/" << (corner - X) + 1;
    else
        cout << (corner - X) + 1 << "/" << layer - (corner - X);
        
    return 0;
}