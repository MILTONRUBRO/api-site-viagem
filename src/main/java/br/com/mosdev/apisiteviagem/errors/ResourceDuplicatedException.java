package br.com.mosdev.apisiteviagem.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "A rota de origem e destino informada já existe ou é a mesma")
public class ResourceDuplicatedException  extends RuntimeException{

}
