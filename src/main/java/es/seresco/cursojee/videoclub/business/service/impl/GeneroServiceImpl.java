package es.seresco.cursojee.videoclub.business.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.seresco.cursojee.videoclub.business.repository.GeneroRepository;
import es.seresco.cursojee.videoclub.business.service.GeneroService;
import es.seresco.cursojee.videoclub.exception.MyBusinessException;
import es.seresco.cursojee.videoclub.mapper.GeneroMapper;
import es.seresco.cursojee.videoclub.view.dto.genero.GeneroDTO;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Service(GeneroService.BEAN_NAME)
@Transactional(rollbackFor = MyBusinessException.class)
@Setter
@NoArgsConstructor
@Slf4j
public class GeneroServiceImpl implements GeneroService
{
	@Resource
	private GeneroRepository generoRepository;

	@Resource
	private GeneroMapper generoMapper;


	@Transactional(readOnly = true)
	@Override
	public List<GeneroDTO> findAll()
	{
		log.debug("findAllGeneros");
		return generoMapper.fromGeneros(generoRepository.findAll());
	}

}
