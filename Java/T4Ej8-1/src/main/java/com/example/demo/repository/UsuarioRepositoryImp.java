package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Perfil;
import com.example.demo.model.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class UsuarioRepositoryImp implements UsuarioRepository {// debe llevar implements

	@PersistenceContext
	private EntityManager puente;

	@Override
	public List<Usuario> getAllUsuarios() {
		Query query = puente.createQuery("select u from Usuario u", Usuario.class);
		List<Usuario> usuarios = query.getResultList();
		return usuarios;
	}

	@Override
	public Usuario getUsuarioPorId(Integer id) {

		Usuario usuario = puente.find(Usuario.class, id);
		return usuario;
	}

	@Override
	public void insertarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizarUsuario() {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrarUsuario(Integer idUsuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizarPerfilUsuario(Integer idUsuario, Perfil nuevoPerfil) {
		// TODO Auto-generated method stub

	}

	@Override
	public Perfil obtenerPerfilPorId(Integer idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarEstadoPerfil(Integer idUsuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Usuario> getUsuariosBiografiaEdad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario getPrimerUsuarioDisponible() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> getUsuariosNoDisponibles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEstadoDisponible() {
		// TODO Auto-generated method stub

	}

}
