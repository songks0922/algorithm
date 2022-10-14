#include <iostream>

using namespace std;

void reverseArray(char a[], int i, int j);
char str[101];

void swap(char* arr, int i, int j) {
  char tmp = arr[i];
  arr[i] = arr[j];
  arr[j] = tmp;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);

  int t, size = 0;
  cin >> t;
  for (int i = 0; i < t; i++) {
    cin >> str;
    for (int j = 0; str[j] != '\0'; j++) size++;
    reverseArray(str, 0, size-1);
    cout << str << '\n';
    size = 0;
  }
  
  return 0;
}

void reverseArray(char str[], int i, int j) {
  if (i < j) {
    swap(str, i, j);
    reverseArray(str, i+1, j-1);
  }
}