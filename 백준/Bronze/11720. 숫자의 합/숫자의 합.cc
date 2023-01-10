#include <iostream>
#include <cstring>

using namespace std;

int main()
{
    string str;
    int n, sum = 0;
    
    cin >> n >> str;
    for (int i = 0; i < n; i++)
        sum += str[i] - '0';
    cout << sum;
}