package com.aula.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GravadoraService {

	@Autowired 
	  GravadoraDAO gdao;
	  
	  public void insertG(Gravadora gravadora) {
	    gdao.insertG(gravadora);
	  }
	  
	  public Map<String, Object> getGravadora(int id){
		  return gdao.getGravadora(id);
	  }
	  
	  public List<Map<String, Object>> getGravadoras(){
		  return gdao.getGravadoras();
	  }
	  
	  public void deleteGravadora(int id) {
		  gdao.deleteGravadora(id);
	  }
	  
	  public void updateGravadora(int id, Gravadora gravadora) {
		  gdao.updateGravadora(id, gravadora);
	  }
}
