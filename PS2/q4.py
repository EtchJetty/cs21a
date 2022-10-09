# Describe in pseudocode an algorithm that returns the minimum value in a linked list of comparable items. What’s the running time of your algorithm?

listy = [138, 192, 181, 118, 179, 117, 29, 76, 12, 137, 114, 93, 10, 194, 191, 69, 102, 148, 58, 182]
minitem = listy[0]
for i in range(len(listy)):
    if listy[i] < minitem:
        minitem = listy[i]
        
print(minitem)