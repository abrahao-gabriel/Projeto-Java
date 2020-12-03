package com.aula.model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MusicaDAO {

	@Autowired 
    DataSource dataSource;
    
	JdbcTemplate jdbc;
	
    @PostConstruct
    private void initialize(){
        jdbc = new JdbcTemplate(dataSource);
    }
    
    //INSERE musica
    public void insert(Musica musica) {
        String sql = "INSERT INTO musica " + "(nome,artista,gravadora,estilo) VALUES (?,?,?,?)" ;
       jdbc.update(sql, new Object[]{
        		musica.getNome(), musica.getArtista(), musica.getGravadora(), musica.getEstilo()
        });
    }
    
    //SELECIONA 1
    public Map<String,Object> getMusica(int id){
    	String sql = "SELECT * FROM musica WHERE musica.id = ?";
    	return jdbc.queryForMap(sql, new Object[] {id});
    }
    
    //SELECIONA TUDO
    public List<Map<String,Object>> getMusicas(){
    	String sql = "SELECT * FROM musica";
    	List<Map<String,Object>> musicas = (List<Map<String,Object>>) jdbc.queryForList(sql);
    	return musicas;
    }
    
    //DELETA
    public void deleteMusica(int id) {
        String sql = "DELETE FROM musica WHERE id = ?" ;
       jdbc.update(sql, new Object[]{id});
    }
}
