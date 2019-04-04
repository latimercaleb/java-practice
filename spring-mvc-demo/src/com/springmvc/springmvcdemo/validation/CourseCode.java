package com.springmvc.springmvcdemo.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
public @interface CourseCode {
	
	// Need to add 2 attributes for code and error message
	public String value() default "LUV";
	public String message() default "LUV prefix required";
	
	// Groups are for grouping messages together
	public Class<?> [] groups() default {};
	
	// Payload is for additional data around error
	public Class<? extends Payload>[] payload() default {};
}
