#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
    int n1, n2, n3;

    cin >> n1 >> n2 >> n3;

    if(n1 > n2) {
      if(n1 > n3) {
        if(n2 > n3) {
          cout << n2 << '\n';
        } else {
          cout << n3 << '\n';
        }
      }else {
        cout << n1 << '\n';
      }
    }
    else {
      if(n2 > n3) {
        if(n1 > n3) {
          cout << n1 << '\n';
        }  else {
          cout << n3 << '\n';
        }
      } else {
        cout << n2 << '\n';
      }
    }

    
    return 0;
}