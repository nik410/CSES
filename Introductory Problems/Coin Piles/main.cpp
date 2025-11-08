#include <iostream>
#include <unordered_set>

using namespace std; // This brings everything from 'std' into scope

int main() {
    int n;
    cin >> n;

    for(int i = 0; i < n; i ++){
        int a;
        int b;

        cin >> a;
        cin >> b;

        if((a + b) % 3 == 0){
            if(a > 2 * b || b > 2 * a){
                cout << "NO" << endl;
            }
            else{
                cout << "YES" << endl;
            }
        }
        else{
            cout << "NO" << endl;
        }
    }

    return 0;
}