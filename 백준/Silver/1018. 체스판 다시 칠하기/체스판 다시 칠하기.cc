#include <iostream>
#include <cmath>
using namespace std;

#define fastio ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
#define BOARD_SIZE 8

int get_min_fill_num(char**, int, int);
int get_fill_num(char**, int, int);
char get_opposite(char);

int main()
{
    fastio;
    int n, m;
    char **arr;
    
    // input
    cin >> n >> m;
    arr = new char*[n];
    for (int i = 0; i < n; i++)
    {
        arr[i] = new char[m];
        for (int j = 0; j < m; j++)
        {
            cin >> arr[i][j];
        }
    }
    
    // solution
    cout << get_min_fill_num(arr, n, m);

    return 0;
}

int get_min_fill_num(char **arr, int n, int m)
{
    int ans = pow(BOARD_SIZE, 2), temp;
    
    for (int i = 0; i <= n - BOARD_SIZE; i++)
    {
        for (int j = 0; j <= m - BOARD_SIZE; j++)
        {
            temp = get_fill_num(arr, i, j);
            if (temp < ans)
                ans = temp;
        }
    }
    
    return ans;
}

int get_fill_num(char **arr, int x, int y)
{
    int fill = 0;
    char ch = arr[0][0];
    
    for (int i = x; i < x + BOARD_SIZE; i++)
    {
        for (int j = y; j < y + BOARD_SIZE; j++)
        {
            if (arr[i][j] != ch)
                fill++;
            ch = get_opposite(ch);
        }
        ch = get_opposite(ch);
    }
    
    if (fill > pow(BOARD_SIZE, 2) / 2)
        fill = pow(BOARD_SIZE, 2) - fill;
        
    return fill;
}

char get_opposite(char ch)
{
    if (ch == 'W')
        return 'B';
    else
        return 'W';
}