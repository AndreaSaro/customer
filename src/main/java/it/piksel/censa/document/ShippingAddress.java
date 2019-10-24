package it.piksel.censa.document;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.springframework.data.mongodb.core.mapping.Document;

import it.piksel.censa.validation.OnController;
import lombok.Getter;
import lombok.Setter;

@Document
@Getter
@Setter
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

}
