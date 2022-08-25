import sys

arrList=[]
visited=[False]* 9

for _ in range(9):
    tmp=int(sys.stdin.readline())
    arrList.append(tmp)
arrList.sort()
result=[]

def dfs(depth,sum,arrList):
    if depth==7:
        if sum==100:
            for re in result:
                print(re)
            exit(0)
    else:
        for i in range(0,len(arrList)):
            if not visited[i]:
                visited[i]=True
                result.append(arrList[i])
                dfs(depth+1,sum+arrList[i],arrList)
                visited[i]=False
                result.pop()
dfs(0,0,arrList)