#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
#define fastio ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

typedef pair<int, int> pii;

bool sort_y(pii a, pii b);
void print_vector(vector<pii> v);

int main()
{
    vector<pii> point_vec;
    int n_num;
    
    cin >> n_num;
    for (int i = 0; i < n_num; i++)
    {
        int x_pos, y_pos;
        cin >> x_pos >> y_pos;
        point_vec.push_back(pii(x_pos, y_pos));
    }
    
    sort(point_vec.begin(), point_vec.end(), sort_y);
    
    print_vector(point_vec);
    
    return 0;
}

bool sort_y(pii a, pii b)
{
    if (a.second == b.second)
        return a.first < b.first;
    return a.second < b.second;
}

void print_vector(vector<pii> v)
{
    for (int i = 0; i < v.size(); i++)
        cout << v[i].first << " " << v[i].second << "\n";
}