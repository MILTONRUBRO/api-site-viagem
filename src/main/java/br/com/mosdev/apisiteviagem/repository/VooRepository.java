package br.com.mosdev.apisiteviagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mosdev.apisiteviagem.model.Voo;

@Repository
public interface VooRepository extends JpaRepository<Voo, Long>{

}
