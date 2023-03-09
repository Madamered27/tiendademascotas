package com.puppis.tiendademascotas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.puppis.tiendademascotas.model.ProductoModel;
import com.puppis.tiendademascotas.services.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	ProductoService productoService;
	
	@GetMapping()
	public List<ProductoModel> obtenerProductos(){
		return productoService.obtenerProductos();
	}
	
	
	@GetMapping(path = "/{id}")
	public Optional<ProductoModel> obtenerProductoPorId(@PathVariable("id") Long id){
		return productoService.obtenerPorId(id);
	}
	
	//localhost:8080/producto/query?categoria=gato
	@GetMapping("/query")
	public List<ProductoModel> obtenerProductosPorCategoria(@RequestParam("categoria") String categoria){
		return productoService.obtenerPorCategoria(categoria);
	}
	
	
	@GetMapping("/faltanteStock")
	public List<ProductoModel> obtenerParaReponerStock(){
		return productoService.obtenerParaReponerStock();
	}
	
	
	//@RequestBody para definir el tipo de contenido del cuerpo de la solicitud
	@PostMapping()
	public ProductoModel guardarProducto(@RequestBody ProductoModel producto) {
		return productoService.guardarProducto(producto);
	}
	
	
	
	@DeleteMapping(path = "/{id}")
	public String eliminarProducto(@PathVariable("id") Long id) {
		boolean eliminado = productoService.eliminarProducto(id);
		if(eliminado) {
			return "El producto ha sido eliminado";
		}else {
			return "No se puedo eliminar el producto con id " + id;
		}
	}
	
	//Metodo para update no hace falta hacer ya que CrudRepository tiene un metodo save(), 
	//que si se le envia el id lo toma como una modificacion en cambio si no tiene id sabe que es un producto nuevo

}
