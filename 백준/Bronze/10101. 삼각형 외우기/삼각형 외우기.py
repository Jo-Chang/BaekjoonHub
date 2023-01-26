import sys

def get_triangle(lst_):
    if sum(lst_) != 180:
        return "Error"
    else:
        for mem in lst_:
            if lst_.count(mem) == 3:
                return "Equilateral"
            elif lst_.count(mem) == 2:
                return "Isosceles"
        return "Scalene"
    
degree_lst = []
for i in range(3):
    degree_lst.append(int(sys.stdin.readline()))
    
print(get_triangle(degree_lst))