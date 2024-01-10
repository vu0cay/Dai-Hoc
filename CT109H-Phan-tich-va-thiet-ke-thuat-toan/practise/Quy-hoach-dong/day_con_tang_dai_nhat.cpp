//https://oj.vnoi.info/problem/lis
//https://www.youtube.com/watch?v=c_rC98LWCZw
#include <bits/stdc++.h>
using namespace std;


void Solve2(vector<long int> a,int n){
	long int f[n+1];
	int t = 1;
	f[1] = a[1];
	for(int i = 2; i<=n; i++){
		
		if(a[i] > f[t]) {
			t++;
			f[t] = a[i];
		}
		else if(a[i] <= f[1]) f[1] = a[i];
		else{
			int l = 1, r = t,mid;
			while(r-l>1){
				mid = (l+r)/2;
				if(a[i] > f[mid]) l = mid;
				else r = mid;
			}
			f[r] = a[i];
 		}
	}
	cout<<t;
	//for(int i = 1; i<=t; i++) cout<<f[i]<<" ";
	
}

int main(){
    int n; cin>>n;
    vector<long int> a(n+1);
    for(int i = 1; i<=n; i++) cin>>a[i];
    
    Solve2(a,n);

    
 return 0;   
}
