#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
    int n1, n2, n3, n4;

    cin >> n1 >> n2 >> n3 >> n4;

    string sum1, sum2;

    sum1 = to_string(n1) + to_string(n2);
    sum2 = to_string(n3) + to_string(n4);

    cout << (stoll(sum1) + stoll(sum2)) << '\n';
    return 0;
}