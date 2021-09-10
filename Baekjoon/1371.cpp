#include <iostream>
#include <algorithm>
#include <string>
#include <cstring>

using namespace std;

int alpha[26];

int main(void)
{
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  string s;
  while (cin>>s)
  {
    for (int i = 0; i < s.length(); i++)
      if (s[i] >= 'a' && s[i] <= 'z')
        alpha[s[i] - 'a']++;
        s.clear();
  }

  int temp = alpha[0];

  for (int i = 1; i < 26; i++)
    temp = max(alpha[i], temp);
  for (int i = 0; i < 26; i++)
    if (alpha[i] == temp) cout << (char)(i + 'a');
  cout << "\n";
  return 0;
}