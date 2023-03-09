package com.puppis.tiendademascotas.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puppis.tiendademascotas.model.ProductoModel;
import com.puppis.tiendademascotas.repository.ProductoRepository;

@Service
public class ProductoService {
	
	//inyeccion de dependencia
	@Autowired 
	ProductoRepository productoRepository;
	
	public List<ProductoModel> obtenerProductos(){
		//findAll obtiene todos los registros
		return (ArrayList<ProductoModel>) productoRepository.findAll();
	}
	
	//el metodo de no existir id fallaria por eso se usa el Optional, de esta forma si no existe devuelve algo sin inconvenientes
	public Optional<ProductoModel> obtenerPorId(Long id){
		return productoRepository.findById(id);
	}
	
	public List<ProductoModel> obtenerPorCategoria(String categoria){
		return (ArrayList<ProductoModel>) productoRepository.findByCategoria(categoria);
	}
	
	public ProductoModel guardarProducto(ProductoModel producto) {
		return productoRepository.save(producto);
	}
	
	public boolean eliminarProducto(Long id) {
		try {
			productoRepository.deleteById(id);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public List<ProductoModel> obtenerParaReponerStock(){
		List<ProductoModel> productos = (ArrayList<ProductoModel>) productoRepository.findAll();
		List <ProductoModel> productosFaltanteStock = new ArrayList<>();
		
		for(ProductoModel producto : productos){
			if(producto.getStock() <= 5) {
				productosFaltanteStock.add(producto);
			}
		}
		
		return productosFaltanteStock;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
