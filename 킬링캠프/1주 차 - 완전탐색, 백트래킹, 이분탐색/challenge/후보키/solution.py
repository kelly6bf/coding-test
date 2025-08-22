def solution(relation):
    candidate_keys = []
    row_count = len(relation)
    col_count = len(relation[0])

    for i in range(1, col_count + 1):
        combis = []
        get_combis(col_count, combis, i, 0, [])
        
        for combi in combis:
            is_minimality = True
            for candi in candidate_keys:
                if (set(candi).issubset(set(combi))):
                    is_minimality = False
                    break
            
            if (not is_minimality):
                continue
            
            row_set = set()
            for row in relation:
                row_str = ""
                for key in combi:
                    row_str += row[key] + " "
                row_set.add(row_str)
            
            if (len(row_set) == row_count):
                candidate_keys.append(combi)
    
    return len(candidate_keys)

def get_combis(col_count, combis, max, start, temp):
    if (len(temp) == max):
        combis.append(temp[:])
        return

    for key in range(start, col_count):
        temp.append(key)
        get_combis(col_count, combis, max, key + 1, temp)
        temp.pop()
