#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
    int price, cnt, cash;
    cin >> price >> cnt >> cash;

    cout << (price * cnt > cash ? price * cnt - cash : 0) << '\n';
    return 0;
}