#include <iostream>
#include <string>

using namespace std;


int main()
{
    string str;
    int i;
    
    cin >> str;
    
    for (char c = 'a'; c <= 'z'; c++)
    {
        for (i = 0; i < str.size(); i++)
        {
            if (c == str[i])
            {
                cout << i << " ";
                break;
            }
        }
        
        if (i == str.size())
            cout << "-1 ";
    }
    
    return 0;
}