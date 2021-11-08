#include <iostream>
#include <string>
#include <map>
using namespace std;

bool isPrime(int number)
{
  if (number == 1) return true;
  else {
    for (int i = 2; i < number; i++)
    {
      if (number % i == 0)
        return false;
    }
    return true;
  }
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  map<char, int> alpha;

  for (int i = 0; i < 26; i++) {
    alpha.insert(make_pair('a' + i, i+1));
  }

  map<char, int>::iterator iter;

  string word;
  int sum = 0;
  cin >> word;

  for (char const& c : word) {
    if (isupper(c)) {
      sum += alpha[tolower(c)] + 26;
    } else {
      sum += alpha[c];
    }
  }
  cout << (isPrime(sum) ? "It is a prime word." : "It is not a prime word.") << '\n';
  
  return 0;
}