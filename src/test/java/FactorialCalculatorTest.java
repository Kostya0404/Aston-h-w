import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorialCalculatorTest {

    @Test
    void testFactorialOfZero() {
        assertEquals(1, FactorialCalculator.factorial(0), "Факториал 0 должен быть равен 1");
    }

    @Test
    void testFactorialOfOne() {
        assertEquals(1, FactorialCalculator.factorial(1), "Факториал 1 должен быть равен 1");
    }

    @Test
    void testFactorialOfPositiveNumber() {
        assertEquals(2, FactorialCalculator.factorial(2), "Факториал 2 должен быть равен 2");
        assertEquals(6, FactorialCalculator.factorial(3), "Факториал 3 должен быть равен 6");
        assertEquals(24, FactorialCalculator.factorial(4), "Факториал 4 должен быть равен 24");
        assertEquals(120, FactorialCalculator.factorial(5), "Факториал 5 должен быть равен 120");
    }

    @Test
    void testFactorialOfNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculator.factorial(-1);
        });
        assertEquals("Для отрицательных чисел нельзя вычислить факториал", exception.getMessage());
    }
}