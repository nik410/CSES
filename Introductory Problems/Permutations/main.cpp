#include <iostream>

using namespace std; // This brings everything from 'std' into scope

int main() {
    int n;
    cin >> n;

    if(n == 2 || n == 3){
        cout << "NO SOLUTION";
        return 0;
    } 

    int even = 2;

    while(even <= n){
        cout << even << " ";
        even += 2;
    }

    int odd = 1;
    
    while(odd <= n){
        cout << odd << " ";
        odd += 2;
    }

    return 0;
}