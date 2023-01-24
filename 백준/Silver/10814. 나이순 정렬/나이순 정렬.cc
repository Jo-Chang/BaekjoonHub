#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <cstdio>

#define fastio ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
using namespace std;

typedef pair<int, string> pis;

int main()
{
	//FILE* stream;
	//freopen_s(&stream, "input_example/10814.txt", "r", stdin);

	fastio
	vector<pis> member_vec;
	int mem_num;

	cin >> mem_num;
	for (int i = 0; i < mem_num; i++)
	{
		int age;
		string name;
		cin >> age >> name;
		member_vec.push_back(pis(age, name));
	}

	stable_sort(member_vec.begin(), member_vec.end(), [](pis a, pis b) {
		return a.first < b.first;
		});

	for (auto member : member_vec)
		cout << member.first << " " << member.second << "\n";

	return 0;
}