#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// Using a struct for better readability (replaces int[][3])
struct Range {
    int start;
    int end;
    int originalIndex;
};

int main() {
    // Optimization for fast I/O
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    if (!(cin >> n)) return 0;

    vector<Range> arr(n);
    for (int i = 0; i < n; i++) {
        cin >> arr[i].start >> arr[i].end;
        arr[i].originalIndex = i;
    }

    // Sort: Primary ascending by start, secondary descending by end
    sort(arr.begin(), arr.end(), [](const Range& a, const Range& b) {
        if (a.start == b.start) {
            return a.end > b.end; // Notice: descending end for same start
        }
        return a.start < b.start;
    });

    vector<int> contains(n, 0);
    vector<int> contained(n, 0);

    // 1. Check if range is contained by another (Left to Right)
    // A range is contained if its end is <= the maximum end seen so far
    int maxEndPoint = 0;
    for (int i = 0; i < n; i++) {
        if (arr[i].end <= maxEndPoint) {
            contained[arr[i].originalIndex] = 1;
        }
        maxEndPoint = max(maxEndPoint, arr[i].end);
    }

    // 2. Check if range contains another (Right to Left)
    // A range contains another if its end is >= the minimum end seen coming from the right
    int minEndPoint = 2e9 + 7; // Equivalent to Integer.MAX_VALUE
    for (int i = n - 1; i >= 0; i--) {
        if (arr[i].end >= minEndPoint) {
            contains[arr[i].originalIndex] = 1;
        }
        minEndPoint = min(minEndPoint, arr[i].end);
    }

    // Output results
    for (int i = 0; i < n; i++) cout << contains[i] << (i == n - 1 ? "" : " ");
    cout << "\n";
    for (int i = 0; i < n; i++) cout << contained[i] << (i == n - 1 ? "" : " ");
    cout << "\n";

    return 0;
}