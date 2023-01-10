#include <iostream>
#include <string>
#include <vector>

using namespace std;

void array_init(vector<int> &vec);
void upper_string(string &str);
void count_alphabet(vector<int> &vec, string str);
void print_maxcount(vector<int> vec);

int main()
{
    vector<int> vec;
    string str;
    
    cin >> str;
    
    array_init(vec);
    upper_string(str);
    count_alphabet(vec, str);
    print_maxcount(vec);
}

void array_init(vector<int> &vec)
{
    for (char ch = 'A'; ch <= 'Z'; ch++)
        vec.push_back(0);
}

void upper_string(string &str)
{
    for (int i = 0; i < str.size(); i++)
        if ('a' <= str[i] && str[i] <= 'z')
            str[i] += 'A' - 'a';
}

void count_alphabet(vector<int> &vec, string str)
{
    for (int i = 0; i < str.size(); i++)
        vec[str[i] - 'A']++;
}

void print_maxcount(vector<int> vec)
{
    int max_index = 0;
    int flag_same = 1;
    
    
    for (char ch = 'B'; ch <= 'Z'; ch++)
    {
        if (vec[ch - 'A'] > vec[max_index])
        {
            max_index = ch - 'A';
            flag_same = 1;
        }
        else if (vec[ch - 'A'] == vec[max_index])
            flag_same = 0;
    }
    if (flag_same == 1)
        cout << char(max_index + 'A');
    else
        cout << "?";
}