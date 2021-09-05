#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int findBound(vector<int> v, int num) {
  int low = 0, high = v.size() - 1;
  while (low < high) {
    int mid = (low + high) / 2;
    if (v[mid] >= num) {
      high = mid;
    } else {
      low = mid + 1;
    }
  }
  return high;
}

int Lower_Bound(vector<int> vt, int num) {
    int low = 0, high = vt.size() - 1;
 
    while (low < high) {
        int mid = (low + high) / 2;
        if (vt[mid] >= num)
            high = mid;
        else
            low = mid + 1;
    }
    return high;
}
 
int main(void)
{
    int n, num;
    scanf("%d", &n);
    vector<int> vt;
    vt.push_back(-1);
    for (int i = 0; i < n; i++) {
        scanf("%d", &num);
        if (num > vt[vt.size()-1])
            vt.push_back(num);
        else 
            vt[Lower_Bound(vt, num)] = num;
    }
    printf("%d", n - vt.size() + 1);
 
    return 0;
}
