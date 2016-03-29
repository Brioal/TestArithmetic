package third;

/**
 * 华为校招测试题
 * Created by Brioal on 2016/3/29.
 */
public class Demo17 {
    char[] target = "SOLO".toCharArray();
    int row = 5;
    int clo = 5;
    char[][] data = new char[row][clo];

    public static void main(String[] args) {
        new Demo17();
    }

    public void initData() {
        data[0] = "POKJH".toCharArray();
        data[1] = "POIOU".toCharArray();
        data[2] = "SLOKJ".toCharArray();
        data[3] = "OLHGT".toCharArray();
        data[4] = "AOIOU".toCharArray();
    }

    public Demo17() {
        initData();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < clo; j++) {
                if (data[i][j] == target[0]) {
                    if (!Itetation(i, j, 1)) {
                        continue;

                    } else {
                        System.out.println("YES");
                        System.exit(0);
                    }
                    initData(); // 每次改变后重新置数
                }
            }
        }
        System.out.println("NO");
    }


    public boolean Itetation(int i, int j, int flag) {
        if (flag == target.length) {
            return true;
        } else {
            if (i > 0 && data[i - 1][j] == target[flag]) {
                //标志为已经被吃掉
                data[i][j] = 's';
                return Itetation(i - 1, j, ++flag);
            } else if (j + 1 < clo && data[i][j + 1] == target[flag]) {
                data[i][j] = 's';
                return Itetation(i, j + 1, ++flag);

            } else if (i + 1 < row && data[i + 1][j] == target[flag]) {
                data[i][j] = 's';
                return Itetation(i + 1, j, ++flag);

            } else if (j > 0 && data[i][j - 1] == target[flag]) {
                data[i][j] = 's';
                return Itetation(i, j - 1, ++flag);
            } else {
                return false;
            }
        }
    }
}
