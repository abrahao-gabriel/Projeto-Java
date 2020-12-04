package com.aula.model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GravadoraDAO {

	@Autowired 
    DataSource dataSource;
    
	JdbcTemplate jdbc;
	
    @PostConstruct
    private void initialize(){
        jdbc = new JdbcTemplate(dataSource);
    }
    
    //INSERE
    public void insertG(Gravadora gravadora) {
        String sql = "INSERT INTO gravadora " + "(nome,email) VALUES (?,?)" ;
       jdbc.update(sql, new Object[]{
    		   gravadora.getNome(), gravadora.getEmail()
        });
    }
    
    //SELECIONA 1
    public Map<String,Object> getGravadora(int id){
    	String sql = "SELECT * FROM gravadora WHERE gravadora.id = ?";
    	return jdbc.queryForMap(sql, new Object[] {id});
    }
    
    //SELECIONA TUDO
    public List<Map<String,Object>> getGravadoras(){
    	String sql = "SELECT * FROM gravadora ORDER BY id";
    	List<Map<String,Object>> gravadoras = (List<Map<String,Object>>) jdbc.queryForList(sql);
    	return gravadoras;
    }
    
    //DELETA
    public void deleteGravadora(int id) {
        String sql = "DELETE FROM gravadora WHERE id = ?" ;
       jdbc.update(sql, new Object[]{id});
    }
    
    //EDITA
    public void updateGravadora(int id, Gravadora gravadora) {
    	String sql = "UPDATE gravadora SET nome = ?, email = ? WHERE id = ?";
    	jdbc.update(sql, new Object[]{
    			gravadora.getNome(), gravadora.getEmail(), id
    	});
    }
}
