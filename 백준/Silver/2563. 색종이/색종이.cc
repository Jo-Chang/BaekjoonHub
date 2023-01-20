#include <iostream>
#include <vector>

using namespace std;

#define WHITE_LEN 100
#define BLACK_LEN 10

int main()
{
    vector<vector<bool>> vec(WHITE_LEN, vector<bool>(WHITE_LEN, false));
    int black_num, pos_x, pos_y;
    int area = 0;
    
    cin >> black_num;
    for (int i = 0; i < black_num; i++)
    {
        cin >> pos_x >> pos_y;
        for (int x = 0; x < BLACK_LEN; x++)
        {
            for (int y = 0; y < BLACK_LEN; y++)
            {
                if (vec[pos_x + x][pos_y + y])
                    continue;
                vec[pos_x + x][pos_y + y] = true;
                area++;
            }
        }
    }
    
    cout << area;
    
    return 0;
}