# Describe in pseudocode an algorithm that switches the order of elements in a linked list in a pairwise fashion. Your algorithm should switch the order of the first two values, then switch the order of the next two, switch the order of the next two, and so on. For example, if the list initially stores these values L: [3, 7, 4, 9, 8, 12]. Your method should switch the first pair (3, 7), the second pair (4, 9), the third pair (8, 12), etc. to yield this list L: [7, 3, 9, 4, 12, 8]. If there are an odd number of values, the final element is not moved. For example, if the list had been L: [3, 7, 4, 9, 8, 12, 2]. It would again switch pairs of values, but the final value (2) would not be moved, yielding this list. L: [7, 3, 9, 4, 12, 8, 2]. You must solve this problem by rearranging the links of the list. What’s the running time of your algorithm?


from collections import deque
L = deque([3, 7, 4, 9, 8, 12])

for i in range(len(L)//2):
    a = L[i*2]
    L[i*2] = L[(i*2)+1]
    L[(i*2)+1] = a
    
print(L)