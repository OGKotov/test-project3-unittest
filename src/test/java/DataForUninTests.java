import org.testng.annotations.DataProvider;

public class DataForUninTests {

    //Значения переменных экземеляра в классе Pen по умолчанию
    static final int TEST_INK_CONTAINER_VALUE_DEFAULT = 1000;
    static final double TEST_SIZE_LETTER_DEFAULT = 1.0;
    static final String TEST_COLOR_DEFAULT = "BLUE";

    //Индентефикаторы переменных экземпляра в классе Pen
    static final String TEST_INK_CONTAINER_VALUE_WRITE = "inkContainerValue";
    static final String TEST_SIZE_LETTER_WRITE = "sizeLetter";
    static final String TEST_COLOR_WRITE = "color";

    //Путь к временному файлу для тестирования вывода метода doSomethingElse() для вывода цвета ручки
    static final String TEMP_TXT_PATH="src/test/java/temp.txt";


    //Входные данные для конструктора класса Pen с одним параметром. Один параметр вводится, два остаются по умолчанию.
    @DataProvider(name = "testPenConstructorOneParametrData_EnterOneParameterTwoDefault")
    public static Object[][] testPenConstructorOneParametrData_EnterOneParameterTwoDefault() {
        return new Object[][]{
                {500, TEST_SIZE_LETTER_DEFAULT, TEST_COLOR_DEFAULT},
                {0, TEST_SIZE_LETTER_DEFAULT, TEST_COLOR_DEFAULT},
                {-500, TEST_SIZE_LETTER_DEFAULT, TEST_COLOR_DEFAULT}

        };
    }

    //Входные данные для конструктора класса Pen с двумя параметрами. Два параметра вводятся, один остается по умолчанию.
    @DataProvider(name = "testPenConstructorTwoParametrsData_EnterTwoParametersOneDefault")
    public static Object[][] testPenConstructorTwoParametrsData_EnterTwoParametersOneDefault() {
        return new Object[][]{
                {500, 0, TEST_COLOR_DEFAULT},
                {0, -10, TEST_COLOR_DEFAULT},
                {-500, 10, TEST_COLOR_DEFAULT}

        };
    }

    //Входные данные для конструктора класса Pen с тремя параметрами. Вводится три параметра.
    @DataProvider(name = "testPenConstructorThreeParametrsData_EnterThreeParametersZeroDefault")
    public static Object[][] testPenConstructorThreeParametrsData_EnterThreeParametersZeroDefault() {
        return new Object[][]{
                {500, 0, "RED"},
                {0, -10, "BLACK"},
                {-500, 10, "WHITE"}

        };
    }

    /*Входные данные для тестирования работы метода isWork() при переменной экзмемпляра inkContainerValue больше нуля. Одно значеие больше нуля
    для инициализации переменной inkContainerValue, второе для ожидаемого значения, которое должен возвращать метод isWork() при корректной работе
    */
    @DataProvider(name = "testPenIsWorkData_InkContainerValueMoreZero")
    public static Object[][] testPenIsWorkData_InkContainerValueMoreZero() {
        return new Object[][]{
                {500, true},
                {300000, true},
                {5000000, true}

        };
    }

    /*Входные данные для тестирования работы метода isWork() при переменной экзмемпляра inkContainerValue менше или равно нуля. Одно значеие
     меньше либо равно нуля для инициализации переменной inkContainerValue, второе для ожидаемого значения, которое должен возвращать метод
     isWork() при корректной работе
   */

    @DataProvider(name = "testPenIsWorkData_InkContainerValueLessOrEqualZero")
    public static Object[][] testPenIsWorkData_InkContainerValueLessOrEqualZero() {
        return new Object[][]{
                {0, false},
                {-300, false},
                {-5000000, false}

        };
    }

    /*Входнрые данные для тестирования метода write() при написании строки, на пробелы которой чернила тратиться не должны. Подбираем
    количество чернил(первый параметре) так, чтобы нам хватило написать всю строку(второй параметр), при размере букв по
    умолчанию(sizeLetter = 1.0) учитывая то, что на пробелы чечернила тратиться не должны
     */
    @DataProvider(name = "testPenWriteData_WrittenWordsWithoutInkSpaces")
    public static Object[][] testPenWriteData_WrittenWordsWithoutInkSpaces() {
        return new Object[][]{
                {4, "a b c d"},
                {28, "The program does not count spaces"},
                {11, " 11 little ink"}

        };
    }


    /*Входнрые данные для тестирования метода write() при написании строки, когда в ручке изначально нет чернил. Инициализируем количество чернил
     inkContainerValue нулем или отрицательным значением(первый параметр), вводим строку длня написание(второй параметр), и ожидаем пустую
      строку(третий параметр)
    */
    @DataProvider(name = "testPenWriteData_PenWithoutInk")
    public static Object[][] testPenWriteData_PenWithoutInk() {
        return new Object[][]{
                {0, "a b c d", ""},
                {-5, "The program does not count spaces", ""},
                {-100, " 11 little ink", ""}

        };
    }

    /*Входнрые данные для тестирования метода write() при написании строки, когда в ручке в процессе написания заканчиваются чернила.
    Инициализируем количество чернил inkContainerValue таким значением(первый параметр), чтобы чернил хватило для написания чести строки(второй
    параметр). Вводим ожидаемый результат работы метода (третий параметр), подсчитав сколько символов, включая пробелы, напишет ручка при
    размере букв по умолчанию(sizeLetter = 1.0)
   */
    @DataProvider(name = "testPenWriteData_EndInkWhileWriting")
    public static Object[][] testPenWriteData_EndInkWhileWriting() {
        return new Object[][]{
                {4, "a b c d", "a b "},
                {10, "The program does not count spaces", "The progra"},
                {11, " 11 little ink", " 11 little "}

        };
    }

    /*Входнрые данные для тестирования метода write() при написании строки, когда в ручке чернил столько же или больше для того, чтобы написать
    заданную строку при размере букв по умолчанию(sizeLetter = 1.0). Инициализируем количество чернил inkContainerValue(первый параметр)
    значением равным или большим sizeOfWord, вводим строку длня написание(второй параметр), которая должна быть и ожидаемым результатом.
   */
    @DataProvider(name = "testPenWriteData_InkMoreOrEqualSizeOfWord")
    public static Object[][] testPenWriteData_InkMoreOrEqualSizeOfWord() {
        return new Object[][]{
                {7, "a b c d"},
                {100, "The program does not count spaces"},
                {10000, " 11 little ink"}

        };
    }

    /*Входнрые данные для тестирования метода write() при написании строки, cостоящей из одной буквы размера от 1.1 и 1.9(9). Инициализируем
    количество чернил inkContainerValue еденицей(первый параметр), размер буквы sizeLetter(второй параметр), значением от 1.1 до 1.9(9), вводим
    строку, стояющую из оюной буквы, и ожидаемый результа написания ручккой этой строки.
   */
    @DataProvider(name = "testPenWriteData_SizeLetterMoreInkContainerValueOnTenths")
    public static Object[][] testPenWriteData_SizeLetterMoreInkContainerValueOnTenths() {
        return new Object[][]{
                {1, 1.2, "a", ""},
                {1, 1.7, "a", ""},
                {1, 1.99, "a", ""}
        };
    }

    /*Входнрые данные для тестирования метода write() при написании строки, чтобы с учетом размера букв, количество чернил, необходимых для
    написания этой строки sizeOfWord, было на десятые больше количества чернил в ручке inkContainerValue. Инициализируем
   количество чернил в ручке inkContainerValue(первый параметр), размер символа sizeLetter(второй параметр), вводим
   строку для написания, и ожидаемый результа написания ручккой этой строки.
  */
    @DataProvider(name = "testPenWriteData_sizeOfWordMoreInkContainerValueOnTenths")
    public static Object[][] testPenWriteData_sizeOfWordMoreInkContainerValueOnTenths() {
        return new Object[][]{
                {13, 1.05, "Pen test work", "Pen test wor"},
                {4, 1.2, "abcd", "abc"},
                {5, 1.3, "abcd", "abc"}
        };
    }


    //Входные данные для тестирования вывода метода doSomethingElse()
    @DataProvider(name = "testPenDoSomethingElseData_EnterColor")
    public static Object[][] testPenDoSomethingElseData_EnterColor() {
        return new Object[][]{
                {TEST_INK_CONTAINER_VALUE_DEFAULT, TEST_SIZE_LETTER_DEFAULT, "RED", "RED"},
                {TEST_INK_CONTAINER_VALUE_DEFAULT, TEST_SIZE_LETTER_DEFAULT, "BLACK", "BLACK"},
                {TEST_INK_CONTAINER_VALUE_DEFAULT, TEST_SIZE_LETTER_DEFAULT, "WHITE", "WHITE"}
        };


    }
}