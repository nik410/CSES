#include <iostream>
#include <unordered_set>

using namespace std; // This brings everything from 'std' into scope

int main() {
    long long n;
    cin >> n;

    long long sum = (n * (n + 1)) / 2;
    
    if(sum % 2 == 1){
        cout << "NO";
        return 0;
    }
    else{
        long long halfSum = sum / 2;



        cout << "YES" << endl;
        // cout << n / 2 << endl;
        long long copyHS = halfSum;
        int count = 0;
        unordered_set<int> alreadyUsedIntegers;

        for(long i = n; i >= n / 2; i --){
            if(copyHS - i > 0){
                // cout << i << " ";
                count ++;
                copyHS -= i;
                alreadyUsedIntegers.insert(i);
            }
            else{
                break;
            }
        }

        cout << count + 1  << endl;

        for(const auto& num: alreadyUsedIntegers){
            cout << num << " ";
        }

        if(copyHS != 0){
            cout << copyHS << endl;
            alreadyUsedIntegers.insert(copyHS);
        }

        cout << (n - (count + 1)) << endl;
        for(int i = 1; i < n; i ++){
            if(!alreadyUsedIntegers.count(i)){
                cout << i << " ";
            }
        }
    }

    return 0;
}