#include <iostream>
#include <vector>
using namespace std;

#define fastio ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

typedef pair<int, int> pii;

void print_order(vector<pii>);
int main()
{
    fastio;
    vector<pii> v;
    int n; cin >> n;
    int weight, height;
    
    
    for (int i = 0; i < n; i++)
    {
        cin >> weight >> height;
        v.push_back(pii(weight, height));
    }
    
    // for (int i = 0; i < n; i++)
    //     cout << "w : " << v[i].first << "h : " << v[i].second << "\n";
    
    print_order(v);
    
    return 0;
}

void print_order(vector<pii> v)
{
    vector<pii>::iterator it, jt;
    int cnt;
    
    for (it = v.begin(); it != v.end(); it++)
    {
        cnt = 1;
        for (jt = v.begin(); jt != v.end(); jt++)
        {
            if (it->first < jt->first && it->second < jt->second)
                cnt++;
        }
        cout << cnt << " ";
    }
}