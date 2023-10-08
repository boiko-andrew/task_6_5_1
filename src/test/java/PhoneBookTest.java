import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.PhoneBook;

import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PhoneBookTest {
    PhoneBook phoneBook;

    @BeforeAll()
    public void beforeAll() {
        phoneBook = new PhoneBook();
    }

    @ParameterizedTest
    @MethodSource("parametrizedCheckAddMethodSource")
    public void parametrizedCheckAdd(String name, String number, int expectedQty) {
        //arrange
        int actualQty;

        //act
        actualQty = phoneBook.add(name, number);

        //assert
        Assertions.assertEquals(expectedQty, actualQty);
    }

    public static Stream<Arguments> parametrizedCheckAddMethodSource() {
        return Stream.of(
                Arguments.of("Thomas", "+7(926)322-15-62", 1),
                Arguments.of("William", "+7(936)283-82-82", 2),
                Arguments.of("Sophie", "+7(926)111-11-89", 3),
                Arguments.of("Thomas", "+7(936)283-82-82", 3),
                Arguments.of("William", "+7(926)111-11-89", 3)
        );
    }

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
                Arguments.of("+7(926)322-15-62", "Thomas"),
                Arguments.of("+7(936)283-82-82", "William"),
                Arguments.of("+7(926)111-11-89", "Sophie"),
                Arguments.of("+7(936)258-82-82", "Unknown number"),
                Arguments.of("+7(936)333-33-60", "Unknown number")
        );
    }
}