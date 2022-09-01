import itertools as it
if __name__ == '__main__':

    n, m = map(int, input().split())
    data = list(map(int, input().split()))

    data.sort()

    for x in it.combinations(data, m):
        for a in x:
            print(a, end= ' ')
        print()
