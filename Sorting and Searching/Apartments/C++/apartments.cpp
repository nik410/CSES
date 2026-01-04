#include <iostream> 
#include<algorithm>
#include<cmath>

using namespace std;

int main() {
    
        int n, m, k;

        cin >> n;
        cin >> m;
        cin >> k;

        int desires[n];

        for(int i = 0; i < n; i ++){
           cin >> desires[i];
        }

        int apartments[m];

        for(int i = 0; i < m; i ++){
           cin >> apartments[i];
        }

        sort(desires, desires + n);
        sort(apartments, apartments + m);

        int i = 0, j = 0;

        int ans = 0;

        while(i < n && j < m){
            
            int desire = desires[i];
            int apartment = apartments[j];

            if(abs(desire - apartment) <= k){
                ans ++;
                i ++;
                j ++;
            }
            else if(desire > apartment){
                j ++;
            }
            else if(desire < apartment){
                i ++;
            }
        }

        cout << ans << endl;
        return 0;
}