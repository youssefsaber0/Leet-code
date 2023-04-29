class UnionFind {
    private int[] group;
    private int[] rank;

    UnionFind(int size) {
        group = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; ++i) {
            group[i] = i;
        }
    }

    public int find(int node) {
        if (group[node] != node) {
            group[node] = find(group[node]);
        }
        return group[node];
    }

    public void join(int node1, int node2) {
        int group1 = find(node1);
        int group2 = find(node2);
        
        // node1 and node2 already belong to same group.
        if (group1 == group2) {
            return;
        }

        if (rank[group1] > rank[group2]) {
            group[group2] = group1;
        } else if (rank[group1] < rank[group2]) {
            group[group1] = group2;
        } else {
            group[group1] = group2;
            rank[group2] += 1;
        }
    }
    
    public boolean areConnected(int node1, int node2) {
        int group1 = find(node1);
        int group2 = find(node2);
        return group1 == group2;
    }
};
class Solution {
    private void sort(int[][] array){
        Arrays.sort(array, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    return a[2] - b[2];
                }
        });
    }
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int[][] nQueries = new int[queries.length][4];
                boolean[] ans = new boolean[queries.length];

        UnionFind unionFind = new UnionFind(n);
        for(int i = 0; i < queries.length; i++){
            nQueries[i][3] =  i;
            nQueries[i][0] =  queries[i][0];
            nQueries[i][1] =  queries[i][1];
            nQueries[i][2] =  queries[i][2];
        }
        sort(nQueries);
        sort(edgeList);
        int i = 0;
        for(int[] q : nQueries){
            while(i < edgeList.length &&edgeList[i][2] < q[2]) {
                unionFind.join(edgeList[i][0],edgeList[i][1]);
                i++;
            }
            int p1 = unionFind.find(q[0]);
            int p2 = unionFind.find(q[1]);
            ans[q[3]] = p1==p2;
        }


        return ans;
    }
}