#include <iostream>

using namespace std; // This brings everything from 'std' into scope

int main() {
    int n;
    cin >> n;

    while(n -- > 0){
        long long x;
        long long y;

        cin >> x;
        cin >> y;

        long long max; 

        if(x >= y){
            max = x;
        }
        else{
           max = y; 
        }

        long long l = (max - 1) * (max - 1) + 1;
        long long r = max * max;

        long long ans = 0ll;

        if(y == max){
            if(y % 2 == 1){
                ans = r - (x - 1);
            }
            else{
                ans = l + (x - 1);
            }
        }
        else{
            if(x % 2 == 0){
                ans = r - (y - 1);
            }
            else{
                ans = l + (y - 1);
            }
        }

        cout << ans << endl;
    }

    return 0;
}