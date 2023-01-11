#include <iostream>
#include <string>

using namespace std;

string reverse_string(string &str);
int compare_greater(int n1, int n2);

int main()
{
    string str1, str2;
    
    cin >> str1 >> str2;
    
    reverse_string(str1);
    reverse_string(str2);
    
    cout << compare_greater(stoi(str1), stoi(str2));
    
    return 0;
}

string reverse_string(string &str)
{
    string rev_str = "";
    
    for (int i = str.size() - 1; i >= 0; i--)
        rev_str += str[i];
    str = rev_str;
    
    return rev_str;
}

int compare_greater(int n1, int n2)
{
    if (n1 > n2)
        return n1;
    else
        return n2;
}