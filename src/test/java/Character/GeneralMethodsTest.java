package Character;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneralMethodsTest {

    GeneralMethods generalMethods = new GeneralMethods();

    @Test
    void isAttributeCheckSuccessfulTrue() {
        boolean result = generalMethods.isAttributeCheckSuccessful(9, 4, 6);
        assertTrue(result);
    }

    @Test
    void isAttributeCheckSuccessfulFalseLower() {
        boolean result = generalMethods.isAttributeCheckSuccessful(9, 4, 4);
        assertFalse(result);
    }

    @Test
    void isAttributeCheckSuccessfulFalseHigher() {
        boolean result = generalMethods.isAttributeCheckSuccessful(9, 4, 10);
        assertFalse(result);
    }
}