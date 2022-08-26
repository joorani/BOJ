
E, S, M = map(int, input().split())
a, b, c = 1, 1, 1
year = 1
while True:
    if a == E and b == S and c == M:
        print(year)
        break
    else:
        if a == 15:
            a  = 1
        else:
            a += 1
        if b == 28:
            b = 1
        else:
            b+= 1
        
        if c == 19:
            c = 1
        else:
            c+= 1
            
        year += 1
