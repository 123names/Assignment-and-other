package t3;

public class MatrixUDG {

    private char[] node;       // ���㼯��
    private int[][] relation;    // �ڽӾ���
    private static final int INF = Integer.MAX_VALUE;   // ���ֵ


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
            flag[i] = false;          // ����i�����·����û��ȡ����
            prev[i] = 0;              // ����i��ǰ������Ϊ0��
            dist[i] = relation[vs][i];  // ����i�����·��Ϊ"����vs"��"����i"��Ȩ��
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