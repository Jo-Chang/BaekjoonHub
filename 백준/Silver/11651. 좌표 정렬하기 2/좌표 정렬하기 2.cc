#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
#define fastio ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

typedef pair<int, int> pii;

bool sort_y(pii, pii);
void print_arr(pii*, int);

int main()
{
    pii *point_arr;
    int n_num, x_pos, y_pos;

    cin >> n_num;
    point_arr = new pii[n_num];
    for (int i = 0; i < n_num; i++)
    {
        cin >> x_pos >> y_pos;
        point_arr[i] = pii(x_pos, y_pos);
    }

    sort(point_arr, point_arr + n_num, sort_y);

    print_arr(point_arr, n_num);

    return 0;
}

bool sort_y(pii a, pii b)
{
    if (a.second == b.second)
        return a.first < b.first;
    return a.second < b.second;
}

void print_arr(pii *pii_arr, int N)
{
    for (int i = 0; i < N; i++)
        cout << pii_arr[i].first << " " << pii_arr[i].second << "\n";
}