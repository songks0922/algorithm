#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
    int sel;

    cin >> sel;

    switch(sel) {
      case 0:
        cout << "YONSEI" << '\n';
        break;
      case 1:
        cout << "Leading the Way to the Future" << '\n';
        break;
    }
    return 0;
}