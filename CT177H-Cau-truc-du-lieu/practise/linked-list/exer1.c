#include <stdio.h>
#include "alistlib.h"
#include "binsearch.h"
#include "bubbleSort.h"
//#include "selection_sort.h"
//#include "insertion_sort.h"
//#include "Shellsort.h"
int main(){

    int n;
    scanf("%d",&n);
    int i,x;
    List L;
    makeNull(&L);
    for(i = 0; i<n; i++) {
        scanf("%d",&x);
        append(x,&L);
    }

    print(L);
    bubbleSort(&L);
    print(L);
    printf("%d ",binSearch(54,L));
    //selectionSort(L.elements,L.size);
    //insertionSort(L.elements,L.size);
    //shellSort(L.elements,L.size);
    //print(L);
    return 0;

}