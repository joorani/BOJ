for _ in range(3):
    a = list(map(int, input().split()))
    front = a.count(0)
    back = a.count(1)

    if front == 1 and back == 3:
        print('A')
    elif front == 2 and back == 2:
        print('B')
    elif front == 3 and back == 1:
        print('C')
    elif front == 4:
        print('D')
    elif back == 4:
        print('E')
