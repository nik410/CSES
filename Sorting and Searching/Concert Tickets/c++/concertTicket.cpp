#include <iostream>
#include <vector>
#include <set>
#include <algorithm>

using namespace std;

/**
 * We use fast I/O to match the performance of Java's FastReader.
 * std::multiset handles the sorted ticket prices and allows duplicates.
 */
void solve() {
    int n, m;
    if (!(cin >> n >> m)) return;

    multiset<int> tickets;
    for (int i = 0; i < n; i++) {
        int p;
        cin >> p;
        tickets.insert(p);
    }

    for (int i = 0; i < m; i++) {
        int bid;
        cin >> bid;

        // upper_bound(bid) returns the first element > bid.
        // The element <= bid is the one immediately before it.
        auto it = tickets.upper_bound(bid);

        if (it == tickets.begin()) {
            // No ticket is less than or equal to the bid
            cout << -1 << "\n";
        } else {
            // Move back one step to get the largest element <= bid
            --it;
            cout << *it << "\n";
            // Remove the ticket from the set (only one instance)
            tickets.erase(it);
        }
    }
}

int main() {
    // Optimization for fast C++ I/O
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    solve();
    return 0;
}