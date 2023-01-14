#include <iostream>

using namespace std;

int main()
{
    int a, b, v;
    int day = 1, current_distance;
    
    // cin.tie(NULL);
    // ios_base::sync_with_stdio(false);
    cin >> a >> b >> v;
    
    // current_distance = a;
    
    // while (v > current_distance)
    // {
    //     current_distance += a - b;
    //     day++;
    // }
    
    // cout << day;
    
    if ((v - a) % (a - b) == 0)
        cout << (v - a) / (a - b) + 1;
    else
        cout << (v - a) / (a - b) + 2;
    
    return 0;
}