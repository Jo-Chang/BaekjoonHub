#include <iostream>
#include <string>
#include <unordered_map>
#include <cctype>
using namespace std;

#define fastio ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

int main()
{
    fastio;
    unordered_map<int, string> m1;
    unordered_map<string, int> m2;
    string word;
    int n1, n2;
    int i;
    
    cin >> n1 >> n2;
    for (i = 1; i <= n1; i++)
    {
        cin >> word;
        m1[i] = word;
        m2[word] = i;
    }
    
    for (i = 0; i < n2; i++)
    {
        cin >> word;
        if (isdigit(word[0]))
            cout << m1[stoi(word)] << "\n";
        else
            cout << m2[word] << "\n";
    }
    
    return 0;
}