#include <bits/stdc++.h>
#define nmax 1005
#define mmax 1005
#define foi(j,n) for(int i = j; i<=n; i++)
#define foj(i,n) for(int j = i; j<=n; j++)
#define el cout<<"\n"

using namespace std;
int n,k,sum,a[nmax],f[nmax][mmax];
int sub(int x,int y){
	return (x - y + k) % k;
}
void Solve(){
	foi(1,k-1) f[0][i] = 1e9;
	f[0][0] = 0;
	
	foi(1,n)
		foj(0,k-1)
			f[i][j] = min(f[i-1][j],f[i-1][sub(j,a[i]%k)] + 1);
	cout<<n-f[n][sum % k]; el;
	
}
void trace(){
	int i = n,sumAll = 0, t = sum % k;
	while(i > 0){
		if(f[i][t] == f[i-1][t]){
			cout<<"a["<<i<<"] = "<<a[i]; el;
			sumAll += a[i];
		} else {
			t = sub(t,a[i]%k);
		}
		i--;
	}
	cout<<"tong = "<<sumAll;
}
void input(){
	cin >> n >> k;
	sum = 0;
	foi(1,n) {
		cin >> a[i];
		sum += a[i];
	}
}
int main(){
	input();
	Solve();
	trace();
	return 0;
}
