list_score = []
for i in range(5):
    score = int(input())
    if score < 40:
        score = 40
    list_score.append(score)
print(sum(list_score) // len(list_score))