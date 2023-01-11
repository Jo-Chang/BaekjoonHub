#include <iostream>
#include <string>
#include <vector>

using namespace std;

int count_dial(string str);

int main()
{
    string str;
    
    cin >> str;
    
    cout << count_dial(str);
    
    return 0;
}

int count_dial(string str)
{
    vector<int> vec(28);
    int ans = 0;
    
    for (char ch = 'A'; ch <= 'Z'; ch++)
    {
        if (ch < 'P')
            vec[ch - 'A'] = (ch - 'A') / 3 + 3;
        else if ('P' <= ch && ch <= 'S')
            vec[ch - 'A'] = 8;
        else if ('T' <= ch && ch <= 'V')
            vec[ch - 'A'] = 9;
        else if ('W' <= ch && ch <= 'Z')
            vec[ch - 'A'] = 10;
        else
            // Wrong Input!
            return (-1);
    }
    
    for (int i = 0; i < str.size(); i++)
        ans += vec[str[i] - 'A'];
    
    return ans;
}