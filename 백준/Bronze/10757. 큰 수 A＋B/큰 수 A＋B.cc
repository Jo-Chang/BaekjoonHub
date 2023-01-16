#include <iostream>
#include <string>

using namespace std;

int main()
{
    string A, B;
    string result = "";
    int flag = 0, big_len;
    int a_len, b_len;
    
    cin >> A >> B;
    
    a_len = A.size();
    b_len = B.size();
    
    // cout << "A : " << A << endl << "B : " << B << endl;
    // cout << "A.size() : " << a_len << ", B.size() : " << b_len << endl;
    
    if (a_len > b_len)
    {
        big_len = a_len;
        for(int i = 0; i < a_len - b_len; i++)
            B = "0" + B;
    }
    else
    {
        big_len = b_len;
        for(int i = 0; i < b_len - a_len; i++)
            A = "0" + A;
    }
    
    // cout << "A : " << A << endl << "B : " << B;
    
    for (int i = big_len - 1; i >= 0; i--)
    {
        int a = A[i] - '0';
        int b = B[i] - '0';
        
        if (flag)
        {
            flag = 0;
            a++;
        }
        
        result = "0" + result;
        result[0] = (a + b) % 10 + '0';
        flag = (a + b) / 10;
    }
    if (flag)
        result = "1" + result;
    
    cout << result;
    
    return 0;
}