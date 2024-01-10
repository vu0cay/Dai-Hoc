#include <bits/stdc++.h>
#define nmax 1005
#define mmax 1005
#define foi(j,n) for(int i = j; i<=n; i++)
#define foj(i,n) for(int j = i; j<=n; j++)
#define fov(j,n) for(int i = j; i<=n; i++)
#define el cout<<"\n"

using namespace std;
int n,m,S,F,a[nmax][nmax],Free[nmax],Trace[nmax];
int u,v;


void input(){
	freopen("GRAPH.INP","r",stdin);	
	cin >> n >> m >> S >> F;
	memset(a,0,n*n);
	
	foi(1,m){
		cin >> u >> v;
		a[u][v] = 1;
		a[v][u] = 1;
	}
	
	foi(1,n){
		foj(1,n){
			cout << a[i][j] <<" ";
		}
		el;
	}

}
// Ham se tra ve dinh v gan nhat va chua duoc dinh u duyet qua, neu ko co = 0
int Findnext(int u){
	while(u != n+1){ // khoi tao Trace[S] luon = n+1;
		for(int v = 1; v<=n; v++) {
			if(Free[v] && a[u][v]){ // neu dinh v la dinh ke u va chua duyet			
				Trace[v] = u; // Luu vet	
				return v;
			}
		}
		u = Trace[u];
	}
	return 0; // khi u == n+1 tuc la duyet het ma ko tim thay canh ke u
}
void result(int S){
	Trace[S] = n+1;
	int u = S;
	while(u != 0){
		cout << u <<" ";
		Free[u] = 0;
		u = Findnext(u);
	}
	
}
void Solve(int F){
	int v = F;
	while(v != S){
		cout << v <<"<-";
		v = Trace[v];
	}
	cout << v;
}
int main(){
	input();
	foi(1,n) Free[i] = 1;
	result(S);
	el;
	Solve(F);
	return 0;
}
