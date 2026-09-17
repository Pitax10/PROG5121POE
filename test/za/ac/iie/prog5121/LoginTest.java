package za.ac.iie.prog5121;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

public class LoginTest {

    Login login = new Login();

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    // ===== AssertEquals Tests =====
    @Test
    public void testUsernameCorrectlyFormatted_assertEquals() {
        String result = login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertEquals("Welcome Kyle, Smith it is great to see you.", result);
    }

    @Test
    public void testUsernameIncorrectlyFormatted_assertEquals() {
        String result = login.registerUser("kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.", result);
    }

    @Test
    public void testUsernameNoUnderscoreAndTooLong_assertEquals() {
        String result = login.registerUser("kyle", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.", result);
    }

    @Test
    public void testPasswordMeetsComplexity_assertEquals() {
        boolean result = login.checkPassword("ch&&sec@ke99!");
        assertEquals(true, result);
    }

    @Test
    public void testPasswordDoesNotMeetComplexity_assertEquals() {
        String result = login.registerUser("kyl_1", "password", "+27838968976", "Kyle", "Smith");
        assertEquals("Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.", result);
    }

    @Test
    public void testCellCorrectlyFormatted_assertEquals() {
        boolean result = login.checkCellPhoneNumber("+27838968976");
        assertEquals(true, result);
    }

    @Test
    public void testCellIncorrectlyFormatted_assertEquals() {
        String result = login.registerUser("kyl_1", "Ch&&sec@ke99!", "08966553", "Kyle", "Smith");
        assertEquals("Cell number is incorrectly formatted or does not contain an international code, please correct the number and try again.", result);
    }

    // ===== AssertTrue/False Tests =====
    @Test
    public void testLoginSuccessful_True() {
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!", "kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginFailed_False() {
        assertFalse(login.loginUser("kyl_1", "wrongPassword", "kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testUsernameCorrectlyFormatted_True() {
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testUsernameIncorrectlyFormatted_False() {
        assertFalse(login.checkUserName("kyle!!!!!!!"));
    }

    @Test
    public void testPasswordMeetsComplexity_True() {
        assertTrue(login.checkPassword("ch&&sec@ke99!"));
    }

    @Test
    public void testPasswordDoesNotMeetComplexity_False() {
        assertFalse(login.checkPassword("password"));
    }

    @Test
    public void testCellCorrectlyFormatted_True() {
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testCellIncorrectlyFormatted_False() {
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }
    
}

