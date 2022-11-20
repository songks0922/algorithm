public class CNS4 {
    public static class Node {
        boolean parent = false;
        int value = 0;

        public Node(boolean isParent, int value) {
            this.parent = isParent;
            this.value = value;
        }

        public void set(boolean isParent, int value) {
            this.parent = isParent;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{1, 3}, {1, 2}, {2, 4}, {2, 5}};
        Node[][] adjList = new Node[edges.length + 1][edges.length + 1];

        for (int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]-1][edges[i][1]-1] = new Node(true, 1);
            adjList[edges[i][1]-1][edges[i][0]-1] = new Node(false, 1);
        }

        for (int i = 0; i < adjList.length; i++) {
            for (int j = 0; j < adjList[i].length; j++) {
                System.out.print(adjList[i][j].value + " ");
            }
            System.out.println();
        }
    }
}
