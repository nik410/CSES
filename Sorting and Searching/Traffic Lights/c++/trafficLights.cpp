#include <iostream>
#include <set>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * Strategy:
 * 1. Use a set to keep track of light positions (sorted).
 * 2. Use a multiset to keep track of all current gap lengths.
 * 3. When a new light is added, find its neighbors, remove the old gap from the multiset,
 * and add the two new split gaps.
 */

int main() {
    // Fast I/O
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int x, n;
    if (!(cin >> x >> n)) return 0;

    // Stores the positions of the traffic lights
    set<int> positions;
    positions.insert(0);
    positions.insert(x);

    // Stores all gap lengths (multiset allows duplicates)
    multiset<int> distFreq;
    distFreq.insert(x);

    for (int i = 0; i < n; i++) {
        int lightPos;
        cin >> lightPos;

        // Find neighbors using binary search (lower_bound)
        auto it_up = positions.upper_bound(lightPos);
        auto it_low = prev(it_up);

        int left = *it_low;
        int right = *it_up;

        // 1. Remove the old gap being split
        // Note: use find() so only ONE instance of the gap is removed
        auto it_gap = distFreq.find(right - left);
        if (it_gap != distFreq.end()) {
            distFreq.erase(it_gap);
        }

        // 2. Add the two new segments
        distFreq.insert(lightPos - left);
        distFreq.insert(right - lightPos);

        // 3. Add the new light position to the set
        positions.insert(lightPos);

        // 4. The largest gap is the last element in the multiset
        // rbegin() points to the largest element
        cout << *distFreq.rbegin() << (i == n - 1 ? "" : " ");
    }

    cout << endl;

    return 0;
}