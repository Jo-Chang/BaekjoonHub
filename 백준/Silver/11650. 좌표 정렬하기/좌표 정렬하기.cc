#include <iostream>
#include <vector>
#include <algorithm>

#define fastio ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
using namespace std;

typedef pair<int, int> int2;

void print_vector2(vector<int2> v);


int main()
{
    vector<int2> pos_vec;
    int N;
    
    cin >> N;
    for (int i = 1; i <= N; i++)
    {
        int x_pos, y_pos;
        cin >> x_pos >> y_pos;
        pos_vec.push_back(make_pair(x_pos, y_pos));
    }
    
    sort(pos_vec.begin(), pos_vec.end());
    
    print_vector2(pos_vec);
    
    return 0;
}


void print_vector2(vector<int2> v)
{
    for (vector<int2>::iterator it = v.begin(); it != v.end(); it++)
        cout << it->first << " " << it->second << "\n";
}


