#include <iostream>
#include <cmath>

using namespace std;

#define fastio ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);


#define MAX_NUM int(pow(3, 7))

char arr_star[MAX_NUM][MAX_NUM];


void print_star(int);
void recursive(int, int, int);
void fill_center(int, int, int);

int main()
{
    fastio;
    
    int num_length;
    
    cin >> num_length;
    
    print_star(num_length);
    
    return 0;
}

void print_star(int num)
{
    recursive(num, 0, 0);
    
    for (int i = 0; i < num; i++)
    {
        for (int j = 0; j < num; j++)
        {
            cout << arr_star[i][j];
        }
        cout << "\n";
    }
}

void recursive(int num, int pos_x, int pos_y)
{
    if (num == 1)
    {
        arr_star[pos_x][pos_y] = '*';
        return;
    }
    
    for (int i = pos_x; i < pos_x + num; i += num / 3)
    {
        for (int j = pos_y; j < pos_y + num; j += num / 3)
        {
            if (i == pos_x + num / 3 && j == pos_y + num / 3)
                fill_center(num / 3, i, j);
            else
                recursive(num / 3, i, j);
        }
    }
}

void fill_center(int num, int pos_x, int pos_y)
{
    for (int i = pos_x; i < num + pos_x; i++)
    {
        for (int j = pos_y; j < num + pos_y; j++)
        {
            arr_star[i][j] = ' ';
        }
    }
}