#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Student {
public:
  int country;
  int studentNum;
  int score;

  Student(int country, int studentNum, int score) 
    : country(country), studentNum(studentNum), score(score) {}

  bool operator < (const Student &s2) {
    return this->score > s2.score;
  }

  void print() {
    // cout << country << " " << studentNum << " " << score << "\n";
    cout << country << " " << studentNum << "\n";
  }

};

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  vector<Student> students;
  int n, cNum, sNum, score;
  int medal[3] = {0, 0, 0};
  int total = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> cNum >> sNum >> score;
    
    students.push_back(Student(cNum, sNum, score));
  }

  sort(students.begin(), students.end());

  // cout << "===============" << '\n';

  for (int i = 0; i < students.size(); i++) {
    if (total == 3) break;
    for (int j = 0; j < 3; j++) {
      if (medal[j] < 2 && students[i].country - 1  == j) {
        students[i].print();
        medal[j]++;
        total++;
        break;
      }
    }
    // students[i].print();
  }
  
  return 0;
}