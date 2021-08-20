#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    double num1, num2;
    cin >> num1 >> num2;
    cout<<fixed;
    cout.precision(15);
    cout << num1 / num2 << "\n";
    return 0;
}