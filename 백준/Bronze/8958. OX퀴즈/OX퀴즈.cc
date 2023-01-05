#include<iostream>

using namespace std;

int main()
{
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
                sum++;
                for (int k = j - 1; k >= 0; k--)
                {
                    if (str[k] == 'X')
                        break;
                    sum++;
                }
            }
        }
        
        cout << sum << endl;
    }
    
    return 0;
}