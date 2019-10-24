package it.piksel.censa.document;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseDocument {
	@Id
	private String id;
	@CreatedDate
	private Date creationDate; // da non passare, viene calcolato automaticamente
	@LastModifiedDate
	private Date lastUpdateDate; // da non passare, viene calcolato automaticamente

}
