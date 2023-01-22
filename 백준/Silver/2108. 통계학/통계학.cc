#include <iostream>
#include <algorithm> // sort()
#include <numeric>  // accumulate()
#include <cmath>    // round()
#include <map>
#include <vector>
#include <set>


using namespace std;

#define fastio ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

int get_mean(vector<int>);
int get_median(vector<int>);
int get_frequent(vector<int>);
int get_range(vector<int>);
int print_vector(vector<int>);

int main()
{
    fastio
    vector<int> v;
    int N;
    
    cin >> N;
    for (int i_num = 1; i_num <= N; i_num++)
    {
        int num;
        cin >> num;
        v.push_back(num);
    }
    
    sort(v.begin(), v.end());
    
    cout << get_mean(v) << "\n";
    cout << get_median(v) << "\n";
    cout << get_frequent(v) << "\n";
    cout << get_range(v) << "\n";
    
    return 0;
}


int get_mean(vector<int> v)
{
    return round((double)accumulate(v.begin(), v.end(), 0) / (int)v.size());
}

int get_median(vector<int> v)
{
    return (v[(int)v.size() / 2]);
}

int get_frequent(vector<int> v)
{
    map<int, int> m;
    set<int> max_set;
    set<int>::iterator result;
    int max;
    
    for (vector<int>::iterator it = v.begin(); it != v.end(); it++)
        m[*it]++;
    
    map<int, int>::iterator iter = m.begin();
    max = iter->second;
    max_set.insert(iter->first);
    for (iter++; iter != m.end(); iter++)
    {
        if (iter->second > max)
        {
            max_set.clear();
            max_set.insert(iter->first);
            max = iter->second;
        }
        else if (iter->second == max)
            max_set.insert(iter->first);
    }
    
    result = max_set.begin();
    if (max_set.size() > 1)
        result++;
    return *result;
}

int get_range(vector<int> v)
{
    return (*v.rbegin() - *v.begin());
}

int print_vector(vector<int> v)
{
    if (v.size() == 0)
        return -1;
        
    cout << "print set : ";
    for (vector<int>::iterator it = v.begin(); it != v.end(); it++)
    {
        cout << *it << " ";
    }
    cout << "\n";
    
    return 0;
}