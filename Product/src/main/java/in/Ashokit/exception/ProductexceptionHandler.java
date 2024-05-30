package in.Ashokit.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductexceptionHandler {

	@ExceptionHandler(value=Exception.class)
	public ResponseEntity<Exinfo> handlepdnf(Exception e){
		
		Exinfo info=new Exinfo();
		info.setExCode("404");
		info.setExMsg(e.getMessage());
		info.setExDate(LocalDate.now());
		
		return new ResponseEntity<Exinfo>(info, HttpStatus.BAD_REQUEST);
	}
	
}