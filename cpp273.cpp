#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

void BLlst(int n, int m, vector<vector<int>>& b, vector<int>& L, vector<int>& lst) {
    vector<int> d(n+1, 0), fst(n+1);
    // Calculate vertex degrees
    for (int i = 1; i <= 2; ++i)
        for (int j = 1; j <= m; ++j)
            ++d[b[i][j]];
    // Forming lst array
    lst[1] = 0;
    for (int i = 1; i <= n; ++i)
        lst[i+1] = lst[i] + d[i];
    // Forming fst array
    for (int i = 1; i <= n; ++i)
        fst[i] = lst[i] + 1;
    // Forming L array
    for (int j = 1; j <= m; ++j) {
        int k = b[1][j];
        L[fst[k]] = b[2][j];
        ++fst[k];
        k = b[2][j];
        L[fst[k]] = b[1][j];
        ++fst[k];
    }

    /* Sorting in ascending order for each vertex
    for (int i = 1; i <= n; ++i)
        sort(L.begin() + lst[i] + 1, L.begin() + lst[i+1] + 1);
    */
}

void printArrays(const vector<int>& L, const vector<int>& lst) {
    cout << "L array:\n";
    for (int i = 1; i < L.size(); ++i)
        cout << L[i] << ' ';
    cout << '\n';
    cout << "lst array:\n";
    for (int i = 1; i < lst.size(); ++i)
        cout << lst[i] << ' ';
    cout << '\n';
}

int main() {
    //Input
    int n, m;
    cout << "Enter the number of vertices (n) and edges (m): ";
    cin >> n >> m;
    vector<vector<int>> b(3, vector<int>(m+1));
    cout << "Enter the edges (u v):\n";
    for (int j = 1; j <= m; ++j)
        cin >> b[1][j] >> b[2][j];
    vector<int> L(2*m+1), lst(n+2);
    //Main algo
    BLlst(n, m, b, L, lst);
    //Output
    printArrays(L, lst);
    return 0;
}
