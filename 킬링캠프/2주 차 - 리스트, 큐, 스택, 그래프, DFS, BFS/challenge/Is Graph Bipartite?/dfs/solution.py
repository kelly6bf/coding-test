class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        visited = [False for _ in graph]
        node_color = [None for _ in graph]

        for start in range(len(graph)):
            if visited[start]:
                continue

            if not self.dfs(graph, visited, node_color, [start, 'red']):
                return False
        
        return True

    def dfs(self, graph, visited, node_color, current):
        visited[current[0]] = True
        node_color[current[0]] = current[1]

        next_color = 'black' if current[1] == 'red' else 'red'
        for next in graph[current[0]]:
            if visited[next]:
                if node_color[next] != next_color:
                    return False
                else:
                    continue
            
            if not self.dfs(graph, visited, node_color, [next, next_color]):
                return False
        
        return True
