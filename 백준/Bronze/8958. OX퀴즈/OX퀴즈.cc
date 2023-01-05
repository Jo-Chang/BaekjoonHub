#include<iostream>
#include<vector>
#include<cstring>

using namespace std;

int main()
{
    vector<int> v;
    string str;
    int T, sum;
    
    cin >> T;
    for (int i = 0; i < T; i++)
    {
        cin >> str;
        sum = 0;
        
        for (int j = 0; str[j]; j++)
        {
            if (str[j] == 'O')
            {
                v.push_back(1);
                for (int k = j - 1; k >= 0; k--)
                {
                    if (v[k] == 0)
                        break;
                    v[k]++;
                }
            }
            else
                v.push_back(0);
        }
        
        for (int j = 0; str[j]; j++)
            sum += v[j];
        cout << sum << endl;
        v.clear();
    }
    
    return 0;
}