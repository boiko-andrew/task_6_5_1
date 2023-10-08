import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.PhoneBook;

import java.util.stream.Stream;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PhoneBookTest {
    private static PhoneBook phoneBook;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Testing started.\n");
        phoneBook = new PhoneBook();
        phoneBook.add("James", "+7(926)311-11-14");
        phoneBook.add("David", "+7(999)555-55-46");
        phoneBook.add("Danny", "+7(999)555-55-47");
    }

    @Order(1)
    @ParameterizedTest
    @MethodSource("parametrizedCheckAddMethodSource")
    public void parametrizedCheckAdd(String name, String number, int expectedQtyIncrement) {
        //arrange
        int actualQtyIncrement;
        int qtyBefore;
        int qtyAfter;

        //act
        qtyBefore = phoneBook.getContactsQty();
        qtyAfter = phoneBook.add(name, number);
        actualQtyIncrement = qtyAfter - qtyBefore;

        //assert
        Assertions.assertEquals(expectedQtyIncrement, actualQtyIncrement);
    }

    public static Stream<Arguments> parametrizedCheckAddMethodSource() {
        return Stream.of(
                Arguments.of("Thomas", "+7(926)322-15-62", 1),
                Arguments.of("William", "+7(936)283-82-82", 1),
                Arguments.of("Sophie", "+7(926)111-11-89", 1),
                Arguments.of("Thomas", "+7(936)283-82-82", 0),
                Arguments.of("William", "+7(926)111-11-89", 0)
        );
    }

    @Order(2)
    @ParameterizedTest
    @MethodSource("parametrizedCheckFindByNumberMethodSource")
    public void parametrizedCheckFindByNumber(String number, String expectedName) {
        //arrange
        String actualName;

        //act
        actualName = phoneBook.findByNumber(number);

        //assert
        Assertions.assertEquals(expectedName, actualName);
    }

    public static Stream<Arguments> parametrizedCheckFindByNumberMethodSource() {
        return Stream.of(
                Arguments.of("+7(926)311-11-14", "James"),
                Arguments.of("+7(999)555-55-46", "David"),
                Arguments.of("+7(999)555-55-47", "Danny"),
                Arguments.of("+7(936)258-82-82", "Unknown number"),
                Arguments.of("+7(936)333-33-60", "Unknown number")
        );
    }

    @Order(3)
    @ParameterizedTest
    @MethodSource("parametrizedCheckFindByNameMethodSource")
    public void parametrizedCheckFindByName(String name, String expectedNumber) {
        //arrange
        String actualNumber;

        //act
        actualNumber = phoneBook.findByName(name);

        //assert
        Assertions.assertEquals(expectedNumber, actualNumber);
    }

    public static Stream<Arguments> parametrizedCheckFindByNameMethodSource() {
        return Stream.of(
                Arguments.of("James", "+7(926)311-11-14"),
                Arguments.of("David", "+7(999)555-55-46"),
                Arguments.of("Danny", "+7(999)555-55-47"),
                Arguments.of("Paul", "Unknown name"),
                Arguments.of("Mark", "Unknown name")
        );
    }

    @Order(4)
    @Test
    public void checkPrintAllNames() {
        //arrange
        String actualOutput;
        String expectedOutput = "[Danny, David, James, Sophie, Thomas, William]";

        //act
        actualOutput = phoneBook.printAllNames();
        System.out.println(actualOutput);

        //assert
        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @AfterAll
    public static void afterAll() {
        phoneBook = null;
        System.out.println("Testing finished.");
    }
}