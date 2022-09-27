package com.brown.sms.SMS;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.RunWith;

import jpa.entitymodels.Student;
import jpa.service.StudentService;

/**
 * Unit tests for StudentService
 */
//@ExtendWith(JUnitPlatform.class)
public class AppTest {
	private static StudentService ss;
	
	@BeforeAll
	public static void setUp () {
		ss = new StudentService();
	}
    /**
     * Tests StudentService.getStudentByEmail(String email)
     * method should return a Student object
     */
    @Test
    public void testGetStudentByEmail () {
        Student actual = ss.getStudentByEmail("tattwool4@biglobe.ne.jp");
        String expectedEmail = "tattwool4@biglobe.ne.jp";
        String expectedName = "Thornie Attwool";
        String expectedPass = "Hjt0SoVmuBz";
        assertEquals(actual.getEmail(), expectedEmail);
        assertEquals(actual.getName(), expectedName);
        assertEquals(actual.getPassword(), expectedPass);
    }

    /**
     * Tests StudentService.validateStudent(String email, String password)
     * method should return a boolean
     * true if valid student login credentials, false if not
     */
    @Test
    public void testValidateStudent () {
        boolean actual = ss.validateStudent("tattwool4@biglobe.ne.jp", "Hjt0SoVmuBz");
        assertTrue(actual);
        actual = ss.validateStudent("tattwool4@biglobe.ne.jp", "password");
        assertFalse(actual);
    }
}
