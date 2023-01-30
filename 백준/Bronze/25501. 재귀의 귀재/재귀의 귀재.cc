#include <iostream>
#include <cstring>

using namespace std;

#define fastio ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);


int cnt_recursion = 0;

bool is_palindrome(const char*);
bool recursion(const char*, int, int);
int main()
{
    fastio;
    char string_input[1001];
    int T, cnt;
    
    cin >> T;
    for (int i = 0; i < T; i++)
    {
        cnt_recursion = 0;
        cin >> string_input;
        cout << is_palindrome(string_input) << " " << cnt_recursion << "\n";
    }
    
    return 0;
}

bool is_palindrome(const char *s)
{
    return recursion(s, 0, strlen(s) - 1);
}

bool recursion(const char *s, int left, int right)
{
    cnt_recursion++;
    if (left >= right) return true;
    else if (s[left] != s[right]) return false;
    else return recursion(s, left + 1, right - 1);
}