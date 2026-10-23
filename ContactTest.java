//Contact Test

//import
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.NullSource;

public class ContactTest
{
	//Contact object for tests
	Contact newContact;

	//test for initiating a successful class object
	@Test
	void testContactClass()
	{
		//instantiate Contact Object
		Contact newContact = new Contact(
				"1021532",
				"Dylon",
				"Ayers",
				"0123456789",
				"123 adelaide dr");

		//assertions
		assertTrue(newContact.getContactId().equals("1021532"));
		assertTrue(newContact.getFirstName().equals("Dylon"));
		assertTrue(newContact.getLastName().equals("Ayers"));
		assertTrue(newContact.getPhone().equals("0123456789"));
		assertTrue(newContact.getAddress().equals("123 adelaide dr"));
	}

	//test for invalid id inputs
	@ParameterizedTest
	@ValueSource(strings = {"10215321021532"})
	@NullSource
	void testInvalidId(String testValue)
	{
		assertThrows(IllegalArgumentException.class, ()->
		{
			new Contact(testValue, "Dylon", "Ayers", "0123456789", "123 adelaide dr");
		});
	}

	//test for invalid first name inputs
	@ParameterizedTest
	@ValueSource(strings = {"Dylontheprogrammer"})
	@NullSource
	void testInvalidFirstName(String testValue)
	{
		assertThrows(IllegalArgumentException.class, ()->
		{
			new Contact("1021532", testValue, "Ayers", "0123456789", "123 adelaide dr");
		});
	}

	//test for invalid last name inputs
	@ParameterizedTest
	@ValueSource(strings = {"Ayersthelast"})
	@NullSource
	void testInvalidLastName(String testValue)
	{
		assertThrows(IllegalArgumentException.class, ()->
		{
			new Contact("1021532", "Dylon", testValue, "0123456789", "123 adelaide dr");
		});
	}

	//test for invalid phone number inputs
	@ParameterizedTest
	@ValueSource(strings = {"012345678910", "012345678A", "012345678"})
	@NullSource
	void testInvalidPhoneNumber(String testValue)
	{
		assertThrows(IllegalArgumentException.class, ()->
		{
			new Contact("1021532", "Dylon", "Ayers", testValue, "123 adelaide dr");
		});
	}

	//test for invalid address inputs
	@ParameterizedTest
	@ValueSource(strings = {"123 adelaide dr, Jacksonville, Florida, 32257"})
	@NullSource
	void testInvalidAddress(String testValue)
	{
		assertThrows(IllegalArgumentException.class, ()->
		{
			new Contact("1021532", "Dylon", "Ayers", "0123456789", testValue);
		});
	}

	//setup contact for setter tests
	@BeforeEach
	void setUp()
	{
		newContact = new Contact(
				"1021532",
				"Dylon",
				"Ayers",
				"0123456789",
				"123 adelaide dr");
	}

	//first name setter tests

	//test first name setter
	@Test
	void testSetFirstName()
	{
		newContact.setFirstName("John");
		assertTrue(newContact.getFirstName().equals("John"));
	}

	//test invalid first name setter
	@ParameterizedTest
	@ValueSource(strings = {"Johntheprogrammer"})
	@NullSource
	void testInvalidFirstNameSetter(String testValue)
	{
		assertThrows(IllegalArgumentException.class, ()->
		{
			newContact.setFirstName(testValue);
		});
	}

	//last name setter tests

	//test last name setter
	@Test
	void testSetLastName()
	{
		newContact.setLastName("Smith");
		assertTrue(newContact.getLastName().equals("Smith"));
	}

	//test invalid last name setter
	@ParameterizedTest
	@ValueSource(strings = {"Smiththelast"})
	@NullSource
	void testInvalidLastNameSetter(String testValue)
	{
		assertThrows(IllegalArgumentException.class, ()->
		{
			newContact.setLastName(testValue);
		});
	}

	//phone number setter tests

	//test phone number setter
	@Test
	void testSetPhoneNumber()
	{
		newContact.setNumber("9041234567");
		assertTrue(newContact.getPhone().equals("9041234567"));
	}

	//test invalid phone number setter
	@ParameterizedTest
	@ValueSource(strings = {"012345678910", "012345678A", "012345678"})
	@NullSource
	void testInvalidPhoneNumberSetter(String testValue)
	{
		assertThrows(IllegalArgumentException.class, ()->
		{
			newContact.setNumber(testValue);
		});
	}

	//address setter tests

	//test address setter
	@Test
	void testSetAddress()
	{
		newContact.setAddress("456 Main St");
		assertTrue(newContact.getAddress().equals("456 Main St"));
	}

	//test invalid address setter
	@ParameterizedTest
	@ValueSource(strings = {"123 adelaide dr, Jacksonville, Florida, 32257"})
	@NullSource
	void testInvalidAddressSetter(String testValue)
	{
		assertThrows(IllegalArgumentException.class, ()->
		{
			newContact.setAddress(testValue);
		});
	}
}
