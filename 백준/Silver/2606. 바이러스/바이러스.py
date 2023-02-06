import sys


VIRUS_ROOT = 1  # 1번 컴퓨터 바이러스

# input vertex, edge
vertex_num = int(sys.stdin.readline())
edge_num = int(sys.stdin.readline())

# make grpah
graph_lst = [[] for _ in range(vertex_num + 1)]

# input edge information
for _ in range(edge_num):
    edge1, edge2 = map(int, sys.stdin.readline().split())
    graph_lst[edge1].append(edge2)
    graph_lst[edge2].append(edge1)
    

# solution
def get_infected_num(graph_, n):
    lst_ = []
    visited = [False]  * len(graph_)
    
    # dfs
    lst_.append(n)
    
    while lst_:
        cur = lst_.pop()
        visited[cur] = True
        
        # adjacent vertex
        for adj in graph_[cur]:
            if not visited[adj]:
                lst_.append(adj)
    
    return len([mem for mem in visited if mem]) - 1


# print
print(get_infected_num(graph_lst, VIRUS_ROOT))