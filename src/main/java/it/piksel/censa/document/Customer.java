package it.piksel.censa.document;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Document
@Getter
@Setter
public class Customer extends BaseDocument {
	@Transient
	public static final String ROLE = "customer";
	@Indexed(unique = true)
	private String username;
	@NotBlank
	private String password;
	@NotBlank
	private String name;
	@NotBlank
	private String surname;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date birthDate;
	@NotBlank
	@Email
	private String email;

	public static String getRole() {
		return ROLE;
	}

}
