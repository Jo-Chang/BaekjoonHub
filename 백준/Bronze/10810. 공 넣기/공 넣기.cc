#include <iostream>

using namespace std;

int main(void) {
    int N, M;
    int arr[101] = { 0 };
    
    cin >> N >> M;
    
    for (int i = 0; i < M; i++) {
        int s, e, num;
        cin >> s >> e >> num;
        for (int j = s; j <= e; j++) arr[j] = num;
    }
    
    for (int i = 1; i <= N; i++) {
        cout << arr[i] << " ";
    }
    
    return 0;
}