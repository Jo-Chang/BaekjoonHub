#include<iostream>
#include<vector>

using namespace std;

int main()
{
    vector<int> v;
    int C;
    int N, score;
    double average, over;
    
    cin >> C;
    for (int i = 0; i < C; i++)
    {
        average = 0;
        over = 0;
        cin >> N;
        for (int j = 0; j < N; j++)
        {
            cin >> score;
            v.push_back(score);
            average += score;
        }
        average /= N;
        for (int j = 0; j < N; j++)
        {
            if ((double)v[j] > average)
                over++;
        }
        
        cout << fixed;
        cout.precision(3);
        cout << over / N * 100 << "%" << endl;
        
        v.clear();
    }
    
    return 0;
}