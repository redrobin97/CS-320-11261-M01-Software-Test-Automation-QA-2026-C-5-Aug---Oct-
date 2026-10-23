//ContactServiceTest Class

//import
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest
{
	//initiate contact service globally for testing
	private ContactService contactService;

	//initiate test contact
	private Contact testContact;

	//set up valid data for tests dependent on contactService
	@BeforeEach
	void setUp()
	{
		//instantiate contact service
		contactService = new ContactService();

		//add contacts
		contactService.addContact("1001", "John", "Smith", "9045551234", "456 Main St");
		contactService.addContact("1002", "Sarah", "Jones", "9045555678", "72 Oak Lane");
		contactService.addContact("1003", "Michael", "Brown", "3525559876", "810 Pine Rd");
		contactService.addContact("1004", "Emily", "Davis", "4075554321", "25 River Dr");
		contactService.addContact("1005", "Robert", "Wilson", "3865552468", "901 Lake Ave");
	}

	//getContactById contact not found exception
	@Test
	void testContactNotFound()
	{
		assertThrows(IllegalArgumentException.class, ()->
		{
			contactService.getContactById("00000");
		});
	}

	//test contact found with ID
	@Test
	void testContactFoundById()
	{
		testContact = contactService.getContactById("1001");
		assertEquals("John", testContact.getFirstName());
	}

	//add new contact with duplicate ID
	@Test
	void testAddDuplicateId()
	{
		assertThrows(IllegalArgumentException.class, ()->
		{
			contactService.addContact("1005", "Robbby", "Willis", "0123456789", "901 adleaid Ave");
		});
	}

	//add new contact successfully
	@Test
	void testAddNewContactSuccess()
	{
		contactService.addContact("1006", "James", "Powers", "0123456789", "123 presidential ln");
		testContact = contactService.getContactById("1006");
		assertEquals("James", testContact.getFirstName());
	}

	//contact to be deleted not found
	@Test
	void noContactToDelete()
	{
		assertThrows(IllegalArgumentException.class, ()->
		{
			contactService.deleteContact("00000");
		});
	}

	//contact deleted successfully
	@Test
	void deleteContactSuccessfully()
	{
		contactService.deleteContact("1001");
		assertThrows(IllegalArgumentException.class, ()->
		{
			contactService.getContactById("1001");
		});
	}

	//update tests

	//update first name
	@Test
	void updateFirstNameTest()
	{
		contactService.updateFirstName("1002", "Waldo");
		assertEquals("Waldo", contactService.getContactById("1002").getFirstName());
	}

	//update last name
	@Test
	void updateLastNameTest()
	{
		contactService.updateLastName("1002", "Jenkins");
		assertEquals("Jenkins", contactService.getContactById("1002").getLastName());
	}

	//update phone number
	@Test
	void updatePhoneTest()
	{
		contactService.updatePhone("1002", "3520103456");
		assertEquals("3520103456", contactService.getContactById("1002").getPhone());
	}

	//update address
	@Test
	void updateAddressTest()
	{
		contactService.updateAddress("1002", "123 ozzy ln");
		assertEquals("123 ozzy ln", contactService.getContactById("1002").getAddress());
	}
}
