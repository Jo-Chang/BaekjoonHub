#include <iostream>

using namespace std;

int main()
{
    int sugar, bags = -1;
    
    cin >> sugar;
    for (int i = sugar / 5; i >= 0; i--)
    {
        if ((sugar - i * 5) % 3 == 0)
        {
            bags = i + (sugar - i * 5) / 3;
            break;
        }
    }
    
    cout << bags;
    
    return 0;
}