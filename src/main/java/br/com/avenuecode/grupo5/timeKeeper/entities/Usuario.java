package br.com.avenuecode.grupo5.timeKeeper.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Usuario {

	public enum Profile {
		BASIC, MANAGER;
	};

	@Id
	@GeneratedValue
	private long id;

	private String login;

	private String senha;

	private Profile profile;

	@OneToMany
	private List<Ponto> pontos;

	public Usuario() {

	}

	public Usuario(long id, String login, String senha, Profile profile) {
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.profile = profile;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Ponto> getPontos() {
		return pontos;
	}

	public void setPontos(List<Ponto> pontos) {
		this.pontos = pontos;
	}

}
