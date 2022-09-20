#include <iostream>
using namespace std;

int buffA[60], buffB[60];
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  char str[100];

  cin >> str;

  for (int i = 0; str[i] != '\0'; i++) {
    if (str[i] >= 65 && str[i] <= 90) {
      buffA[str[i] - 64]++;
    } else {
      buffA[str[i]-70]++;
    }
  }

  cin >> str;

  for (int i = 0; str[i] != '\0'; i++) {
    if (str[i] >= 65 && str[i] <= 90) {
      buffB[str[i] - 64]++;
    } else {
      buffB[str[i]-70]++;
    }
  }

  for (int i = 0; i <= 52; i++) {
    if (buffA[i] != buffB[i]) {
      cout << "NO\n";
      return 0;
    }
  }

  cout << "YES\n";

  return 0;
}