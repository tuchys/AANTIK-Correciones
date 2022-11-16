package com.aantik.demo.service;

import com.aantik.demo.entidad.User;

public interface UserCRUDLocal {
	public User getUserById(Long id) throws Exception;
	public User getUserByUsername(String username) throws Exception;
	public User crearUsuario(User user) throws Exception;
	public Iterable<User> getAll();
	public boolean login(String username, String password) throws Exception;
	public boolean registro(String username, String password) throws Exception;
}
