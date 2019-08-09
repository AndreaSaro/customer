package it.piksel.censa.document;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Consensus {

	private boolean consenso1;
	private boolean consenso2;
	private boolean consenso3;

	public boolean isConsenso1() {
		return consenso1;
	}

	public void setConsenso1(boolean consenso1) {
		this.consenso1 = consenso1;
	}

	public boolean isConsenso2() {
		return consenso2;
	}

	public void setConsenso2(boolean consenso2) {
		this.consenso2 = consenso2;
	}

	public boolean isConsenso3() {
		return consenso3;
	}

	public void setConsenso3(boolean consenso3) {
		this.consenso3 = consenso3;
	}
}