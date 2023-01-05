#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main()
{
    vector<int> v;
    vector<double> v2;
    int n, num, max;
    double average = 0;
    
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> num;
        v.push_back(num);
    }
    
    max = *max_element(v.begin(), v.end());
    
    for (int i = 0; i < n; i++)
        v2.push_back((double)v[i] / max * 100);
    
    for (int i = 0; i < n; i++)
        average += v2[i];
        
    cout << average / n;
    
    return 0;
}