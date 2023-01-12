#include <iostream>
#include <string>

using namespace std;

int alphabet_count(string str);

int main()
{
    string str;
    
    cin >> str;
    
    cout << alphabet_count(str);
    
    return 0;
}

int alphabet_count(string word)
{
    string str = word + "\0";
    int len = str.size();
    
    for (int i = 0; i < str.size() - 1; i++)
    {
        string temp = "";
        temp += str[i];
        temp += str[i + 1];
        
        if (temp == "c=" || temp == "c-" || temp == "d-" || temp == "lj" || \
        temp == "nj" || temp == "s=" || temp == "z=")
            len--;
        else if(i != str.size() - 2 && temp + str[i + 2] == "dz=")
            len--;
    }
    
    return len;
}