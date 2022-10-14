#include <iostream>
using namespace std;

void permuteString(char *str, int begin, int end);
void permute(char *str);
void swap(char *a, char *b);
int strlen(char *str);
int count = 0;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  char str[10];
  int t;

  cin >> t;

  for (int i = 0; i < t; i++) {
    cin >> str;
    permute(str);
  }
  
  return 0;
}

void swap(char *a, char *b) {
  char *temp = a;
  a = b;
  b = temp;
}

void permuteString(char *str, int begin, int end) {
  int range = end - begin;

  if (range == 1) {

    int weight = 0;

    for (int i = 0; str[i] != '\0'; i++) {
      if (i % 2 == 1) {
        weight += (str[i] - 'a') * -1;
      } else weight += str[i] - 'a';
    }
    
    if (weight > 0) count++;

  } else {
    for (int i = 0; i < range; i++) {
      swap(str[begin], str[begin+ i]);
      permuteString(str, begin + 1, end);
      swap(str[begin], str[begin + i]);
    }
  }
}

void permute(char *str) {
  count = 0;
  permuteString(str, 0, strlen(str));
  cout << count << '\n';
}

int strlen(char *str) {
  int len = 0;
  for (int i = 0; str[i] != '\0'; i++) {
    len++;
  }

  return len;
}