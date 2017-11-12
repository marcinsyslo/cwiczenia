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
        for (int k = 1; k < secondLife.length - 2; k++) {
            for (int m = 1; m < secondLife.length - 2; m++) {
                for (int n = 0; n < 8; n++) {
                    count += Boolean.compare(tempLife[k-1][m-1][n], false);
                }
                if (!firstLife[k][m] && count == 3) secondLife[k][m] = true;
                else if (firstLife[k][m] && count > 3 || count < 2) secondLife[k][m] = false;
                count = 0;
            }
        }
        updateWorld(secondLife);
        updateStages(secondLife, tempLife);
        drawWorld(secondLife);
    }

    private void drawWorld(boolean[][] table) {
        for (int i = 1; i < table.length - 1; i++) {
            for (int j = 1; j < table.length - 1; j++) {
                if (table[i][j]) System.out.printf("%2s","#");
                else System.out.printf("%2s",".");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    private void updateStages(boolean[][] firstLife, boolean[][][] tempLife) {
        /*Do zadania 7*/

        /*Wartości brzegowe ([0][0] itp.) odpowiadają wartościom po przeciwnych
        * stronach "świata" gry. Aby kopiować te wartości po każdym
        * cyklu, stosuje się funkcję updateWorld()*/

        for (int i = 0; i < firstLife.length - 2; i++) {
            for (int j = 0; j < firstLife.length - 2; j++) {
                tempLife[i][j][0] = firstLife[i][(j)];
                tempLife[i][j][1] = firstLife[i][(j + 1)];
                tempLife[i][j][2] = firstLife[i][(j + 2)];
                tempLife[i][j][3] = firstLife[i + 1][(j)];
                tempLife[i][j][4] = firstLife[i + 1][(j + 2)];
                tempLife[i][j][5] = firstLife[i + 2][(j)];
                tempLife[i][j][6] = firstLife[i + 2][(j + 1)];
                tempLife[i][j][7] = firstLife[i + 2][(j + 2)];
                /*Stan dla każdego elementu tablicy.
                * Każdy element tablicy posiada ośmmiu sąsiadów,
                * dla których jest wyznaczany stan, by
                * wiedzieć czy "istnieją" żywi i później policzyć ich ilość.*/
            }
        }
    }

    private boolean[][] createWorld(int x, int y) {
        /*Do zadania 7*/
        boolean[][] table = new boolean[x + 2][y + 2]; // +2 aby posiadać miejsce na wartości brzegowe świata.

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

        updateWorld(table); //Aby uzupełnić wartości brzegowe.

        return table;
    }

    private void updateWorld(boolean[][] table) {
        /*Do zadania 7*/

        /*Kopiowanie wartości brzegowych tablicy.
        * musi być wykonywane po każdym cyklu.*/

        for (int i = 0; i < table.length; i++) {
            table[0][i] = table[table.length - 2][i];
            table[table.length - 2][i] = table[1][i];
            table[i][0] = table[i][table.length - 2];
            table[i][table.length - 2] = table[i][1];
        }

        //Kopiowanie narożników
        table[0][0] = table[table.length - 2][table.length - 2];
        table[table.length - 1][table.length - 1] = table[1][1];
        table[0][table.length - 1] = table[table.length - 2][1];
        table[table.length - 1][0] = table[1][table.length - 2];
    }
}