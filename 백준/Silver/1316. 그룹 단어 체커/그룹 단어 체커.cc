#include <iostream>
#include <string>
#include <vector>

using namespace std;

bool isFirst(vector<int> &v, char ch);

int main()
{
    vector<int> v(28);
    string str;
    int N, result = 0;
    int i, j, k;
    
    cin >> N;
    
    for (i = 0; i < N; i++)
    {
        cin >> str;
        
        for (j = 0; j < str.size(); j++)
        {
            if (isFirst(v, str[j])) // group word
            {
                v[str[j] - 'a']++;
                for (k = j; k < str.size() - 1; k++)
                {
                    if (str[k] != str[k + 1])
                        break;
                    j++;
                }
            }
            else // Not group word
                break;
        }
        if (j == str.size())
            result++;
            
        v.assign(28, 0);
    }
    
    cout << result;
    
    return 0;
}

bool isFirst(vector<int> &v, char ch)
{
    if (v[ch - 'a'] == 0)
        return true;
    else
        return false;
}

