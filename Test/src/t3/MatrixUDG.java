package t3;

public class MatrixUDG {

    private char[] node;       // 顶点集合
    private int[][] relation;    // 邻接矩阵
    private static final int INF = Integer.MAX_VALUE;   // 最大值


    public MatrixUDG(char[] vexs, int[][] matrix) {
        
        int vlen = vexs.length;
        node = new char[vlen];
        for (int i = 0; i < node.length; i++)
            node[i] = vexs[i];

        relation = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++)
            for (int j = 0; j < vlen; j++)
                relation[i][j] = matrix[i][j];
        
        for (int i = 0; i < vlen; i++){
            for (int j = 0; j < vlen; j++){
            	System.out.print(relation[i][j]+ "             ");
            }
        	System.out.println();
    	}
    }

    public void dijkstra(int vs, int[] prev, int[] dist) {
        boolean[] flag = new boolean[node.length];
        
        for (int i = 0; i < node.length; i++) {
            flag[i] = false;          // 顶点i的最短路径还没获取到。
            prev[i] = 0;              // 顶点i的前驱顶点为0。
            dist[i] = relation[vs][i];  // 顶点i的最短路径为"顶点vs"到"顶点i"的权。
        }

        flag[vs] = true;
        dist[vs] = 0;

        int k=0;
        for (int i = 1; i < node.length; i++) {
            int min = INF;
            for (int j = 0; j < node.length; j++) {
                if (flag[j]==false && dist[j]<min) {
                    min = dist[j];
                    k = j;
                }
            }
            flag[k] = true;
            for (int j = 0; j < node.length; j++) {
                int tmp = (relation[k][j]==INF ? INF : (min + relation[k][j]));
                if (flag[j]==false && (tmp<dist[j]) ) {
                    dist[j] = tmp;
                    prev[j] = k;
                }
            }
        }
        System.out.printf("dijkstra(%c): \n", node[vs]);
        for (int i=0; i < node.length; i++){
            System.out.printf("  shortest(%c, %c)=%d\n", node[vs], node[i], dist[i]);
        }
    }

    public static void main(String[] args) {
        char[] vexs = {'1', '2', '3', '4', '5'};
        int matrix[][] = {
         {   0,   5, INF,   3, INF},
         {   5,   0,   2, INF, INF},
         { INF,   2,   0, INF,   1},
         {   3, INF, INF,   0, INF},
         { INF, INF,   1, INF,   0},};
        MatrixUDG pG;

        pG = new MatrixUDG(vexs, matrix);
        int[] prev = new int[pG.node.length];
        int[] dist = new int[pG.node.length];
        pG.dijkstra(1, prev, dist);
    }
}