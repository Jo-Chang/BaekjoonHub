#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> get_init_vector(int row, int column);

int main()
{
    vector<vector<int>> procession;
    int row, column;
    
    cin >> row >> column; 
    procession = get_init_vector(row, column);
    for (int p_case = 1; p_case <= 2; p_case++)
    {
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < column; j++)
            {
                int temp_num;
                
                cin >> temp_num;
                
                procession[i][j] += temp_num;
            }
        }
    }
    
    for (int i = 0; i < row; i++)
    {
        for (int j = 0; j < column; j++)
            cout << procession[i][j] << " ";
        cout << "\n";
    }
    
    return 0;
}

vector<vector<int>> get_init_vector(int row, int column)
{
    vector<vector<int>> vec(row, vector<int>(column));
    
    return vec; 
}