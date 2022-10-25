# Write a recursive function sort_stack that sorts a given stack in ascending order. Equivalent elements of the stack must retain their original ordering. What is the running time of your algorithm?

from collections import deque


def linked_list_min(stack: deque()):
    lengthy = len(stack)
    if lengthy > 1:
        stack[0]

stack = deque([10, 50, 19, 54, 30, 67])
stack2 = deque([9, 10, 50, 19, 54, 30, 67])
stack3 = deque([1])

print(linked_list_min(stack2))
# sorter(stack2)
