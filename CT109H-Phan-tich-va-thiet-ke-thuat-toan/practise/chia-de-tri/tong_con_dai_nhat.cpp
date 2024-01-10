#include <iostream>
#include <vector>
#include <math.h>
using namespace std;
int A[100005];
int n;


int maxSum(int i, int j) {
    //1. Ki?m tra i == j
    if (i == j)
        return A[i];  //D�y ch? c� 1 ph?n t?, tr? v? ph?n t? A[i]
    
    //T�nh ti?p, s? c� 3 phuong �n: left, right v� xuy�n qua di?m c?t (middle)
    //2. T�m v? tr� c?t
    int m = (i + j) / 2;
    
    //3. G?i d? quy t�m l?i gi?i b�n tr�i: t? i d?n m
    int left = maxSum(i, m);

    //4. G?i d? quy t�m l?i gi?i b�n ph?i: t? m+1 d?n j
    int right = maxSum(m + 1, j);

    //5. T�m t?ng c?a d�y l?n nh?t di xuy�n qua di?m c?t
    //max_left l� t?ng d�y l?n nh?t k?t th�c t?i A[m]
    //max_right l� t?ng d�y l?n nh?t b?t d?u t?i A[m + 1]
    int max_left = -10000005, max_right = -10000005;
    int sum1 = 0, sum2 = 0;
    for(int k = m; k>=i; k--) 
    {
        sum1 += A[k];
        if(sum1 >= max_left) max_left = sum1;
    }

    for(int k = m + 1; k <= j; k++) 
    {
        sum2 += A[k];
        if(sum2 >= max_right) max_right = sum2;
    }

    int middle = max_left + max_right;
    
    //6. Tr? v? phuong �n t?t nh?t
    return max(max(left, right), middle);
}
int main()
{
	cin >> n;

	for(int i = 0; i<n; i++) 
	{
		cin>>A[i];
	}
//	for(int i = 0; i<n; i++) 
//		cout << A[i];
	cout << maxSum(0,n-1);
	return 0;
}
