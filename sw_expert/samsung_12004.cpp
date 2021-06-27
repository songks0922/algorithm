#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
    int test_case;
    int T;

    cin >> T;

    for (test_case = 1; test_case <= T; ++test_case)
    {
        int n, temp = 9;
        int cnt = 2;
        cin >> n;

        while (true)
        {
            if (n % temp == 0)
            {
                n /= temp;
                temp = 9;
                cnt--;
                continue;
            }
            if (cnt == 0) break;
            temp--;
        }
        if (n == 1) cout << "#" << test_case << " Yes" << endl;
        else cout << "#" << test_case << " No" << endl;
    }
    return 0;
}