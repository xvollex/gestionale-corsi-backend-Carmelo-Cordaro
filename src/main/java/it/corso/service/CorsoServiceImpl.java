package it.corso.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.CorsoDao;
import it.corso.dto.AddCourdeDTO;
import it.corso.dto.CorsoDTO;
import it.corso.model.Corso;
import it.corso.model.Utente;

@Service
public class CorsoServiceImpl implements CorsoService {
	@Autowired
	private CorsoDao corsoDao;
	
	private ModelMapper mapper = new ModelMapper();
	
	@Override
	public List<CorsoDTO> getCourses() {
		List<Corso> corso = (List<Corso>) corsoDao.findAll();
		List<CorsoDTO> corsoDto = new ArrayList<>();
		
		corso.forEach(c -> corsoDto.add(mapper.map(c, CorsoDTO.class)));
		
		return corsoDto;
	}

	@Override
	public void addCourse(AddCourdeDTO course) 
	{
		Corso corso = new Corso();
		corso.setNomeCorso(course.getNomeCorso());
		corso.setDescrizioneBreve(course.getDescrizioneBreve());
		corso.setDescrizioneCompleta(course.getDescrizioneCompleta());
		corso.setDurata(course.getDurata());
		
		corsoDao.save(corso);
		
	}

	@Override
	public void deleteCourseById(int id) 
	{
		Optional<Corso> utenteOption = corsoDao.findById(id);
		
		if (utenteOption.isPresent()) 
		{
			corsoDao.delete(utenteOption.get());
		}
	}
}
