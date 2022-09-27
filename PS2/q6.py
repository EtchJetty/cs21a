# Q6. Describe in pseudocode an algorithm that given an integer n and a linked list of elements increases
# the linked list by a factor of n by replacing each element in the original list with n copies of that element.
# For example, if L: [18, 7, 4, 24, 11] and n = 3 the resulting list should be L: [18, 18, 18, 7, 7, 7, 4, 4, 4, 24,
# 24, 24, 11, 11, 11]. If the value of n is less than or equal to 0, the list should be empty after the call.
# What’s the running time of your algorithm?

from collections import deque
L = deque([18, 7, 4, 24, 11])
n = 3
leng = len(L)
for i in range(leng):
    for z in range(n):
        print((i),L[i])
    # a = L[i*2]
    # L[i*2] = L[(i*2)+1]
    # L[(i*2)+1] = a
    
print(L)