package br.proj.rd;

import java.util.ArrayList;
import java.util.List;

public class Container {
		
		private List<User> user = new ArrayList<User>();
		private static int id = 0;
		
		public void inserir(User usuario) {
			usuario.setId(id);
			user.add(usuario);
			id++;
		}
		
		public List<User> consultaUsuarios() {
			return user;
		}
		
		public User consultaUsuarios(int indice) {
			return user.get(indice);
		}
		
		public void alterarUsuario(int id, String email, String nome, String pais) {
			User user = consultaUsuarios(id);
			user.setEmail(email);
			user.setNome(nome);
			user.setPais(pais);
		}
		
		public void deletar(int indice) {
			user.remove(indice);
		}
		
		
	
}
