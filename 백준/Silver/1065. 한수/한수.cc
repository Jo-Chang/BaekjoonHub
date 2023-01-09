#include <iostream>
#include <vector>

using namespace std;

void hansu(vector<int> &v);
int hansu_count(vector<int> v, int n);

int main()
{
    vector<int> v(1000, 0);
    int n;
    
    cin >> n;
    hansu(v);
    cout << hansu_count(v, n);
    
    return 0;
}

void hansu(vector<int> &v)
{
    vector<int> digit;
    int diff;
    int flag, temp;
    
    // 1 ~ 99 까지는 한수
    for (int i = 0; i < 99; i++)
        v[i] = 1;
    // 100 부터 계산
    for (int i = 99; i < 1000; i++)
    {
        flag = 1;
        temp = i + 1;
        while (temp > 0)
        {
            digit.insert(digit.begin(), temp % 10);
            temp /= 10;
        }
        
        // 자릿수 차이 계산
        vector<int>::iterator iter = digit.begin();
        diff = *iter - *(iter + 1);
        for (iter = digit.begin() + 2; iter != digit.end(); iter++)
        {
            if (*(iter - 1) - *iter != diff)
            {
                flag = 0;
                break;
            }
        }
        
        if(flag)
            v[i] = 1;
            
        digit.clear();
    }
}

int hansu_count(vector<int> v, int n)
{
    int count = 0;
    
    for (int i = 0; i < n; i++)
        if (v[i] == 1)
            count++;
            
    return count;
}