//Contact Class

import java.util.regex.Pattern;

public class Contact {

	//declare class fields
	private String contactId;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;

	//phone number pattern
	private static final Pattern PHONE_PATTERN = Pattern.compile("\\d{10}");

	//constructor
	public Contact(String contactId, String firstName, String lastName, String phone, String address)
	{
		//validate all fields
		validateId(contactId);
		validateFirstName(firstName);
		validateLastName(lastName);
		validatePhone(phone);
		validateAddress(address);

		//assign validated fields
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}

	//validation helpers

	//validate id
	private void validateId(String contactId)
	{
		if(contactId == null || contactId.length() > 10)
		{
			throw new IllegalArgumentException("Invalid ID");
		}
	}

	//validate first name
	private void validateFirstName(String firstName)
	{
		if(firstName == null || firstName.length() > 10)
		{
			throw new IllegalArgumentException("Invalid First Name");
		}
	}

	//validate last name
	private void validateLastName(String lastName)
	{
		if(lastName == null || lastName.length() > 10)
		{
			throw new IllegalArgumentException("Invalid Last Name");
		}
	}

	//validate phone number
	private void validatePhone(String phone)
	{
		if(phone == null || !PHONE_PATTERN.matcher(phone).matches())
		{
			throw new IllegalArgumentException("Invalid Phone Number");
		}
	}

	//validate address
	private void validateAddress(String address)
	{
		if(address == null || address.length() > 30)
		{
			throw new IllegalArgumentException("Invalid Address");
		}
	}

	//getters

	//get contact ID
	public String getContactId()
	{
		return contactId;
	}

	//get first name
	public String getFirstName()
	{
		return firstName;
	}

	//get last name
	public String getLastName()
	{
		return lastName;
	}

	//get phone number
	public String getPhone()
	{
		return phone;
	}

	//get address
	public String getAddress()
	{
		return address;
	}

	//setters

	//set new firstName
	public void setFirstName(String newFirstName)
	{
		validateFirstName(newFirstName);
		firstName = newFirstName;
	}

	//set new last Name
	public void setLastName(String newLastName)
	{
		validateLastName(newLastName);
		lastName = newLastName;
	}

	//set new phone number
	public void setNumber(String newNumber)
	{
		validatePhone(newNumber);
		phone = newNumber;
	}

	//set new address
	public void setAddress(String newAddress)
	{
		validateAddress(newAddress);
		address = newAddress;
	}
}
