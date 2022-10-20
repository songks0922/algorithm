#include <iostream>
using namespace std;

int main(void)
{
  int hour, minute;
  cin >> hour >> minute;
  minute -= 45;
  if (minute < 0)
  {
    hour--;
    minute = 60 + minute;
  }

  hour = hour < 0 ? 23 : hour;

  cout << hour << " " << minute << endl;
  return 0;
}