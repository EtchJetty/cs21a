import collections
class queue(collections.deque):
    def push(self, a):
        self.appendleft(a)
class mylist(collections.UserList):
    def push(self, a):
        self.append(a)
def amber(S):
    Q = queue()
    n = len(S)
    for i in range(n):
        Q.push(S.pop())
    for i in range(n):
        S.push(Q.pop())
    for i in range(n):
        Q.push(S.pop())
    for i in range(n):
        a = Q.pop()
        S.push(a)
        Q.push(a)
    for i in range(n):
        S.push(Q.pop())
    for i in range(n):
        Q.push(S.pop())
    for i in range(n):
        S.push(Q.pop())
    return S

a = mylist(range(10))
print(a)
print(amber(a))