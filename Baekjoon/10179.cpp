#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
    cout<<fixed;
    cout.precision(2);
    double n, price;
    cin >> n;
    for (int i = 0; i < n; i++) {
      cin >> price;
      cout << "$" << price * 0.8 << '\n';
    }
    return 0;
} 