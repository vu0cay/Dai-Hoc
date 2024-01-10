#include <bits/stdc++.h>
#define nmax 100
#define mmax 100
#define foi(j,n) for(int i = j; i<=n; i++)
#define foj(i,n) for(int j = i; j<=n; j++)
#define el cout<<"\n"

using namespace std;
int L[mmax][nmax],B[mmax][nmax];
/*
MCABDYE
MBADE
*/
void Solve(string x,string y){
	
	int m = x.length();
	int n = y.length();
	
	x = '\0' + x; // khoi tao cho cac ky tu chuoi x,y bat dau tu vi tri thu 1
	y = '\0' + y;
	// PHEP XOA B = 1
	// PHEP CHEN B = 3;
	// PHEP THAY THE B =2;
	foi(1,m) {
		L[i][0] = i;
		B[i][0] = 1; 
	}
	foj(0,n) {
		L[0][j] = j;
		B[0][j] = 3;
	}
	
	foi(1,m){
		foj(1,n){
			if(x[i] == y[j]){
				L[i][j] = L[i-1][j-1];
				B[i][j] = 0;
			} else {
				int Lmin = min(min(L[i-1][j],L[i][j-1]),L[i-1][j-1]);
				L[i][j] = Lmin +1;
				if(Lmin == L[i-1][j]) {
					B[i][j] = 1;
				} else if(Lmin == L[i][j-1]) B[i][j] = 3;
				else B[i][j] = 2;
			}
		}
	}
	foi(0,m){
		foj(0,n){
			cout<<L[i][j]<<", "<<B[i][j]<<"| "; 
		}
		el;
	}
	
	cout<<L[m][n];
	el;
	int i = m;
	int j = n;
	string res = x;
	while(i >= 0 || j>= 0){
		if(x[i] == y[j]) { // x[i] = y[j] tuc khong thay doi 
			i--;
			j--; // truy theo tay bac	
		}
		else {
			if(B[i][j] == 1){ // la phep xoa
				res.erase(res.begin() + i);
				cout<<"xoa "<<x[i]<<"-> "<<res; 
				i-=1; // duyen len bac
			} else if(B[i][j] == 2){ // phep thay the
				res[i] = y[j];
				cout<<"thay the "<<x[i]<<"bang "<<y[j]<<"-> "<<res;
				i-=1; // duyet huong tay bac
				j-=1;
			} else if(B[i][j] == 3){ // phep chen
				res.insert(res.begin()+i+1,y[j]);
				cout<<"chen "<<y[j]<<"-> "<<res;
				j-=1; // duyet huong tay
			}
			el;
		}
		
	}
}
int main(){
	string x,y;
	cin >> x >> y;
	Solve(x,y);	
	
	return 0;
}
