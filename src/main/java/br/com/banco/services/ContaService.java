package br.com.banco.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.banco.DTOs.ContaDTO;
import br.com.banco.entity.Conta;
import br.com.banco.repositories.ContaRepository;
import br.com.banco.services.exceptions.DatabaseException;
import br.com.banco.services.exceptions.ResourceNotFoundException;

@Service
public class ContaService {

	@Autowired
	private ContaRepository repository;
	
/*
	@Transactional(readOnly = true)
	public Page<ContaDTO> findAllPaged(PageRequest pageRequest) {
		Page<Conta> list = repository.findAll(pageRequest);
		return list.map(x -> new ContaDTO(x));

	}
	
*/
	@Transactional(readOnly = true)
	public ContaDTO findById(Long id) {
		Optional<Conta> obj = repository.findById(id);
		Conta entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
		return new ContaDTO(entity);
	}

	@Transactional(readOnly = true)
	public ContaDTO insert(ContaDTO dto) {
		Conta entity = new Conta();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new ContaDTO(entity);
	}

	@Transactional
	public ContaDTO update(ContaDTO dto, Long id) {
		try {
			Conta entity = repository.getById(dto.getId());
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new ContaDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id não encontrado! " + id);
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id não encontrado! " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Violacao de integridade");
		}
	}

	private void copyDtoToEntity(ContaDTO dto, Conta entity) {

		entity.setId(dto.getId());
		entity.setNome_responsavel(dto.getNome_responsavel());

	}
	public List<Conta> findAll() {
		return repository.findAll();
	}
}
