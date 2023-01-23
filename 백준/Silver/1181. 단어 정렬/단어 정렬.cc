#include <iostream>
#include <string>
#include <set>
#include <algorithm>
#include <cstdio>

#define fastio ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
using namespace std;


struct SortLen {
	bool operator() (const string& a, const string& b) const{
		if (a.size() == b.size())
			return a < b;
		return a.size() < b.size();
	}
};

void print_set(set<string, SortLen>);

int main()
{
	//FILE* stream;
	//freopen_s(&stream, "input_example/1181.txt", "r", stdin);

	fastio
	set <string, SortLen> words_set;
	int num_words;

	cin >> num_words;
	for (int idx = 0; idx < num_words; idx++)
	{
		string word;
		cin >> word;
		words_set.insert(word);
	}

	print_set(words_set);

	return 0;
}

void print_set(set<string, SortLen> s)
{
	for (auto str : s)
		cout << str << "\n";
}