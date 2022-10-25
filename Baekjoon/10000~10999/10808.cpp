#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
char a[101];
int arr[26];
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  cin >> a;

  for (int i = 0; a[i] != '\0'; i++) {
    arr[a[i] - 'a']++;
  }

  for (int i = 0; i < 26; i++) {
    cout << arr[i] << ' ';
  }
  
  return 0;
}