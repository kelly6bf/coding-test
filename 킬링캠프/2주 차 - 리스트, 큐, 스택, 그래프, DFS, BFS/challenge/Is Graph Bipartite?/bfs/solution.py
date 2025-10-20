from collections import deque

class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        visited = [False for _ in graph]
        node_color = [None for _ in graph]
        
        for start in range(len(visited)):
            if visited[start]:
                continue

            if not self.bfs(graph, visited, node_color, start):
                return False
        
        return True

    def bfs(self, graph, visited, node_color, start):
        dq = deque()
        dq.append([start, 'red'])
        visited[start] = True
        node_color[start] = 'red'

        while dq:
            current_node = dq.popleft()
            next_node_color = 'black' if current_node[1] == 'red' else 'red'
            for next in graph[current_node[0]]:
                if visited[next]:
                    if node_color[next] != next_node_color:
                        return False
                    else:
                        continue

                dq.append([next, next_node_color])
                visited[next] = True
                node_color[next] = next_node_color
        
        return True
