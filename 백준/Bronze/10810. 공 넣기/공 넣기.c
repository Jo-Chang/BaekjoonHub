#include <stdio.h>

int main(void) {
    int N, M;
    int arr[101] = { 0 };
    
    scanf("%d%d", &N, &M);
    
    for (int i = 0; i < M; i++) {
        int s, e, num;
        scanf("%d%d%d", &s, &e, &num);
        for (int j = s; j <= e; j++) arr[j] = num;
    }
    
    for (int i = 1; i <= N; i++) {
        printf("%d ", arr[i]);
    }
    
    return 0;
}