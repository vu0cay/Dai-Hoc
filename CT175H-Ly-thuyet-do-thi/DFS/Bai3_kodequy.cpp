#include <bits/stdc++.h>
#define nmax 1005
#define mmax 1005
#define foi(j,n) for(int i = j; i<=n; i++)
#define foj(i,n) for(int j = i; j<=n; j++)
#define el cout<<"\n"

using namespace std;
int n,m,S,F,u,v;
int Trace[nmax],a[nmax][nmax];
bool Free[nmax];

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
		foj(1,n) cout << a[i][j] <<" ";
	el;
	}
}

void DFS(int S){
	stack<int> st;
	st.push(S);
	Free[S] = false;
	while(!st.empty()){
		int u = st.top();
		st.pop();
		for(int v = 1; v<=n; v++){
			if(Free[v] && a[u][v]) {
				cout << v <<" "; Free[v] = false;
				Trace[v] = u;
				st.push(u);
				st.push(v);
				break;
			}
		}
	}
}
void Solve(){
	if(!Trace[F]) {
		cout << "khong co duong di nao tu "<<S<<" den "<<F; 
		el;
	} else{
		while(F != S) {
			if(F != S) cout << F <<"<-";
			F = Trace[F];
		}
		cout << F ; 
	}
	
}
int main(){
	input();
	memset(Free,1,n);
	DFS(S); 
	el;
	Solve();
	return 0;
}
