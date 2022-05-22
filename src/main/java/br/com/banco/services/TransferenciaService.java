package br.com.banco.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.banco.DTOs.TransferenciaDTO;
import br.com.banco.entity.Transferencia;
import br.com.banco.repositories.TransferenciaRepository;
import br.com.banco.services.exceptions.DatabaseException;
import br.com.banco.services.exceptions.ResourceNotFoundException;

@Service
public class TransferenciaService {

	@Autowired
	private TransferenciaRepository repository;

	/*
	@Transactional(readOnly = true)
	public Page<TransferenciaDTO> findAllPaged(PageRequest pageRequest) {
		Page<Transferencia> list = repository.findAll(pageRequest);
		return list.map(x -> new TransferenciaDTO(x));

	}
	*/

	@Transactional(readOnly = true)
	public TransferenciaDTO findById(Long id) {
		Optional<Transferencia> obj = repository.findById(id);
		Transferencia entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found!"));
		return new TransferenciaDTO(entity);
	}

	@Transactional(readOnly = true)
	public TransferenciaDTO insert(TransferenciaDTO dto) {
		Transferencia entity = new Transferencia();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new TransferenciaDTO(entity);
	}

	@Transactional
	public TransferenciaDTO update(TransferenciaDTO dto, Long id) {
		try {
			Transferencia entity = repository.getById(dto.getId());
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new TransferenciaDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}

	private void copyDtoToEntity(TransferenciaDTO dto, Transferencia entity) {

		entity.setNome_operador_transacao(dto.getNome_operador_transacao());
		entity.setData_transferencia(dto.getData_transferencia());
		entity.setTipo(dto.getTipo());
		entity.setValor(dto.getValor());


		}
	
	public List<Transferencia> findAll() {
		return repository.findAll();
	}

	}
