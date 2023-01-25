#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

#define fastio ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);


int main()
{
	fastio;
	// file read
	// FILE* stream;
	// freopen_s(&stream, "input_example/18870.txt", "r", stdin);

	vector<int> origin_vec, set_vec;
	int n_num, temp_num;

	// input
	cin >> n_num;
	for (int idx = 0; idx < n_num; idx++)
	{
		cin >> temp_num;
		origin_vec.push_back(temp_num);
		set_vec.push_back(temp_num);
	}

	// sort and remove duplicate in {set_vec}
	sort(set_vec.begin(), set_vec.end());
	set_vec.erase(unique(set_vec.begin(), set_vec.end()), set_vec.end());

	// print
	for (auto mem : origin_vec)
		cout << lower_bound(set_vec.begin(), set_vec.end(), mem) - set_vec.begin() << " ";

	return 0;
}