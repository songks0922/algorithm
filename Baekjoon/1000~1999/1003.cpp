#include <iostream>
using namespace std;

int m[100] = {0, };

int fib(int n, int m[]) {
  if (n == 0) {
    return 0;
  } else if (n == 1) {
    return 1;
  } else if (m[n] != 0){
    return m[n];
  } else {
    m[n] = fib(n-1, m) + fib(n-2, m);
    return m[n];
    
  }
}


int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int t, n;
  cin >> t;

  for(int i = 0; i < t; i++) {
    cin >> n;
    
    fib(n, m);
    if (n == 0) {
      cout << "1 " << "0" << '\n';
    } else if (n == 1) {
      cout << "0 " << "1" << '\n'; 
    } else {
      cout << fib(n-1, m) << " " << fib(n, m)  << '\n';
    }
   
  }
  return 0;
}