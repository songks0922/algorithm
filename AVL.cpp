#include <iostream>
using namespace std;

// depth fisrt search (DFS) function using iterative method and using array as
// stack
void dfs(int start, int end) {
  int stack[100000];
  int top = -1;
  stack[++top] = start;
  while (top != -1) {
    int current = stack[top--];
    if (current == end) {
    }
    // push children of current node into stack
    // stack[++top] = child;
  }
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);

  return 0;
}