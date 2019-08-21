package it.piksel.censa.document;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

public abstract class BaseDocument {

	@CreatedDate
	private Date creationDate; // da non passare, viene calcolato automaticamente
	@LastModifiedDate
	private Date lastUpdateDate; // da non passare, viene calcolato automaticamente

	public Date getCreationDate() {
		return creationDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

}
