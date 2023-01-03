#include<iostream>

using namespace std;

int main()
{
    int piece[6], correct_piece[6] = {1, 1, 2, 2, 2, 8};
    // 1 1 2 2 2 8
    
    for (int i = 0; i < 6; i++)
        cin >> piece[i];
    for (int i = 0; i < 6; i++)
        cout << correct_piece[i] - piece[i] << " ";
    
    return 0;
}
