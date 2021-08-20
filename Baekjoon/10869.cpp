#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
    int num1, num2;
    cin >> num1 >> num2;

    cout << num1 + num2 << "\n" << num1 - num2 << "\n" << num1 * num2 << "\n" << num1 / num2 << "\n" << num1 % num2 << "\n";
    return 0;
}