# Describe in pseudocode an algorithm that given a stack of elements replaces the stack content with itself plus a mirrored version of itself. For example, given the stack S: [10, 50, 19, 54, 30, 67] the resulting stack should be S: [10, 50, 19, 54, 30, 67, 67, 30, 54, 19, 50, 10].
# You may use one stack or one queue (but not both) as auxiliary storage to solve this problem. Your algorithm should run in O(n) time.

from collections import deque
queue = deque()

stack = deque([10, 50, 19, 54, 30, 67])

# stack.pop()
# stack.append()
# queue.pop()
# queue.appendleft()

# n = len(stack)

for x in range(len(stack)):
    queue.appendleft(stack.pop())

for x in range(len(stack)):
    temp = queue.pop()
    stack.append(temp)
    queue.appendleft(temp)

for x in range(len(queue)):
    temp = queue.pop()
    stack.append(temp)
    queue.appendleft(temp)

for x in range(len(stack)):
    queue.appendleft(stack.pop())
    
for x in range(len(queue)//2):
    queue.appendleft(queue.pop())

for x in range(len(queue)):
    stack.append(queue.pop())
    

print("queue:", queue)
print("---")
print("stack:", stack)
