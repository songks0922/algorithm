#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
    int acc1, acc2;
    int price;
    cin >> acc1 >> acc2;
    cin >> price;

    cout << (((acc1 + acc2) >= (price * 2)) ? ((acc1 + acc2) - (price * 2)) : (acc1 + acc2)) << '\n';  
    return 0;
}