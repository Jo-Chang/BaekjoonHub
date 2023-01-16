N = int(input())

cute = 0
for i in range(N):
    if int(input()) == 1:
        cute += 1
            
if cute <= N // 2:
    print("Junhee is not cute!")
else:
    print("Junhee is cute!")