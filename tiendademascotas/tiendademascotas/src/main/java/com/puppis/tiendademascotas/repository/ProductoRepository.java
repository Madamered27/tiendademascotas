package com.puppis.tiendademascotas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.puppis.tiendademascotas.model.ProductoModel;

@Repository
public interface ProductoRepository extends CrudRepository<ProductoModel, Long>{
	//la clase se cambia a interface para asi poder usar los metodos de la clase CrudRepository 
	//CrudRepository<TipoDeDato, TipoDeID>
	
	public abstract List<ProductoModel>findByCategoria(String categoria);
	public abstract List<ProductoModel>findByNombre(String nombre);
	
	
}
