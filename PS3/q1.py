# Write a recursive function sort_stack that sorts a given stack in ascending order. Equivalent elements of the stack must retain their original ordering. What is the running time of your algorithm?

from collections import deque


def sorter(stack: deque):
    print(stack)

    lengthy = len(stack)
    sorted = deque()
    isSorted = True
    testval1 = stack.pop()
    for i in (range((lengthy - 1))):
        testval2 = stack.pop()

        print(i, testval1)
        print(i, testval2)
        if testval1 <= testval2:
            sorted.append(testval2)
            # sorted.append(testval1)
            isSorted = False
            print("bigger")
        else:
            sorted.append(testval1)
            # sorted.append(testval2)
            print("smaller")
            testval1 = testval2

    sorted.append(testval1)
    print(sorted)
    if not isSorted:
        sorted2 = deque([])
        for i in (range((lengthy))):
            sorted2.append(sorted.pop())
        sorter(sorted2)
    return stack


stack = deque([10, 50, 19, 54, 30, 67])
stack2 = deque([9, 10, 50, 19, 54, 30, 67])

sorter(stack)
sorter(stack2)
