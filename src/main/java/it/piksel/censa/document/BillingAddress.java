package it.piksel.censa.document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class BillingAddress extends BaseDocument {

	@NotBlank
	private String name;
	@NotBlank
	private String surname;
	@NotBlank
	private String address;
	@NotBlank
	private String state;
	@NotBlank
	private String country;
	@NotBlank
	private String city;
	@NotBlank
	private String zipCode;
	private String mobilePhone;
	private String phone;
	@Pattern(regexp = "/^(?:[A-Z][AEIOU][AEIOUX]|[B-DF-HJ-NP-TV-Z]{2}[A-Z]){2}(?:[\\dLMNP-V]{2}(?:[A-EHLMPR-T](?:[04LQ][1-9MNP-V]|[15MR][\\dLMNP-V]|[26NS][0-8LMNP-U])|[DHPS][37PT][0L]|[ACELMRT][37PT][01LM]|[AC-EHLMPR-T][26NS][9V])|(?:[02468LNQSU][048LQU]|[13579MPRTV][26NS])B[26NS][9V])(?:[A-MZ][1-9MNP-V][\\dLMNP-V]{2}|[A-M][0L](?:[1-9MNP-V][\\dLMNP-V]|[0L][1-9MNP-V]))[A-Z]$/i")
	private String codiceFiscale;
	@Email
	private String email;
	@Email
	private String pec;

	@NotNull
	private String customerId;

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

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPec() {
		return pec;
	}

	public void setPec(String pec) {
		this.pec = pec;
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
