#include <iostream>
#include <string>

using namespace std;

int word_split_count(string str);

int main()
{
    string str;
    
    // cin.ignore();   -> 공백 제거
    getline(cin, str);
    cout << word_split_count(str);
    
    return 0;
}

int word_split_count(string str)
{
    int ans = 0;
    int flag_initiate = 1;
    
    for (int i = 0; i < str.size(); i++)
    {
        if(str[i] == ' ')
        {
            flag_initiate = 1;
            continue;
        }
        if(flag_initiate == 1)
        {
            ans++;
            flag_initiate = 0;
        }
    }
    
    return ans;
}