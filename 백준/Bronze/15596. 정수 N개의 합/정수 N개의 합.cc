#include <vector>

long long sum(std::vector<int> &a) {
	long long ans = 0;
    
    for (std::vector<int>::iterator iter = a.begin(); iter != a.end(); iter++)
        ans += *iter;
    
	return ans;
}
