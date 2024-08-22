package var14;

public class Variant14 {
/*   Дано масив A розміру  N . Вивести спочатку
    його елементи з парними номерами (в порядку
    зростання номерів), а потім потім 151; елементи
    з непарними номерами (також у порядку зростання
    номерів):
    A 2,  A 4, A 6, …,  A 1, A 3,A 5,… .
*/
    public void ArrayTask14(int[] arr) {
        System.out.println("З парпними номерами:");
        for (int i = 0; i < arr.length; i+=2) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nЗ непарпними номерами:");
        for (int i = 1; i < arr.length; i+=2) {
            System.out.print(arr[i] + " ");
        }
    }

    /* Дано три цілих числа: A, B, C.
    Перевірити істинність висловлювання:
    «Рівно одне з чисел A, B, C позитивне»*/
    public boolean BooleanTask14(int A, int B, int C) {
        if (A > 0 && B < 0 && C < 0)
            return true;
        else if (A < 0 && B > 0 && C < 0)
            return true;
        else if (A < 0 && B < 0 && C > 0)
            return true;
        else
            return false;
    }

    /*Елементи рівностороннього трикутника пронумеровані
     в такий спосіб: 1 — сторона a, 2 — радіус R1
     вписаного кола (R1 = a ·(3)1/2/6), 3 — радіус R2
     описаного кола (R2 = 2·R 1),
     4 — площа S = a2·(3)1/2/4. Даний номер одного
     з цих елементів і його значення.
     Вивести значення решти елементів даного
     трикутника (в тому ж порядку).*/
    private double[] CaseHelper1(double A) {
        return new double[] {A, A*Math.sqrt(3.0)/6.0, A*Math.sqrt(3.0)/3.0,A*A*Math.sqrt(3.0)/4};
    }

    private double[] CaseHelper2(double B) {
        return new double[] {B/Math.sqrt(3.0)/6.0, B, 18*B ,12.0*B*B*Math.sqrt(3.0)/4};
    }

    private double[] CaseHelper3(double C) {
        return new double[] {0.5*C/Math.sqrt(3.0)/6.0, C*0.5, C, 0.5*C/Math.sqrt(3.0)/6.0*0.5*C/Math.sqrt(3.0)/6.0*Math.sqrt(3.0)/4};
    }

    private double[] CaseHelper4(double D) {
        double A =Math.sqrt((4*D/Math.sqrt(3)));
        return new double[] {A, A*Math.sqrt(3.0)/6.0, A*Math.sqrt(3.0)/3.0, D};
    }

    private boolean Exp(double[] A, double[] B) {
        if (A.length != B.length)
            return false;
        for(int i = 0; i < A.length; i++) {
            A[i] = B[i];
        }

        return true;
    }

    public void CaseTask14(int n, double value) {
        if(n < 0 || n > 3)
            return;
        double[] arr = new double[4];

        switch (n){
            case 0: Exp(arr, CaseHelper1(value));
            case 1: Exp(arr, CaseHelper2(value));
            case 2: Exp(arr, CaseHelper3(value));
            case 3: Exp(arr, CaseHelper4(value));
            default: break;
        }

        System.out.println(arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3]);
    }

    /*Дано целое число N (> 0). Знайдіть квадрат цього числа,
     використовуючи для його вирахування наступну формулу:N2 = 1 + 3 + 5 + … + (2·N – 1).
     Після додавання до суми кожного вкладеного виводиться поточне значення
     суми (в результаті будуть виведені квадрати всіх цілих чисел від 1 до N).*/
    public long ForTask14(int N) {
        long Sum = 0L;
        for (int i = 1; i <= N; i++) {
            Sum += 2L *i - 1L;
            System.out.println("current sum = " + Sum);
        }
        System.out.println("RESULT Sum = " + Sum);

        return Sum;
    }

    /*Дана квадратна матриця A порядку M.
     Починаючи з елемента 1,1, вивести її елементами
     наступним чином (куточками): все . ;
     елементи першого стовпця; елементи останнього рядка,
     крім першого (вже виведеного) елемента; елементи
     другого стовпця, що залишилися; елементи, що залишилися
     передостаннього рядка і т. д.; останнім виводиться елемент A1,M.*/
    public void MatrixTask14(int[][] matrix) {
        
    }

}


