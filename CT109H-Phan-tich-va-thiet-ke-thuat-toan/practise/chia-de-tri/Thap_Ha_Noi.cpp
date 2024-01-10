#include <iostream>
using namespace std;
int count = 0;
void move(int n,char A, char B, char C)
{
	if(n == 1) {
		count++;
		cout <<"lan "<<count<< " chuyen "<< A << " sang " << B <<"\n";
		return;
	}
	
	move(n-1,A,C,B);
	move(1,A,B,C);
	move(n-1,C,B,A);
	
}
int main()
{
	int n = 4;
	move(n,'A','B','C');
	return 0;
}
