class TheGameOfLife {

    void startLife() {
        /*Zadanie 7*/
        int size = 6; //dane z zadania
        boolean[][] firstLife, secondLife;
        boolean[][][] tempLife = new boolean[size][size][8];
        firstLife = createWorld(size, size);
        secondLife = firstLife;

        updateStages(firstLife, tempLife);
        drawWorld(firstLife);

        int stageCount = 4; //Tyle ile w przykładzie.
        for (int i = 0; i < stageCount / 2; i++) {
            createStage(firstLife, secondLife, tempLife);
            createStage(secondLife, firstLife, tempLife);
        }
    }

    private void createStage(boolean[][] firstLife, boolean[][] secondLife, boolean[][][] tempLife) {
        int count = 0;
        for (int k = 0; k < secondLife.length; k++) {
            for (int m = 0; m < secondLife.length; m++) {
                for (int n = 0; n < 8; n++) {
                    count += Boolean.compare(tempLife[k][m][n], false);
                }
                if (!firstLife[k][m] && count == 3) secondLife[k][m] = true;
                else if (firstLife[k][m] && count > 3 || count < 2) secondLife[k][m] = false;
                count = 0;
            }
        }
        updateStages(secondLife, tempLife);
        drawWorld(secondLife);
    }

    private void drawWorld(boolean[][] table) {
        for (boolean[] aTable : table) {
            for (int j = 0; j < table.length; j++) {
                if (aTable[j]) System.out.printf("%2s", "#");
                else System.out.printf("%2s", ".");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    private void updateStages(boolean[][] firstLife, boolean[][][] tempLife) {
        /*Do zadania 7*/

        int n = firstLife.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tempLife[i][j][0] = firstLife[(i + n - 1) % n][(j + n - 1) % n];
                tempLife[i][j][1] = firstLife[(i + n - 1) % n][(j + n) % n];
                tempLife[i][j][2] = firstLife[(i + n - 1) % n][(j + n + 1) % n];
                tempLife[i][j][3] = firstLife[(i + n) % n][(j + n - 1) % n];
                tempLife[i][j][4] = firstLife[(i + n) % n][(j + n + 1) % n];
                tempLife[i][j][5] = firstLife[(i + n + 1) % n][(j + n - 1) % n];
                tempLife[i][j][6] = firstLife[(i + n + 1) % n][(j + n) % n];
                tempLife[i][j][7] = firstLife[(i + n + 1) % n][(j + n + 1) % n];
                /*Stan dla każdego elementu tablicy.
                * Każdy element tablicy posiada ośmmiu sąsiadów,
                * dla których jest wyznaczany stan, by
                * wiedzieć czy "istnieją" żywi i później policzyć ich ilość.*/
            }
        }
    }

    private boolean[][] createWorld(int x, int y) {
        /*Do zadania 7*/
        boolean[][] table = new boolean[x][y];

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                table[i][j] = false;
            }
        }

        //dane z zadania (wzorzec wiecznie żywy):
        table[1][4] = true;
        table[2][5] = true;
        table[3][3] = true;
        table[3][4] = true;
        table[3][5] = true;

        return table;
    }
}