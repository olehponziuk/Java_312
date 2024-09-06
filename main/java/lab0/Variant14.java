package lab0;

import java.util.Arrays;


public class Variant14 {
    /*   Дано масив A розміру  N. Вивести спочатку
       його елементи з парними номерами , а потім 151; елементи
       з непарними номерами (також у порядку зростання
       номерів):
       A 2,  A 4, A 6, …,  A 1, A 3,A 5,… .
    */
    //1, 5, 6, 7
    //1, 6, 5, 7
    public int[][] arrayTask14(int[] arr) {
        int n = arr.length;
        int[][] res = new int[][]{
                new int[n],
                new int[n / 2 + n % 2],
                new int[n / 2]};
        res[0] = arr;

        int j = 0,q = 0;
        for(int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                res[1][j++] = arr[i];
            } else {
                res[2][q++] = arr[i];
            }
        }
        Arrays.sort(res[1]);
        Arrays.sort(res[2]);

        return res;

    }

    /* Дано три цілих числа: A, B, C.
    Перевірити істинність висловлювання:
    «Рівно одне з чисел A, B, C позитивне»*/
    public boolean booleanTask14(int A, int B, int C) {
            return A > 0 && B < 0 && C < 0 || A < 0 && B > 0 && C < 0 || A < 0 && B < 0 && C > 0;
    }

    /*Елементи рівностороннього трикутника пронумеровані
     в такий спосіб: 1 — сторона a, 2 — радіус R1
    вписаного кола (R1 = a ·(3)1/2/6), 3 — радіус R2
     описаного кола (R2 = 2·R 1),
     4 — площа S = a2·(3)1/2/4. Даний номер одного
     з цих елементів і його значення.
     Вивести значення решти елементів даного
     трикутника (в тому ж порядку).*/
    private double[] caseHelperSide(double A) {
        return new double[] {A, A*Math.sqrt(3.0)/6.0, A*Math.sqrt(3.0)/3.0,A*A*Math.sqrt(3.0)/4};
    }
    private double[] caseHelperRadius1(double B) {
        return new double[] {B/Math.sqrt(3.0)*6.0, B, 12*B/Math.sqrt(3.0) ,3.0*B*B*Math.sqrt(3.0)};
    }
    private double[] caseHelperRadius2(double C) {
        return new double[] {3.0*C/Math.sqrt(3.0), C*0.5, C, 3.0 * C*C*Math.sqrt(3.0)/4.0};
    }
    private double[] caseHelperArea(double D) {
        double A =Math.sqrt((4*D/Math.sqrt(3)));
        return new double[] {A, A*Math.sqrt(3.0)/6.0, A*Math.sqrt(3.0)/3.0, D};
    }

    private boolean exp(double[] A, double[] B) {
        if (A.length != B.length)
            return false;
        for(int i = 0; i < A.length; i++) {
            A[i] = B[i];
        }

        return true;
    }

    public double[] caseTask14(int n, double value) {
        if(n < 1 || n > 4)
            n = 1;
        double[] arr = new double[4];

        switch (n){
            case 1:
                exp(arr, caseHelperSide(value));
                break;
            case 2:
                exp(arr, caseHelperRadius1(value));
                break;
            case 3:
                exp(arr, caseHelperRadius2(value));
                break;
            case 4:
                exp(arr, caseHelperArea(value));
                break;
        }

        return new double[] {arr[0], arr[1], arr[2], arr[3]};
    }

    /*Дано целое число N (> 0). Знайдіть квадрат цього числа,
    використовуючи для його вирахування наступну формулу:N2 = 1 + 3 + 5 + … + (2·N – 1).
    Після додавання до суми кожного вкладеного виводиться поточне значення
     суми (в результаті будуть виведені квадрати всіх цілих чисел від 1 до N).*/
    public long forTask14(int N) {
        long Sum = 0L;
        for (int i = 1; i <= N; i++) {
            Sum += 2L *i - 1L;
        }
        return Sum;
    }

    /*Дана квадратна матриця A порядку M.
    Починаючи з елемента 1,1, вивести її елементами
     наступним чином (куточками): все . ;
     елементи першого стовпця; елементи останнього рядка,
     крім першого (вже виведеного) елемента; елементи
     другого стовпця, що залишилися; елементи, що залишилися
     передостаннього рядка і т. д.; останнім виводиться елемент A1,M.*/
    public int[][] matrixTask14(int[][] matrix) {
        if(matrix.length != matrix[0].length)
            return null;

        int r = 0, countRow = matrix[0].length - 1;
        int n = matrix.length;

        int Res[][] = new int[2*n - 1][];
        for(int i = 0; i < n;) {
            Res[r] = new int[n - i];
            for(int j = 0; j < n - i; j++) {
                Res[r][j] = matrix[j][i];
            }
            i++;
            r++;
            if(i == n)
                break;
            Res[r] = new int[n - i];
            int k = 0;
            for(int j = i; j < n; j++) {
                Res[r][k] = matrix[countRow][j];
                k++;
            }
            r++;
            countRow--;
        }

        return Res;
    }

    /*Дано три числа. Вивести
    спочатку найменше, а потім
    найбільше з даних чисел.*/
    public int[] ifTask14(int A, int B, int C)
    {
        int tmp;
        if(B >= A && B >= C) {
            tmp = A;
            A = B;
            B = tmp;
        }
        else if(C >= A) {
            tmp = A;
            A = C;
            C = tmp;
        }

        if(C < B){
            B = C;
        }


        return new int[] {B, A};
    }

    /*Дано число A (> 1). Вивести найбільше з цілих чиселК, для
    яких сума 1 + 1/2 + … + 1/K буде менше A, і саму цю суму.*/
    public double[] whileTask14(double A)
    {
        double[] res = new double[2];
        double k = 1.0, Sum = 0.0, PrevSum = 0.0;
        while (Sum < (double) A){
            PrevSum = Sum;
            Sum += 1.0/k;
            k++;
        }
        res[1] = PrevSum;
        res[0] = k - 1;

        return res;
    }
    /*Дано тризначне число. В ньому закреслили першу справа
    цифру і приписали її зліва. Вивести отримане число.*/

    public int integerTask14(int d)
    {
        int tmp = d % 10;
        d = d / 10;
        d = tmp * 100 + d;
        return d;
    }

    public static void main(String... strings) {
        System.out.println("Start of zero lab");
        System.out.println("Done!!!");
    }

}
