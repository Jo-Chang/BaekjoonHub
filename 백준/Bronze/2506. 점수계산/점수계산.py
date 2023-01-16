N = int(input())
problem_score = list(map(int, input().split()))
problem_result = []
# problem_result = [0 for i in range(N)]

accumulate = 0
for i in range(N):
    if problem_score[i] == 1:
        accumulate += 1
        problem_result.append(accumulate)
    else:    # problem_score[i] == 0
        accumulate = 0
        problem_result.append(0)

print(sum(problem_result))