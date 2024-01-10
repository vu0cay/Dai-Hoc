/*
https://oj.vnoi.info/problem/atcoder_dp_d
*/
#include <bits/stdc++.h>

using namespace std;
int n, W;
long long V[105][100005],w[105],p[105];
void Solve(){
	

	for(int i = 0; i<=n; i++){
		for(int j = 0; j<=W; j++){
			if(i == 0 || j == 0) V[i][j] = 0;
			else
			if(j<w[i]) V[i][j] = V[i-1][j];
			else V[i][j] = max(V[i-1][j],V[i-1][j-w[i]] + p[i]);
		}
	} 
	cout<<V[n][W];

}
int main(){
	
	
	cin>>n>>W;
	for(int i = 1; i<=n; i++) cin>>w[i]>>p[i];
	
	Solve();
	
	return 0;
}

