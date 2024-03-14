import java.util.Arrays;

class US{
    int[] SetsUF = new int[100];
    public US(){
        Arrays.fill(SetsUF, -1);
    }

    int find(int index_of_child){
        while(SetsUF[index_of_child] != -1){
            index_of_child = SetsUF[index_of_child];
        }
        return index_of_child;
    }

    void union(int root1, int root2){
        SetsUF[root2] = root1;
    }
}

