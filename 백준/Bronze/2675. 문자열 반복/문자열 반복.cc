#include <iostream>
#include <string>

using namespace std;

int main()
{
    int t, r;
    string s, result = "";
    
    cin >> t;
    for (int i = 1; i <= t; i++)
    {
        cin >> r >> s;
        
        for (int j = 0; j < s.size(); j++)
            for (int k = 0; k < r; k++)
                result += s[j];
                
        cout << result << endl;
        result.clear();
    }
    
    return 0;
}