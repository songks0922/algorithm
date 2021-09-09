#include <iostream>
#include <string>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  string jhawn, doctor;

  cin >> jhawn >> doctor;
  cout << (jhawn.length() >= doctor.length() ? "go" : "no") << '\n';
  return 0;
}