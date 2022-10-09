# Describe in pseudocode an algorithm that implements the bubble-sort algorithm by using only two stacks and, at most, five additional variables to sort a collection of elements stored initially in one of the stacks. You may operate on the stacks using only the stack operations. The final output should be one of the stacks containing all the elements so that a sequence of pop operations would list the elements in order. What’s the running time of your algorithm?
from collections import deque

# stack.pop()
# stack.append()
stack = deque([138, 192, 181, 118, 179, 117, 29, 76, 12, 137, 114, 93, 10, 194, 191, 69, 102, 148, 58, 182])
stack = deque(list(reversed(range(20))))
stack2 = deque()

# for zed in range(len(stack)):
#     for i in range(len(stack)-1):
#         a = stack.pop()
#         b = stack.pop()
#         if a > b:
#             stack2.append(b)
#             stack.append(a)
#         else:  
#             stack2.append(a)
#             stack.append(b)
#     for i in range(len(stack2)-1):
#         a = stack2.pop()
#         b = stack2.pop()
#         if a > b:
#             stack.append(b)
#             stack2.append(a)
#         else:  
#             stack.append(a)
total = 0
for i in range(len(stack)):
    counter = 0
    total += 1
    while len(stack) > 1:
        a = stack.pop()
        b = stack.pop()
        if a > b:
            stack2.append(a)
            stack.append(b)
        else:
            stack2.append(b)
            stack.append(a)
            counter = counter + 1

            
    while stack2:
        stack.append(stack2.pop())    
    if counter == 0:
        break
        
        
print(stack,stack2)
print(total)