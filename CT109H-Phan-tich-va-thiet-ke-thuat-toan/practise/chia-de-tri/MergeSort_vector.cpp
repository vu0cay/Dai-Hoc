#include <iostream>
#include <vector>
using namespace std;
//Cài đặt thuật toán sắp xếp trộn
typedef vector<int> Number;
Number Merge(Number L, Number R)
{
    Number K;
    Number::iterator pL = L.begin();
    Number::iterator pR = R.begin();
    while(pL != L.end() && pR != R.end())
    {
        if(*pL < *pR)
        {
            K.push_back(*pL);
            pL++;
        }
        else
        {
            K.push_back(*pR);
            pR++;
        }
    }
    while(pL != L.end())
    {
        K.push_back(*pL);
        pL++;
    }
    while(pR != R.end())
    {
        K.push_back(*pR);
        pR++;
    }
    return K;
}
Number mergeSort(Number A) {
    int n = A.size();
    if (n <= 1)
        return A;

    int m = n/2;
    Number L = mergeSort(Number(A.begin(), A.begin() + m));
    Number R = mergeSort(Number(A.begin() + m, A.end()));

    //Trộn 2 danh sách L và R thành danh sách K
    return Merge(L,R);

}
int main() {
    Number a{1,3,4,21,3,41,24,41,24,214,214,5,21,512,521,5,215,512,5,636,65,-41,-5125};
    for(auto e : a) cout << e <<" ";
    cout << endl;
    a = mergeSort(a);
    for(auto e : a) cout << e <<" ";
    cout << endl;
    return 0;
}
