package it.piksel.censa.customer;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import it.piksel.censa.address.Address;

@Document(collection = "customer")
public class Customer {

	@Id
	private String id;
	@NotNull
	private String name;
	@NotNull
	private String surname;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date birthDate;
	@NotNull
	private String email;
	@NotNull
	@Indexed(unique=true)
	private String login;
	@NotNull
	private String password;
	
	private List<Address> addresses;
	private Consensus consensus;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Consensus getConsensus() {
		return consensus;
	}

	public void setConsensus(Consensus consensus) {
		this.consensus = consensus;
	}

}