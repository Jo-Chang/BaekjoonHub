#include <iostream>
using namespace std;

#define fastio ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

int get_dnum(int n);
bool is_devil_num(int dnum);

int main()
{
    fastio;
    int n;
    
    cin >> n;
    cout << get_dnum(n);
    
    return 0;
}

int get_dnum(int n)
{
    int dnum = 666;
    
    for (int i = 0; i < n; i++, dnum++)
    {
        while (!is_devil_num(dnum))
            dnum++;
    }
    
    return --dnum;
}

bool is_devil_num(int dnum)
{
    int cnt = 0;
    
    while (cnt < 3 && dnum > 0)
    {
        if (dnum % 10 == 6)
            cnt++;
        else
            cnt = 0;
        dnum /= 10;
    }
    
    if (cnt == 3)
        return true;
    else
        return false;
}