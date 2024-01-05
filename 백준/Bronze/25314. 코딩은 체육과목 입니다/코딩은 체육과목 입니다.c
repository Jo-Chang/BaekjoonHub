#include <stdio.h>

int main(void) {
    int N;
    
    scanf("%d", &N);
    
    for (int i = 0; i < N / 4; i++) {
        printf("long ");
    }
    printf("int");
    
    return 0;
}