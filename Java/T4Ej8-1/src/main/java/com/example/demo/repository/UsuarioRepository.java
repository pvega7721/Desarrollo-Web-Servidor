package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Perfil;
import com.example.demo.model.Usuario;

@Repository
public interface UsuarioRepository {//Debe llevar interface en lugar de class
	public List<Usuario> getAllUsuarios();
	
	public Usuario getUsuarioPorId(Integer id);
	
	public void insertarUsuario(Usuario usuario);
	
	public void actualizarUsuario();//revisar
	
	public void borrarUsuario(Integer idUsuario);
	
	public void actualizarPerfilUsuario(Integer idUsuario, Perfil nuevoPerfil);
	
	public Perfil obtenerPerfilPorId(Integer idUsuario);
	
	public void actualizarEstadoPerfil(Integer idUsuario);
	
	public List<Usuario> getUsuariosBiografiaEdad();
	
	public Usuario getPrimerUsuarioDisponible();
	
	public List<Usuario> getUsuariosNoDisponibles();
	
	public void setEstadoDisponible();
	
}
