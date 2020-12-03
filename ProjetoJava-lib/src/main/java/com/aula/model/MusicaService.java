package com.aula.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicaService {

	@Autowired 
	  MusicaDAO mdao;
	  
	  public void insert(Musica musica) {
	    mdao.insert(musica);
	  }
	  
	  public Map<String, Object> getMusica(int id){
		  return mdao.getMusica(id);
	  }
	  
	  public List<Map<String, Object>> getMusicas(){
		  return mdao.getMusicas();
	  }
}
