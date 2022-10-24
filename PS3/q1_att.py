# Write a recursive function sort_stack that sorts a given stack in ascending order. Equivalent elements of the stack must retain their original ordering. What is the running time of your algorithm?

from collections import deque


def sorter(stack):
    # # recent = stack.pop()
    # if (recent != None):  # work this out later - basically just a check if next exists
    #     sorted = deque([])

    testval = True
    while (stack):
        # print(recent)
        newNode = stack.pop()
        recent = stack.pop()

        if (recent <= newNode):
            print(recent, newNode, "bigger")
            sorted.append(newNode)
            sorted.append(recent)
            # recent = newNode
        else:
            print(recent, newNode, "smaller")
            sorted.append(recent)
            sorted.append(newNode)

           
            testval = False
            
        if not stack:
            sorted.append(recent)
            
        print(sorted)
    if not testval:
        sorter(sorted)
    return stack

stack = deque([10, 50, 19, 54, 30, 67])

sorter(stack)
