package challenges;

public class Challenges {
    /**
     * https://app.codesignal.com/challenge/SbeYgDCw7m2zmQCAC
     * @param n
     * @return
     */
    int iceBlocks(int n) {
        if (n < 2) return 1;
        else {
            long fn_1 = 1;
            long fn_2 = 1;
            long fn = 0;
            long m = (long) (1e9 + 7);
            for (int i = 2; i <= n; i++) {
                fn = ((fn_1 + fn_2 * (i - 1)) % m + m) % m;
                fn_2 = fn_1;
                fn_1 = fn;
            }
            return (int) fn;
        }
    }

    /**
     * https://app.codesignal.com/challenge/cBPwPuje9WfuFza9w
     * @param area
     * @return
     */
    int bugBGone(int[][] area) {
        return valid(run(area, 0, 0, area.length));
    }
    
    int run(int[][] area, int X, int Y, int N) {
        boolean f = N == 2;
        N = N / 2;
        int a = f ? area[X][Y] : run(area, X, Y, N);
        int b = f ? area[X][Y + N] : run(area, X, Y + N, N);
        int c = f ? area[X + N][Y] : run(area, X + N, Y, N);
        int d = f ? area[X + N][Y + N] : run(area, X + N, Y + N, N);
        int k = a + b + c + d;
        if (k > 1) k = valid(a) + valid(b) + valid(b) + valid(c);
        return k;
    }

    int valid(int x) {
        return x == 0 ? 1 : x;
    }


    static void printArr(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Challenges challenges = new Challenges();
        int[][] a = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        System.out.println(challenges.bugBGone(a));
    }
}