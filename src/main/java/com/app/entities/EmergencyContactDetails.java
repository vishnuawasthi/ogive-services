package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EMERG_CTC_DTLS")
@SequenceGenerator(sequenceName = "SEQ_EMERG_CTC_DTLS", initialValue = 1, allocationSize = 1, name = "SEQ_EMERG_CTC_DTLS")
public class EmergencyContactDetails {

	@Id
	@GeneratedValue(generator = "SEQ_EMERG_CTC_DTLS", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	

}
