
//ContactServiceClass
import java.util.Map;
import java.util.HashMap;

public class ContactService {

	//initiate contact map
	private Map<String, Contact> contacts;

	//constructor
	public ContactService()
	{
		contacts = new HashMap<>();
	}

	//methods

	//get contact by contactId
	public Contact getContactById(String contactId)
	{
		if(!contacts.containsKey(contactId))
		{
			throw new IllegalArgumentException("This Contact does not exist");
		}

		return contacts.get(contactId);
	}

	//add contact
	public void addContact(String contactId, String firstName, String lastName, String phone, String address)
	{

		//validate unique ID
		if(contacts.containsKey(contactId))
		{
			throw new IllegalArgumentException("This ID is already taken");
		}

		//if valid make new contact object
		Contact newContact = new Contact(contactId, firstName, lastName, phone, address);

		//add contact to contact map
		contacts.put(contactId, newContact);
	}

	//delete contact
	public void deleteContact(String contactId)
	{
		//find contact to delete
		if(!contacts.containsKey(contactId))
		{
			throw new IllegalArgumentException("This Contact does not exist");
		}

		//if found then remove
		contacts.remove(contactId);
	}

	//update contact fields

	//update firstName
	public void updateFirstName(String contactId, String firstName)
	{
		//find contact
		Contact updatedContact = getContactById(contactId);

		//update first name
		updatedContact.setFirstName(firstName);
	}

	//update lastName
	public void updateLastName(String contactId, String lastName)
	{
		//find contact
		Contact updatedContact = getContactById(contactId);

		//update last name
		updatedContact.setLastName(lastName);
	}

	//update phone
	public void updatePhone(String contactId, String phone)
	{
		//find contact
		Contact updatedContact = getContactById(contactId);

		//update phone
		updatedContact.setNumber(phone);
	}

	//update address
	public void updateAddress(String contactId, String address)
	{
		//find contact
		Contact updatedContact = getContactById(contactId);

		//update address
		updatedContact.setAddress(address);
	}
}
