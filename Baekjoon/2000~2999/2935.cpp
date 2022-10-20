#include <iostream>
#include <algorithm>
#include <string>
#include <cmath>
using namespace std;
int main() {
    string a, b, op;
    cin >> a >> op >> b;

    if (op == "+")
    {
        int size = max(a.size(), b.size());
        int tmp = a.size() - b.size();
        string plus = "";
        if (tmp < 0)
        {
            for (int i = 0; i < abs(tmp); i++)
                plus += "0";
            a = plus + a;
        }
        else
        {
            for (int i = 0; i < abs(tmp); i++)
                plus += "0";
            b = plus + b;
        }
        for (int i = size-1; i >= 0; i--)
        {
            if(b[i]-'0')
                a[i] = ((a[i] - '0') + (b[i] - '0')) + '0';
        }
        cout << a;
    }
    else
    {
        int size = a.size() - 1 + b.size() - 1;
        cout << "1";
        while(size--)
            cout << 0;
    }
}
