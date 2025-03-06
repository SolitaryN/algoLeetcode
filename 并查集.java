import java.util.Arrays;

class UnionFind{
    int[] parent;// parent[i]表示i这个元素指向的父亲节点
    int[] size;//size[i]表示以i为根节点的集合中元素个数
    int n;//节点的个数，初始化每一个节点都是一个单独的连通分量
    int setCount;//连通分量的数目
    public UnionFind(int n){
        this.size = new int[n];
        this.parent = new int[n];
        this.n = n;
        this.setCount = n;
        Arrays.fill(size,1);
        Arrays.fill(parent, -1);
    }

    // 这里find的时候，如果已经是root节点，则返回否则递归
    public int find(int x){
        if (parent[x] == -1) {
            return x; // 已经是根节点
        }
        // 路径压缩
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public boolean union(int x,int y){
        x = find(x);
        y = find(y);
        if(x == y){
            return false;
        }
        if(size[x]<size[y]){
            int tem = x;
            x = y;
            y = tem;
        }

        parent[y] = x;
        size[x] += size[y];
        --setCount;
        return true;
    }

    public boolean connected(int x, int y) {
        x = find(x);
        y = find(y);
        return x == y;
    }

}

