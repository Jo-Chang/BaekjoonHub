#include <iostream>
#include <string>

using namespace std;

int main()
{
    string str1, str2;
    long long accumulate = 0;
    
    cin >> str1 >> str2;
    
    for (int i = 0; i < str1.size(); i++)
        for (int j = 0 ; j < str2.size(); j++)
            accumulate += (str1[i] - '0') * (str2[j] - '0');
    
    cout << accumulate;
    
    return 0;
}