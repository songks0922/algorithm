#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool isPrime(int num) {
  if(num == 1) return false;
  for (int j = 2; j < num; j++) {
    if (num % j == 0) {
      return false;
    }
  }
  return true;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int m, n,sum = 0;
  vector<int> primes;
  cin >> m >> n;

  for (int i = m; i <= n; i++) {
    if (isPrime(i)) primes.push_back(i);
  }

  vector<int>::iterator iter;

  for (iter = primes.begin(); iter != primes.end(); iter++) {
    sum += *iter;
  }
  if (primes.size() == 0) {
    cout << "-1" << '\n';
    return 0;
  }
  cout << sum << '\n' << *min_element(primes.begin(), primes.end()) << '\n';
  return 0;
}