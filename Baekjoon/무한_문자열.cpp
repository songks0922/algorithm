#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int GCD(int a, int b) {
  if(!b) return a;
  return GCD(b, a%b);
}

int LCM(int a, int b) {
  return a*b/GCD(a, b);
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  string s, t, str1, str2;

  cin >> s >> t;

  int a = LCM(s.size(), t.size());

  for (int i = 0; i < a / s.size(); i++) str1+= s;
  for (int i = 0; i < a / t.size(); i++) str2+= t;
  cout << (str1==str2);

   return 0;
}