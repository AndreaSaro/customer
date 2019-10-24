package it.piksel.censa.document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
@Getter
@Setter
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

}
