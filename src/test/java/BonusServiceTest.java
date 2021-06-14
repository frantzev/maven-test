import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BonusServiceTest {

    @Test
    void shouldCalculateRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1_000_000_60;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForNoRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1000_000_000;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void calculateWhenNotRegisteredAndBonusUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000_60;
        boolean registered = false;
        long expected = 10;
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }


}