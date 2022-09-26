def bar(a,n):
    k = n
    b = 1
    c = a
    while k > 0:
        if (k%2==0):
            k=k/2
            c=c*c
        else:
            k=k-1
            b=b*c
    return b

print(bar(5,2))