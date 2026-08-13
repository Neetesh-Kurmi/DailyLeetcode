class Solution {

    int[] left, right, max;
    char[] s;

    public int[] longestRepeating(
            String str,
            String queryCharacters,
            int[] queryIndices) {

        s = str.toCharArray();

        int n = s.length;

        left = new int[4 * n];
        right = new int[4 * n];
        max = new int[4 * n];

        build(1, 0, n - 1);

        int q = queryIndices.length;
        int[] ans = new int[q];

        for (int i = 0; i < q; i++) {

            int index = queryIndices[i];

            s[index] = queryCharacters.charAt(i);

            update(1, 0, n - 1, index);

            ans[i] = max[1];
        }

        return ans;
    }

    void build(int node, int l, int r) {

        if (l == r) {
            left[node] = 1;
            right[node] = 1;
            max[node] = 1;
            return;
        }

        int mid = (l + r) / 2;

        build(node * 2, l, mid);
        build(node * 2 + 1, mid + 1, r);

        merge(node, l, mid, r);
    }

    void update(int node, int l, int r, int index) {

        if (l == r) {
            left[node] = 1;
            right[node] = 1;
            max[node] = 1;
            return;
        }

        int mid = (l + r) / 2;

        if (index <= mid)
            update(node * 2, l, mid, index);
        else
            update(node * 2 + 1, mid + 1, r, index);

        merge(node, l, mid, r);
    }

    void merge(int node, int l, int mid, int r) {

        int L = node * 2;
        int R = node * 2 + 1;

        left[node] = left[L];
        right[node] = right[R];

        max[node] = Math.max(max[L], max[R]);

        // Join the suffix of left child
        // with the prefix of right child.
        if (s[mid] == s[mid + 1]) {

            max[node] = Math.max(
                    max[node],
                    right[L] + left[R]
            );

            int leftLength = mid - l + 1;
            int rightLength = r - mid;

            if (left[L] == leftLength)
                left[node] = leftLength + left[R];

            if (right[R] == rightLength)
                right[node] = rightLength + right[L];
        }
    }
}