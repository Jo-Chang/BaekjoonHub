#include <iostream>
#include <string>

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
    int ans = 0;
    
    for (int i = 0; i < str.size(); i++)
    {
        if ('A' <= str[i] && str[i] <= 'C')
            ans += 3;
        else if ('D' <= str[i] && str[i] <= 'F')
            ans += 4;
        else if ('G' <= str[i] && str[i] <= 'I')
            ans += 5;
        else if ('J' <= str[i] && str[i] <= 'L')
            ans += 6;
        else if ('M' <= str[i] && str[i] <= 'O')
            ans += 7;
        else if ('P' <= str[i] && str[i] <= 'S')
            ans += 8;
        else if ('T' <= str[i] && str[i] <= 'V')
            ans += 9;
        else if ('W' <= str[i] && str[i] <= 'Z')
            ans += 10;
        else
            // Wrong Input!
            return (-1);
    }
    
    return ans;
}