package lab0;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Test14 {
    /* Дано масив A розміру  N . Вивести спочатку
    його елементи з парними номерами, а потім потім 151; елементи
    з непарними номерами (також у порядку зростання
    номерів):
    A 2,  A 4, A 6, …,  A 1, A 3,A 5,… .*/
    @Test(dataProvider = "arrayProvider")
    public void arrayTest(int[] array, int[][] value) {
        assertEquals(new lab0.Variant14().arrayTask14(array), value);
    }

    @DataProvider
    public Object[][] arrayProvider() {
        return new Object[][] { {  new int[] { 10, 2, 3 }, new int[][]{{10, 2, 3}, {3, 10},{2}}},
                { new int[] { 4, 3, 5, 4, 9, 2 }, new int[][]{{ 4, 3, 5, 4, 9, 2 },{4,5,9},{2, 3, 4}}}};
    }

    /* Дано три цілих числа: A, B, C.
        Перевірити істинність висловлювання:
        «Рівно одне з чисел A, B, C позитивне»*/

    @DataProvider(name = "BooleanTask14DataProvider")
    public Object[][] booleanTask14DataProvider() {
        return new Object[][] {
                {1, -2, -3, true},
                {-1, 2, -3, true},
                {-1, -2, 3, true},
                {1, 2, 3, false},
                {-1, -2, -3, false},
                {1, 2, -3, false},
                {1, -2, 3, false},
                {-1, 2, 3, false}
        };
    }

    @Test(dataProvider = "booleanTask14DataProvider")
    public void testBooleanTask14(int A, int B, int C, boolean expected) {
        Variant14 variant = new Variant14();
        boolean result = variant.booleanTask14(A, B, C);
        Assert.assertEquals(result, expected);
    }

    /*Елементи рівностороннього трикутника пронумеровані
         в такий спосіб: 1 — сторона a, 2 — радіус R1
         вписаного кола (R1 = a ·(3)1/2/6), 3 — радіус R2
         описаного кола (R2 = 2·R 1),
         4 — площа S = a2·(3)1/2/4. Даний номер одного
         з цих елементів і його значення.
         Вивести значення решти елементів даного
        трикутника (в тому ж порядку).*/

    @DataProvider(name = "CaseTask14DataProvider")
    public Object[][] caseTask14DataProvider() {
        return new Object[][]{
                {1, 6.0, new double[]{6.0, 6.0*Math.sqrt(3.0)/6.0, 6.0*Math.sqrt(3.0)/3.0,36.0*Math.sqrt(3.0)/4.0}},
                {2, 2.0, new double[]{2.0/Math.sqrt(3.0)*6.0, 2.0, 24.0/Math.sqrt(3.0) ,12.0*Math.sqrt(3.0)}},
                {3, 3.0, new double[]{9.0/Math.sqrt(3.0), 1.5, 3.0, 3.0 * 9.0*Math.sqrt(3.0)/4.0}}
        };
    }

    @Test(dataProvider = "caseTask14DataProvider")
    public void testCaseTask14(int n, double value, double[] expected) {
        Variant14 variant = new Variant14();
        double[] result = variant.caseTask14(n, value);
        Assert.assertEquals(result, expected, 1e-8);
    }

    /*Дано целое число N (> 0). Знайдіть квадрат цього числа,
    //використовуючи для його вирахування наступну формулу:N2 = 1 + 3 + 5 + … + (2·N – 1).
    //Після додавання до суми кожного вкладеного виводиться поточне значення
    //суми.*/

    @DataProvider(name = "ForTask14DataProvider")
    public Object[][] forTask14DataProvider() {
        return new Object[][]{
                {1, 1L},
                {2, 4L},
                {3, 9L},
                {4, 16L},
                {100, 10000L}
        };
    }

    @Test(dataProvider = "forTask14DataProvider")
    public void testForTask14(int N, long expected) {
        Variant14 variant = new Variant14();
        long result = variant.forTask14(N);
        Assert.assertEquals(result, expected);
    }
    /*Дана квадратна матриця A порядку M.
    //     Починаючи з елемента 1,1, вивести її елементами
    //     наступним чином (куточками): все . ;
    //     елементи першого стовпця; елементи останнього рядка,
    //     крім першого (вже виведеного) елемента; елементи
    //     другого стовпця, що залишилися; елементи, що залишилися
    //     передостаннього рядка і т. д.; останнім виводиться елемент A1,M.*/
    @DataProvider(name = "MatrixTask14DataProvider")
    public Object[][] matrixTask14DataProvider() {
        return new Object[][]{
                {
                        new int[][]{
                                {1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9}
                        },
                        new int[][]{
                                {1, 4, 7},
                                {8, 9},
                                {2, 5},
                                {6},
                                {3}
                        },
                },
                {
                        new int[][]{
                                {1, 2},
                                {3, 4}
                        },
                        new int[][]{
                                {1, 3},
                                {4},
                                {2}
                        },
                }
        };
    }

    @Test(dataProvider = "matrixTask14DataProvider")
    public void testMatrixTask14(int[][] matrix, int[][] expectedOutput) {
        Variant14 variant = new Variant14();

        int[][] Output = variant.matrixTask14(matrix);
        Assert.assertEquals(Output.length, expectedOutput.length, "Різна кількість рядків у вихідних масивах.");

        for (int i = 0; i < Output.length; i++) {
            Assert.assertEquals(Output[i].length, expectedOutput[i].length, "Різна кількість елементів у рядку " + i);
            Assert.assertEquals(Output[i], expectedOutput[i], "Невідповідність у рядку " + i);
        }
    }
    /*Дано три числа. Вивести
    спочатку найменше, а потім
    найбільше з даних чисел.*/
    @DataProvider(name = "IfTask14DataProvider")
    public Object[][] ifTask14DataProvider() {
        return new Object[][]{
                {1, 2, 3, new int[]{1, 3}},
                {3, 2, 1, new int[]{1, 3}},
                {2, 3, 1, new int[]{1, 3}},
                {1, 1, 1, new int[]{1, 1}},
        };
    }

    @Test(dataProvider = "ifTask14DataProvider")
    public void testIfTask14(int A, int B, int C, int[] expected) {
        Variant14 variant = new Variant14();
        int[] result = variant.ifTask14(A, B, C);
        assertEquals(result, expected);
    }
    /*Дано число A (> 1). Вивести найбільше з цілих чиселK, для
    яких сума 1 + 1/2 + … + 1/K буде менше A, і саму цю суму.*/
    @DataProvider(name = "WhileTask14DataProvider")
    public Object[][] whileTask14DataProvider() {
        return new Object[][]{
                {2.0, new double[]{4, 1.83333333}},
                {2.5, new double[]{7, 2.44999999}},
                {3.0, new double[]{11, 2.9289682}},
        };
    }

    @Test(dataProvider = "whileTask14DataProvider")
    public void testWhileTask14(double A, double[] expected) {
        Variant14 variant = new Variant14();
        double[] result = variant.whileTask14(A);
        assertEquals(result[0], expected[0], "Неправильне значення K");
        assertEquals(result[1], expected[1], 0.000001, "Неправильне значення суми");
    }
    /*Дано тризначне число. В ньому закреслили першу справа
        цифру і приписали її зліва. Вивести отримане число.*/
    @DataProvider(name = "IntegerTask14DataProvider")
    public Object[][] integerTask14DataProvider() {
        return new Object[][]{
                {123, 312},
                {456, 645},
                {789, 978},
                {230, 23},
                {905, 590}
        };
    }

    @Test(dataProvider = "integerTask14DataProvider")
    public void testIntegerTask14(int input, int expected) {
        Variant14 variant = new Variant14();
        int result = variant.integerTask14(input);
        assertEquals(result, expected, "Неправильний результат для числа " + input);
    }
}