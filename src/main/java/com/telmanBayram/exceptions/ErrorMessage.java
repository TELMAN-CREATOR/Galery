package com.telmanBayram.exceptions;





import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {

	private String ofstatic;
	
	private MesagesType mesagesType;
	
	public String prepareErrorMessage() {
		StringBuilder builder=new StringBuilder();
		builder.append(mesagesType.getMessage());
		
		if (ofstatic!=null) {
			builder.append(": "+ofstatic);
		}
		return builder.toString();
	
	}
}
