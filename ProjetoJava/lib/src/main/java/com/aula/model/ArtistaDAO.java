package com.aula.model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ArtistaDAO {

	@Autowired 
    DataSource dataSource;
    
	JdbcTemplate jdbc;
	
    @PostConstruct
    private void initialize(){
        jdbc = new JdbcTemplate(dataSource);
    }
    
    //INSERE
    public void insertA(Artista artista) {
        String sql = "INSERT INTO artista " + "(nome,email) VALUES (?,?)" ;
       jdbc.update(sql, new Object[]{
    		   artista.getNome(), artista.getEmail()
        });
    }
    
    //SELECIONA 1
    public Map<String,Object> getArtista(int id){
    	String sql = "SELECT * FROM artista WHERE artista.id = ?";
    	return jdbc.queryForMap(sql, new Object[] {id});
    }
    
    //SELECIONA TUDO
    public List<Map<String,Object>> getArtistas(){
    	String sql = "SELECT * FROM artista ORDER BY id";
    	List<Map<String,Object>> artistas = (List<Map<String,Object>>) jdbc.queryForList(sql);
    	return artistas;
    }
    
    //DELETA
    public void deleteArtista(int id) {
        String sql = "DELETE FROM artista WHERE id = ?" ;
       jdbc.update(sql, new Object[]{id});
    }
    
    //EDITA
    public void updateArtista(int id, Artista artista) {
    	String sql = "UPDATE artista SET nome = ?, email = ? WHERE id = ?";
    	jdbc.update(sql, new Object[]{
    			artista.getNome(), artista.getEmail(), id
    	});
    }
}
