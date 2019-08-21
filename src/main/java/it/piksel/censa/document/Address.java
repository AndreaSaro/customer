package it.piksel.censa.document;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Address extends BaseDocument {

	@Id
	private String id;
	@NotNull
	private String alias;
	private String name;
	private String surname;
	private String email;
	private String address;
	private String state;
	private String country;
	private String city;
	private String zipCode;
	private String mobilePhone;
	private String phone;
	private String shippingNote;
	@NotNull
	private String customerId;

	public String getAddress() {
		return address;
	}

	public String getAlias() {
		return alias;
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

	public String getEmail() {
		return email;
	}

	public String getId() {
		return id;
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

	public void setAlias(String alias) {
		this.alias = alias;
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

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(String id) {
		this.id = id;
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
