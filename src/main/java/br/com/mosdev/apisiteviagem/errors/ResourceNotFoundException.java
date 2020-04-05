package br.com.mosdev.apisiteviagem.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Aeroporto not found")
public class ResourceNotFoundException extends RuntimeException{

}
