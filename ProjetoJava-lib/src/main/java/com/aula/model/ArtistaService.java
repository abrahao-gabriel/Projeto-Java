package com.aula.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistaService {

	@Autowired 
	  ArtistaDAO adao;
	  
	  public void insertA(Artista artista) {
	    adao.insertA(artista);
	  }
	  
	  public Map<String, Object> getArtista(int id){
		  return adao.getArtista(id);
	  }
	  
	  public List<Map<String, Object>> getArtistas(){
		  return adao.getArtistas();
	  }
	  
	  public void deleteArtista(int id) {
		  adao.deleteArtista(id);
	  }
	  
	  public void updateArtista(int id, Artista artista) {
		  adao.updateArtista(id, artista);
	  }
}
