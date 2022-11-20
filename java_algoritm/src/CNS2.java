public class CNS2 {

    private static class Multitab {
        public int amount;
        public int limit;
        public Multitab parent = null;

        public Multitab(int limit) {
            this.limit = limit;
        }

        public void connect(Multitab parent) {
            this.parent = parent;
        }

        public static void addAmount(Multitab multitab) {
            if (multitab.parent == null) {
                return;
            }
            multitab.parent.amount += multitab.amount;
        }

        public static void remove(Multitab multitab, int removeAmount) {

            Multitab node = multitab;

            while (node.parent != null) {
                node.parent.amount -= removeAmount;
                node = node.parent;
            }
        }

    }

    public static int solution(int k, int[] limits, int[][] sockets) {
        int answer = 0;
        Multitab[] multitabs = new Multitab[limits.length];

        for (int i = 0; i < limits.length; i++) {
            multitabs[i] = new Multitab(limits[i]);
        }

        for (int i = 0; i < sockets.length; i++) {
            for (int j = 0; j < sockets[i].length; j++) {
                if (sockets[i][j] == 0) continue;
                if (sockets[i][j] != -1) {
                    multitabs[sockets[i][j]-1].connect(multitabs[i]);
                } else {
                    multitabs[i].amount += k;
                }
            }
        }

        for (int i = multitabs.length - 1; i >= 0; i--) {
            Multitab.addAmount(multitabs[i]);
        }

        for (int i = multitabs.length - 1; i >= 0; i--) {
            int removeAmount = 0;
            while (multitabs[i].amount > multitabs[i].limit) {
                answer++;
                multitabs[i].amount -= k;
                removeAmount += k;
            }
            Multitab.remove(multitabs[i], removeAmount);
        }

        return answer;
    }

    public static void main(String[] args) {
        int k = 300;
        int[] limits = {2000, 1000, 3000, 200, 600, 500};
        int[][] sockets = {{2, 3, -1, -1, -1}, {4, 0, -1, -1, 6}, {5, 0, 0, 0, 0}, {-1, 0, 0, 0, 0}, {-1, -1, -1, -1,
                -1}, {-1, -1, 0, 0, 0}};

//        int k = 120;
//        int[] limits = {1500, 300, 250, 359, 600};
//        int[][] sockets = {{2, 3, 4, 0, -1}, {0, 0, 0, 0, 0}, {-1, -1, -1, 0, 0}, {0, 0, 5, 0, 0}, {-1, 0, 0, -1, -1}};
        System.out.println(solution(k, limits, sockets));
    }
}
