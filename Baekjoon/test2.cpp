#include <iostream>
using namespace std;

int main()
{
    int numTestCases;
    cin >> numTestCases;
    for(int i=0; i<numTestCases; i++){
        int numData;
        cin >> numData;
    
        int max = 0, min = 2147483647;
        int num;
        for(int x=0; x<numData; x++){
            cin >> num;
            if(max < num)
                max = num;
            else if(min > num)
                min = num;
        }    
        cout << max << " " << min << endl;
    } 
    return 0;
}