//https://oj.vnoi.info/problem/qbstr
#include <bits/stdc++.h>
#define nmax 2005
#define mmax 2005
#define foi(j,n) for(int i = j; i<=n; i++)
#define foj(i,n) for(int j = i; j<=n; j++)
#define el cout<<"\n"

using namespace std;

string x,y;
int m,n;
int f[nmax][mmax];
void Solve(int m,int n){
	
	x = '\0' + x; // khoi tao ky tu rong o vi tri 0 de xau bat dau tu 1
	y = '\0' + y;
	foi(0,n){
		foj(0,m){
			if(i == 0 || j == 0) f[i][j] = 0;
			else if(y[i] == x[j]){
				f[i][j] = max(max(f[i][j-1],f[i-1][j-1] + 1),f[i-1][j]);
			} else{
				f[i][j] = max(f[i][j-1],max(f[i-1][j],f[i-1][j-1]));
			}
		}
	}
	//cout<<f[n][m];
}
int truyhoi(int m,int n){
	int i = n;
	int j = m;
	string res="";
	int dem = 0;
	while(i > 0 && j > 0){
		
		if(f[i][j] != f[i-1][j] && f[i][j] != f[i][j-1]) {
			res = x[j] + res;
			i--;
			j--;
		} else if(f[i][j] == f[i][j-1]){
			j--;
			dem++;
		} else {
			i--;
			dem++;
		}
	}

	//cout<<dem;
	//el;
	//cout<<res;
}


}
int main(){
	
	cin >> x >> y;
	m = x.length();
	n = y.length();
	Solve(m,n);
	truyhoi(m,n);
		
	

	return 0;
}
