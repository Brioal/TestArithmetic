#16-3-28华为校招测试题答案,思考和总结
###昨晚参加了机试题的体验,只做对了两道,今早把第三道做出来了,虽然不知道对不对,但是做个总结,整理一下思路.

###机试体验题一共三道,满分600,第一题100,第二题200,第三题300,因为好像是体验,所以没有运算时间限制,总成绩100以上合格.
###前两道是2015的华为校招机试题的一二题,难度一般但是有一些技巧,直接看题吧.

###1.10个学生考完期末考试评卷完成后，老师需要划出及格线，要求如下:
(1) 及格线是 10 的倍数；
(2) 保证至少有 60%的学生及格；
(3) 如果所有的学生都高于 60 分，则及格线为 60 分".
###输入:十个同学的成绩
###输出:平均分
###第一题较简单,没有什么技巧可言,基本思路加上注意给定的条件即可,直接看代码,代码内有注释:
```
public class Demo1 {
    //及格线的范围为0-60
    //只会有6个取值
    //统计每个取值的人数
    //如果人数超过6 ，则直接确定为及格线
    //否则累加到下一级，下一级判断是否超过6个

    /**
     * 步骤：
     * 1.方法传入存储分数的数组
     * 2.通过循环获取到各个分数段的人数， 以60为界
     * 3.通过判断分数段的人数来确定及格分 人数大于等于6 的下标乘于10即为及格线
     */
    private int[] indexs = new int[7];
    private int mark  ;

    public Demo1(int[] scores) {
        //初始化数组
        for (int i = 0; i < indexs.length; i++) {
            indexs[i] = 0;
        }
        mark = 0 ;
        //获取各个阶段的人数
        for (int i = 0; i < scores.length; i++) {
            switch (scores[i] / 10) {
                case 0:
                    indexs[0]++;
                    break;
                case 1:
                    indexs[1]++;
                    break;
                case 2:
                    indexs[2]++;
                    break;
                case 3:
                    indexs[3]++;
                    break;
                case 4:
                    indexs[4]++;
                    break;
                case 5:
                    indexs[5]++;
                    break;
                case 6:
                    indexs[6]++;
                    break;
                default:indexs[6]++;
            }
        }
        //数据判断
        for (int i = 6; i >0; i--) {
            if (indexs[i] >= 6) {
                mark = i * 10; // 保证最高为60 ， 保证60%及格 ， 保证10额倍数
                break;
            } else {
                indexs[i - 1] = indexs[i - 1] + indexs[i];
            }
        }
        //输出数据
        System.out.println("及格分为："+mark);
    }

    public static void main(String[] args) {
        int[] scores = new int[10];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = 0 ;
        }
        //数据录入
        Scanner keyin= new Scanner(System.in);
        int score = 0 ;
        for (int i = 0; i < 10; i++) {
            score = keyin.nextInt();
            scores[i] = score;
        }
        //打印输出
        new Demo1(scores);
    }
}
```

###2.一条长廊里依次装有 n(1≤n≤65535) 盏电灯，从头到尾编号 1 、 2 、 3 、... n-1  、 n 。
      每盏电灯由一个拉线开关控制。开始，电灯全部关着。 有 n 个学生从长廊穿过。第一个学生把号码凡是1的倍数的电灯的开关拉一下；接着第二 学生把号码凡是2的倍数的电灯的开关拉一下；接着第三个学生把号码凡是3的倍数的电灯的开关拉一下；如此继续下去，最后第n个学生把号码凡是n的倍数的电灯的开关拉一下。求n个学生按此规定走完后，长廊里电灯有几盏亮着。
      注：电灯数和学生数一致
###提供两种思路,一是按照基本的思路来进行循环,第二种是找到规律后走捷径,注释都在代码里面(估计第一种方法提交之后100分至少是有的,第二种满分)
###2015年机试的时候要求运行时间在10秒内,第一种方法,低级用例妥妥的,最大值估计会超时,我用固态和12g内存跑11秒左右)
```
public class Demo2 {
    public static void main(String[] args) {
//        new Demo2_1();    //结果255  耗时：10226
        new Demo2_2();  //结果255  耗时：21
    }


}
//常规思路
class Demo2_1 {
    private int sum = 0;

    public Demo2_1() {
        long start = System.currentTimeMillis();
        for (int i = 1; i <= 65535; i++) {
            int index = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    index++;
                }
            }
            if (index % 2 != 0) {
                sum++;
            }
        }
        System.out.println("耗时:"+(System.currentTimeMillis()-start));
        System.out.println(sum);
    }
}

//求完全平方数
class Demo2_2{
    private int sum = 0 ;
    public Demo2_2() {
        long start = System.currentTimeMillis();
        for (int i = 1; i <= 65535; i++) {
            for (int j = 1; j <= i; j++) {
                if (j * j > i) {
                    break;
                }
                if (j * j == i) {
                    sum++;
                }
            }
        }
        System.out.println("耗时:"+(System.currentTimeMillis()-start));
        System.out.println(sum);
    }
}
```

###3.第三题保存的网页出问题了,变成了下面这样:
![这里写图片描述](http://img.blog.csdn.net/20160329125037309)
 
###大概能看懂吧,昨晚没做出来,今早尝试了一下迭代,低级用例应该是没问题的,所以贴一下代码,希望能一起交流一下更完善的代码(为了方便测试,所以没使用输入,直接指定的内容)
```
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

```
###菜鸟一枚,欢迎交流 QQ:821329382
