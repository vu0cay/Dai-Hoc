#include <iostream>
#include <vector>
using namespace std;
typedef vector<int> Number;

void naive_mul(Number x, Number y, Number& res)
{
	for(int i = 0; i<x.size(); i++)
	{
		for(int j = 0; j<y.size(); j++)
		{
			res[i+j] += x[i]*y[j];
		}
	}
}

void multiply(Number x, Number y, Number& res)
{
	int len = x.size();
	res.resize(len*2);
	if(len <= 64) {
		//res[0] = x[0]*y[0];
		naive_mul(x,y,res);
		return;
	}
	int k = len/2;
	Number a(x.begin() + k, x.end());
	Number b(x.begin(), x.begin()+k);
	Number c(y.begin() + k, y.end());
	Number d(y.begin(), y.begin()+k);
	
	Number ac,bd;
	multiply(a,c,ac); // 1
	multiply(b,d,bd); // 2
	
	Number a_b(k),c_d(k);
	for(int i = 0; i<k; i++) 
	{
		a_b[i] = a[i]+b[i];
		c_d[i] = c[i]+d[i];
	}
	
	Number ab_cd; multiply(a_b,c_d,ab_cd);
	for(int i = 0; i<len; i++) ab_cd[i] -= (ac[i] + bd[i]);
	
	for(int i = 0; i<len; i++) res[i] = bd[i];
	
	for(int i = len; i<2*len; i++) res[i] = ac[i - len];
	
	for(int i = k; i<len+k; i++) res[i] += ab_cd[i - k];
}

void extend(Number& a, size_t len)
{
	while(len & (len-1)) len++;
	
	a.resize(len);
}

void finalize(Number& res)
{
	for(int i = 0; i<res.size(); i++)
	{
		res[i + 1] += res[i]/10;
		res[i] %= 10;
	}
}

void print(Number a)
{
	for(int i = a.size()-1; i>=0; i--) cout << a[i] <<" ";
	cout << endl;
}
int main()
{
	string num1, num2;
	cin >> num1 >> num2;

	Number a,b;
	for(int i = num1.size()-1; i>=0; i--) a.push_back(num1[i] - '0');
	for(int i = num2.size()-1; i>=0; i--) b.push_back(num2[i] - '0');
	int n = max(a.size(),b.size());
	
	extend(a,n);
	extend(b,n);
	
	print(a);
	print(b);
	Number res; 
	multiply(a,b,res);
	cout << "a*b = ";
	finalize(res);
	print(res);
	return 0;
}
