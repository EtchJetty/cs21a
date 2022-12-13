def mergeSort(A, p, r, x):
    print(x, "occurences of mergesort", p, r, ":", A[p:r])
    x = x + 1
    if p < r:
        q = int((p+r)/2)
        mergeSort(A, p, q, x)
        mergeSort(A, q+1, r, x)
        merge(A, p, q, r)
    return x


def merge(A, p, q, r):
    print("merge now lol")


A = [2, 5, 16, 4, 10, 23, 39, 18, 26, 15]

mergeSort(A, 0, len(A), 0)
