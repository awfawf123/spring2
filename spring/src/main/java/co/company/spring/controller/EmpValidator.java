package co.company.spring.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import co.company.spring.dao.Emp;

public class EmpValidator implements Validator {
	
	String emailRegexp = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i\r\n" + 
			"\r\n";
	private Pattern pattern;

	@Override
	public boolean supports(Class<?> clazz) {
		return Emp.class.isAssignableFrom(clazz);
	}
	
	public EmpValidator() {
		pattern = Pattern.compile(emailRegexp);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Emp emp =(Emp)target;
		if(emp.getLastName() == null ||
				emp.getLastName().trim().isEmpty()) {
			errors.rejectValue("lastName","required",new Object[] {"lastName"},"");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobId", "required",new Object[] {"jobId"},"");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "required");
		
		if(emp.getEmail() == null ||
				emp.getEmail().trim().isEmpty()) {
			errors.rejectValue("email","required", new Object[] {"email"},"");
		}else {
			Matcher matcher = pattern.matcher(emp.getEmail());
			if (!matcher.matches()) {
				errors.rejectValue("email", "bad");
			}
		}
	}

}
