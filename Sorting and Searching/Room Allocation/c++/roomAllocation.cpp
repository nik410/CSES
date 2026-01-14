#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
#include <queue>

using namespace std;

/**
 * Port of the Java Room Allocation logic.
 * Note: Keeping the custom sorting by exit time as requested.
 */
int main() {
    // Optimization for fast I/O
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    if (!(cin >> n)) return 0;

    // interval[n][0] = entry, [n][1] = exit, [n][2] = original index
    vector<vector<int>> interval(n, vector<int>(3));
    set<int> roomsFree;

    for (int i = 0; i < n; i++) {
        cin >> interval[i][0] >> interval[i][1];
        interval[i][2] = i;
        roomsFree.insert(i + 1); // Equivalent to roomsFree.add(i + 1)
    }

    // Sort logic exactly as in Java: secondary sort on entry, primary on exit
    sort(interval.begin(), interval.end(), [](const vector<int>& x, const vector<int>& y) {
        if (x[0] == y[0]) {
            return x[1] < y[1];
        }
        return x[0] < y[0];
    });

    // PriorityQueue<Integer[]> roomInUse: stores {roomNumber, exitDay}
    // Custom comparator to match Java logic
    auto cmp = [](const vector<int>& x, const vector<int>& y) {
        if (x[1] == y[1]) {
            return x[0] > y[0]; // Min-heap behavior for x[0]
        }
        return x[1] > y[1]; // Min-heap behavior for exitDay
    };
    priority_queue<vector<int>, vector<vector<int>>, decltype(cmp)> roomInUse(cmp);

    // Process the first interval
    roomInUse.push({1, interval[0][1]});
    roomsFree.erase(1);
    int prevPersonExit = interval[0][1];

    vector<int> roomNumber(n);
    roomNumber[interval[0][2]] = 1;

    for (int i = 1; i < n; i++) {
        int entryDay = interval[i][0];
        int exitDay = interval[i][1];
        int originalIndex = interval[i][2];

        // Check if any room has become free based on the priority queue
        if (!roomInUse.empty()) {
            vector<int> earliestFreeRoom = roomInUse.top();
            if (earliestFreeRoom[1] < entryDay) {
                roomInUse.pop();
                roomsFree.insert(earliestFreeRoom[0]);
            }
        }

        // The logic branches in your Java code are identical, so we apply the same steps
        int lowestRoom = *roomsFree.begin(); // Equivalent to roomsFree.first()
        roomsFree.erase(lowestRoom);

        roomInUse.push({lowestRoom, exitDay});
        roomNumber[originalIndex] = lowestRoom;
        
        prevPersonExit = exitDay;
    }

    // Output the max room count and the assignments
    cout << roomInUse.size() << "\n";
    for (int i = 0; i < n; i++) {
        cout << roomNumber[i] << (i == n - 1 ? "" : " ");
    }
    cout << endl;

    return 0;
}