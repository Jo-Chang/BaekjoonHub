#include <iostream>
#include <vector>

using namespace std;

int main()
{
    vector<vector<int>> vec;
    const int const_row = 9, const_col = 9;
    int max_row = 0, max_col = 0;
    
    vec.assign(const_row, vector<int>(const_col));
    
    for (int i = 0; i < const_row; i++)
    {
        for (int j = 0; j < const_col; j++)
        {
            cin >> vec[i][j];
            if (vec[i][j] > vec[max_row][max_col])
            {
                max_row = i;
                max_col = j;
            }
        }
    }
    
    cout << vec[max_row][max_col] << "\n" << max_row + 1 << " " << max_col + 1;
    
    return 0;
}