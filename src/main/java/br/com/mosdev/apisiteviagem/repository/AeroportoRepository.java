package br.com.mosdev.apisiteviagem.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mosdev.apisiteviagem.model.Aeroporto;

@Repository
public interface AeroportoRepository extends JpaRepository<Aeroporto, Long>{

	Optional<Aeroporto> findByNome(String nome);

}
