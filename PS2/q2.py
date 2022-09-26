from collections import deque
import queue
q = deque([10, 20, 30, 40, 50, 60, 70, 80, 90])

k = 4
stack = deque()
for i in range(k):
    stack.append(q.popleft())
    
# stack2 = deque()
# for i in range(len(stack)):
#     stack2.append(stack.pop())
    
h = len(q)    
for i in range(len(stack)):
    q.append(stack.pop())

for i in range(h):
    q.append(q.popleft())

print(q)