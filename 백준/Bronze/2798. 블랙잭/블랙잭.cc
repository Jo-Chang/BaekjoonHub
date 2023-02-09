#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

#define fastio ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

int get_maximun_sum(vector<int>, int);
vector<vector<int>> get_combination(vector<int>, int);
void recursive_comb(vector<vector<int>>&, vector<int>, vector<int>, int, int, int);

int main()
{
    fastio;
    vector<int> vec_card;
    int num_card, num_limit, num;

    cin >> num_card >> num_limit;
    for (int i = 0; i < num_card; i++)
    {
        cin >> num;
        vec_card.push_back(num);
    }

    cout << get_maximun_sum(vec_card, num_limit);

    return 0;
}

int get_maximun_sum(vector<int> v, int limit)
{
    vector<vector<int>> vec_comb = get_combination(v, 3);
    vector<int> vec_sum;
    /* print 2d vector
    for (int i = 0; i < vec_comb.size(); i++)
    {
        for (int j = 0; j < 3; j++)
        {
            cout << vec_comb[i][j] << " ";
        }
        cout << "\n";
    }
    */
    for (int i = 0; i < vec_comb.size(); i++)
    {
        int sum = 0;
        for (int j = 0; j < 3; j ++)
            sum += vec_comb[i][j];
        
        if (sum <= limit)
            vec_sum.push_back(sum);
    }
    sort(vec_sum.begin(), vec_sum.end(), greater<>());

    return vec_sum.front();
}

vector<vector<int>> get_combination(vector<int> v, int select)
{
    vector<vector<int>> temp;
    vector<int> tmp;

    recursive_comb(temp, v, tmp, 0, select, select);

    return temp;
}

void recursive_comb(vector<vector<int>>& v2, vector<int> v, vector<int> t, int loc, int r, int select)
{
    vector<int> temp(t);
    vector<int>::iterator it;

    if (r == 0)
    {
        v2.push_back(t);
        t.clear();
        return;
    }

    for (int i = loc; i <= v.size() - r; i++)
    {
        t.push_back(v[i]);

        recursive_comb(v2, v, t, i + 1, r - 1, select);
        t.pop_back();
    }
}