taebo_input = input()

face_index = taebo_input.find("(^0^)")
left_num = 0
right_num = 0

for index in range(face_index):
    if taebo_input[index] == "@":
        left_num += 1
        
for index in range(face_index, len(taebo_input)):
    if taebo_input[index] == "@":
        right_num += 1

print(left_num, right_num)