#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

void setLength(vector<int>& v, vector<int>& source);

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int w, h, n;  //w : 가로, h : 높이, n : 자를 횟수
  int cutNum, isVertical; //cutNUm : 자를 점선 번호, isVertical : 0이면 가로, 1이면 세로

  vector<int> wpos;
  vector<int> hpos;
  vector<int> width;
  vector<int> height;

  cin >> w >> h >> n;

  hpos.push_back(h);
  wpos.push_back(w);

  for (int i = 0; i < n; i++) {
    cin >> isVertical >> cutNum;
    isVertical ? wpos.push_back(cutNum) : hpos.push_back(cutNum);
  }

  sort(hpos.begin(), hpos.end());
  sort(wpos.begin(), wpos.end());
  setLength(width, wpos);
  setLength(height, hpos);
  sort(width.begin(), width.end());
  sort(height.begin(), height.end());

  cout << width.back() * height.back() << '\n';

  return 0;
}

void setLength(vector<int>& target, vector<int>& source) {

  for (int i = 0; i < source.size(); i++) {
    i == 0 ? target.push_back(source[i]) : target.push_back(source[i] - source[i-1]);
  }
}