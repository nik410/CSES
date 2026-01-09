#include<cmath>
#include<algorithm>
#include<iostream>

using namespace std;

int main() {

    int n;

    cin >> n;

    int timing[n][2];

    int arrivalTime[n];
    int departureTime[n];

    for(int i = 0; i < n; i ++){
        cin >> arrivalTime[i];
        cin >> departureTime[i];
    }

    sort(arrivalTime, arrivalTime + n);
    sort(departureTime, departureTime + n);

    int i = 0, j = 0;

    int maxGuest = 0;
    int currGuest = 0;

    while(i < n && j < n){

        if(arrivalTime[i] < departureTime[j]){
            currGuest ++;
            i ++;
        }
        else if(arrivalTime[i] >= departureTime[j]){
            maxGuest = max(maxGuest, currGuest);
            currGuest --;
            j ++;
        }

    }

    maxGuest = max(maxGuest, currGuest);

    cout << maxGuest;

    
    
    return 0;

}


// 2 3 4 7 
// 5 9 6 8

// 2 3 4 7
// 5 6 9 8