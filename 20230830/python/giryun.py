def solution(sticker):
    n = len(sticker)
    if n == 1: return sticker[0]
    
    d1 = [0] * n # d1은 맨 앞 뜯는 경우
    d2 = [0] * n # d2는 맨 앞 뜯지 않는 경우
    
    d1[0] = sticker[0]
    d1[1] = d1[0]
    for i in range(2, n - 1): d1[i] = max(d1[i - 2] + sticker[i], d1[i - 1])
    for i in range(1, n): d2[i] = max(d2[i - 2] + sticker[i], d2[i - 1])
    
    return max(d1[-2], d2[-1])
