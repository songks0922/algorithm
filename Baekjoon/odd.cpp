#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
    int num;

    cin >> num;

    if(num % 2 == 0) {
      cout << "Even" << '\n';
    } else {
      cout << "Odd" << '\n';
    }
    return 0;
}