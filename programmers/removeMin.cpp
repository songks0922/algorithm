#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  vector<int> arr = {4,3,1,2};
  vector<int> answer(arr);
  sort(arr.begin(), arr.end(), greater<int>());
  vector<int>::iterator ptr;
  int min = arr.back();
  auto it = remove(answer.begin(), answer.end(), min);
	answer.resize( it - answer.begin());
  if(answer.size() == 0) answer.push_back(-1);
  return 0;
}


// 이렇게도 풀 수 있다..
// #include <string>
// #include <vector>
// #include <algorithm>
// using namespace std;

// vector<int> solution(vector<int> arr) {
//     vector<int> answer = arr;

//     int nMin = *min_element(arr.begin(), arr.end());
//     int pos = find(answer.begin(), answer.end(), nMin) - answer.begin();
//     answer.erase(answer.begin() + pos);

//     return answer.empty() ? vector<int>(1, -1) : answer;
// }