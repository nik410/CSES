#include<algorithm>
#include<cmath>
#include<iostream>
#include<vector>

using namespace std;

int main() {
    
    int n;
    cin >> n;

    vector<pair<int, int>> movieSlots(n);

    for(int i = 0; i < n; i ++){
        cin >> movieSlots[i].first;
        cin >> movieSlots[i].second;
    }

    sort(movieSlots.begin(), movieSlots.end(), [](const pair<int, int>& a, const pair<int, int>& b){
            if(a.second == b.second){
                return a.first < b.first;
            }
            else{
                return a.second < b.second;
            }
        }
    );

    int count = 1;

    int endPrevTime = movieSlots[0].second;
    
    for(int i = 1; i < n; i ++){
        int start = movieSlots[i].first;
        int end = movieSlots[i].second;

        // cout  << "prev: " << endPrevTime << "start: " << start << " end: " << end << endl;

        if(start >= endPrevTime){
            endPrevTime = end;
            count++;
        }

    }

    cout << count;
    
    return 0;
}
