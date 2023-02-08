#include <iostream>
#include <vector>
using namespace std;

#define fastio ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

#define LEFT 0
#define CENTER 1
#define RIGHT 2

void recursive_hanoi(int, int, int, int);
void print_move(vector<pair<int, int>>);

vector<int> vec_base[3];
vector<pair<int, int>> vec_move;
int cnt = 0;

int main()
{
    fastio;
    
    int num_board;
    
    cin >> num_board;
    for (int i = num_board; i > 0; i--)
        vec_base[0].push_back(i);
    
    recursive_hanoi(LEFT, RIGHT, CENTER, num_board);
    print_move(vec_move);
    
    return 0;
}

void recursive_hanoi(int from, int to, int stay, int num)
{
    if (num == 0)
        return;
        
    // move num-1 boards from -> stay
    recursive_hanoi(from, stay, to, --num);
    
    // move biggest from -> to
    vec_base[to].push_back(vec_base[from].back());
    vec_base[from].pop_back();
    cnt++;
    vec_move.push_back(make_pair(from+1, to+1));
    
    // move num-1 boards stay -> to
    recursive_hanoi(stay, to, from, num);
}

void print_move(vector<pair<int, int>> v)
{
    cout << cnt << "\n";
    for (vector<pair<int,int>>::iterator it=v.begin(); it != v.end(); it++)
    {
        cout << it->first << " " << it->second << "\n";
    }
}