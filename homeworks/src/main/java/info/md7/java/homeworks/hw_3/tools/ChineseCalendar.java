package info.md7.java.homeworks.hw_3.tools;

public class ChineseCalendar {

    /**
     * Рассчет пола будущего ребенка по китайскому календарю
     * @param mothersAge
     * @param month
     * @return
     * @see <a href="https://www.google.com/search?q=chinese+calendar+child+gender&newwindow=1&client=firefox-b-d&sxsrf=ALeKk00wPKhMRG31W6TI54RTgTZzTj2Tog:1589861431085&source=lnms&tbm=isch&sa=X&ved=2ahUKEwiF092uh7_pAhXE-yoKHbEUCHUQ_AUoAXoECAwQAw&biw=1600&bih=758#imgrc=sBxpT4Yj9WqrGM">Google</a>
     */
    public static String calculate(int mothersAge, int month) {

        int [] [] array = new int[28][12];

        // January
        array[0][0] = 1;
        array[1][0] = 1;
        array[2][0] = 0;
        array[3][0] = 1;
        array[4][0] = 0;
        array[5][0] = 1;
        array[6][0]= 1;
        array[7][0]= 1;
        array[8][0]= 0;
        array[9][0]= 1;
        array[10][0]= 0;
        array[11][0]= 1;
        array[12][0]= 0;
        array[13][0]= 1;
        array[14][0]= 1;
        array[15][0]= 1;
        array[16][0]= 0;
        array[17][0]= 1;
        array[18][0]= 0;
        array[19][0]= 1;
        array[20][0]= 0;
        array[21][0]= 1;
        array[22][0]= 0;
        array[23][0]= 1;
        array[24][0]= 0;
        array[25][0]= 1;
        array[26][0]= 1;
        array[27][0]= 0;

        // February
        array[0][1] = 0;
        array[1][1] = 0;
        array[2][1] = 1;
        array[3][1] = 0;
        array[4][1] = 1;
        array[5][1] = 1;
        array[6][1]= 0;
        array[7][1]= 1;
        array[8][1]= 0;
        array[9][1]= 1;
        array[10][1]= 0;
        array[11][1]= 1;
        array[12][1]= 0;
        array[13][1]= 0;
        array[14][1]= 0;
        array[15][1]= 1;
        array[16][1]= 0;
        array[17][1]= 1;
        array[18][1]= 1;
        array[19][1]= 0;
        array[20][1]= 1;
        array[21][1]= 0;
        array[22][1]= 1;
        array[23][1]= 0;
        array[24][1]= 1;
        array[25][1]= 0;
        array[26][1]= 1;
        array[27][1]= 1;

        // March
        array[0][2]= 1;
        array[1][2]= 1;
        array[2][2]= 0;
        array[3][2]= 0;
        array[4][2]= 1;
        array[5][2]= 0;
        array[6][2]= 1;
        array[7][2]= 1;
        array[8][2]= 1;
        array[9][2]= 0;
        array[10][2]= 1;
        array[11][2]= 0;
        array[12][2]= 0;
        array[13][2]= 1;
        array[14][2]= 1;
        array[15][2]= 0;
        array[16][2]= 1;
        array[17][2]= 0;
        array[18][2]= 1;
        array[19][2]= 1;
        array[20][2]= 0;
        array[21][2]= 1;
        array[22][2]= 0;
        array[23][2]= 1;
        array[24][2]= 0;
        array[25][2]= 1;
        array[26][2]= 0;
        array[27][2]= 1;

        //April
        array[0][3]= 0;
        array[1][3]= 0;
        array[2][3]= 1;
        array[3][3]= 0;
        array[4][3]= 0;
        array[5][3]= 1;
        array[6][3]= 1;
        array[7][3]= 0;
        array[8][3]= 0;
        array[9][3]= 1;
        array[10][3]= 0;
        array[11][3]= 0;
        array[12][3]= 0;
        array[13][3]= 0;
        array[14][3]= 0;
        array[15][3]= 1;
        array[16][3]= 0;
        array[17][3]= 1;
        array[18][3]= 0;
        array[19][3]= 1;
        array[20][3]= 1;
        array[21][3]= 1;
        array[22][3]= 1;
        array[23][3]= 0;
        array[24][3]= 1;
        array[25][3]= 0;
        array[26][3]= 1;
        array[27][3]= 0;

        // May
        array[0][4]= 1;
        array[1][4]= 1;
        array[2][4]= 1;
        array[3][4]= 0;
        array[4][4]= 1;
        array[5][4]= 1;
        array[6][4]= 0;
        array[7][4]= 0;
        array[8][4]= 0;
        array[9][4]= 0;
        array[10][4]= 0;
        array[11][4]= 1;
        array[12][4]= 0;
        array[13][4]= 0;
        array[14][4]= 0;
        array[15][4]= 0;
        array[16][4]= 0;
        array[17][4]= 0;
        array[18][4]= 1;
        array[19][4]= 0;
        array[20][4]= 1;
        array[21][4]= 1;
        array[22][4]= 0;
        array[23][4]= 1;
        array[24][4]= 0;
        array[25][4]= 1;
        array[26][4]= 1;
        array[27][4]= 0;

        // June
        array[0][5]= 1;
        array[1][5]= 1;
        array[2][5]= 1;
        array[3][5]= 0;
        array[4][5]= 0;
        array[5][5]= 0;
        array[6][5]= 1;
        array[7][5]= 1;
        array[8][5]= 1;
        array[9][5]= 0;
        array[10][5]= 0;
        array[11][5]= 1;
        array[12][5]= 0;
        array[13][5]= 0;
        array[14][5]= 0;
        array[15][5]= 0;
        array[16][5]= 0;
        array[17][5]= 0;
        array[18][5]= 0;
        array[19][5]= 1;
        array[20][5]= 0;
        array[21][5]= 0;
        array[22][5]= 1;
        array[23][5]= 0;
        array[24][5]= 1;
        array[25][5]= 0;
        array[26][5]= 1;
        array[27][5]= 0;

        // July
        array[0][6]= 1;
        array[1][6]= 1;
        array[2][6]= 1;
        array[3][6]= 0;
        array[4][6]= 0;
        array[5][6]= 1;
        array[6][6]= 1;
        array[7][6]= 0;
        array[8][6]= 0;
        array[9][6]= 1;
        array[10][6]= 1;
        array[11][6]= 0;
        array[12][6]= 0;
        array[13][6]= 0;
        array[14][6]= 0;
        array[15][6]= 0;
        array[16][6]= 0;
        array[17][6]= 0;
        array[18][6]= 0;
        array[19][6]= 0;
        array[20][6]= 1;
        array[21][6]= 0;
        array[22][6]= 1;
        array[23][6]= 1;
        array[24][6]= 0;
        array[25][6]= 1;
        array[26][6]= 0;
        array[27][6]= 1;

        // August
        array[0][7]= 1;
        array[1][7]= 1;
        array[2][7]= 1;
        array[3][7]= 0;
        array[4][7]= 1;
        array[5][7]= 0;
        array[6][7]= 0;
        array[7][7]= 1;
        array[8][7]= 1;
        array[9][7]= 1;
        array[10][7]= 1;
        array[11][7]= 0;
        array[12][7]= 0;
        array[13][7]= 0;
        array[14][7]= 0;
        array[15][7]= 1;
        array[16][7]= 0;
        array[17][7]= 1;
        array[18][7]= 0;
        array[19][7]= 1;
        array[20][7]= 0;
        array[21][7]= 1;
        array[22][7]= 0;
        array[23][7]= 1;
        array[24][7]= 1;
        array[25][7]= 0;
        array[26][7]= 1;
        array[27][7]= 0;

        // September
        array[0][8]= 1;
        array[1][8]= 1;
        array[2][8]= 1;
        array[3][8]= 0;
        array[4][8]= 0;
        array[5][8]= 1;
        array[6][8]= 0;
        array[7][8]= 1;
        array[8][8]= 0;
        array[9][8]= 1;
        array[10][8]= 1;
        array[11][8]= 0;
        array[12][8]= 0;
        array[13][8]= 0;
        array[14][8]= 0;
        array[15][8]= 0;
        array[16][8]= 0;
        array[17][8]= 0;
        array[18][8]= 1;
        array[19][8]= 0;
        array[20][8]= 1;
        array[21][8]= 0;
        array[22][8]= 1;
        array[23][8]= 0;
        array[24][8]= 1;
        array[25][8]= 1;
        array[26][8]= 0;
        array[27][8]= 1;

        // October
        array[0][9]= 1;
        array[1][9]= 0;
        array[2][9]= 0;
        array[3][9]= 0;
        array[4][9]= 0;
        array[5][9]= 1;
        array[6][9]= 0;
        array[7][9]= 1;
        array[8][9]= 0;
        array[9][9]= 1;
        array[10][9]=1;
        array[11][9]= 1;
        array[12][9]= 0;
        array[13][9]= 0;
        array[14][9]= 0;
        array[15][9]= 0;
        array[16][9]= 0;
        array[17][9]= 0;
        array[18][9]= 1;
        array[19][9]= 1;
        array[20][9]= 0;
        array[21][9]= 0;
        array[22][9]= 0;
        array[23][9]= 1;
        array[24][9]= 0;
        array[25][9]= 1;
        array[26][9]= 1;
        array[27][9]= 0;

        // November
        array[0][10]= 1;
        array[1][10]= 1;
        array[2][10]= 1;
        array[3][10]= 0;
        array[4][10]= 0;
        array[5][10]= 1;
        array[6][10]= 0;
        array[7][10]= 1;
        array[8][10]= 0;
        array[9][10]= 0;
        array[10][10]= 0;
        array[11][10]= 1;
        array[12][10]= 1;
        array[13][10]= 0;
        array[14][10]= 0;
        array[15][10]= 0;
        array[16][10]= 1;
        array[17][10]= 1;
        array[18][10]= 1;
        array[19][10]= 0;
        array[20][10]= 1;
        array[21][10]= 0;
        array[22][10]= 1;
        array[23][10]= 0;
        array[24][10]= 1;
        array[25][10]= 1;
        array[26][10]= 0;
        array[27][10]= 1;

        // December
        array[0][11]= 1;
        array[1][11]= 0;
        array[2][11]= 1;
        array[3][11]= 0;
        array[4][11]= 0;
        array[5][11]= 0;
        array[6][11]= 0;
        array[7][11]= 1;
        array[8][11]= 0;
        array[9][11]= 1;
        array[10][11]= 0;
        array[11][11]= 1;
        array[12][11]= 1;
        array[13][11]= 1;
        array[14][11]= 1;
        array[15][11]= 1;
        array[16][11]= 1;
        array[17][11]= 1;
        array[18][11]= 1;
        array[19][11]= 1;
        array[20][11]= 0;
        array[21][11]= 0;
        array[22][11]= 0;
        array[23][11]= 1;
        array[24][11]= 0;
        array[25][11]= 1;
        array[26][11]= 0;
        array[27][11]= 1;

        int ageIndex = mothersAge - 18;

        int monthIndex = month - 1;

        int i = array[ageIndex][monthIndex];

        if ( i==1 ) {
            return "мальчик";
        } else {
            return "девочка";
        }

    }

}
