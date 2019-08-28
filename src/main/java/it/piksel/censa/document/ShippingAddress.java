package it.piksel.censa.document;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.springframework.data.mongodb.core.mapping.Document;

import it.piksel.censa.validation.OnController;

@Document
public class ShippingAddress extends BaseDocument {

	@Null(groups = OnController.class)
	@NotNull
	private String customerId;
	@NotBlank(groups = OnController.class)
	@NotBlank
	private String name;
	@NotBlank(groups = OnController.class)
	@NotBlank
	private String surname;
	@NotBlank(groups = OnController.class)
	@NotBlank
	private String address;
	@NotBlank(groups = OnController.class)
	@NotBlank
	private String state;
	@NotBlank(groups = OnController.class)
	@NotBlank
	private String country;
	@NotBlank(groups = OnController.class)
	@NotBlank
	private String city;
	@NotBlank(groups = OnController.class)
	@NotBlank
	@Digits(integer = 6, fraction = 0, groups = OnController.class)
	@Digits(integer = 6, fraction = 0)
	private String zipCode;
	private String mobilePhone;
	private String phone;
	private String shippingNote;

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getCustomerId() {
		return customerId;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getShippingNote() {
		return shippingNote;
	}

	public String getState() {
		return state;
	}

	public String getSurname() {
		return surname;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setShippingNote(String shippingNote) {
		this.shippingNote = shippingNote;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
