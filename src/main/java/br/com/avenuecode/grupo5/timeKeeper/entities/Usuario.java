package br.com.avenuecode.grupo5.timeKeeper.entities;


import org.springframework.data.annotation.Id;

import javax.annotation.Generated;
import javax.persistence.GeneratedValue;

public class Usuario {

	@Id
	@GeneratedValue
	private long id;
	private String login;
	private String senha;
	private enum Profile {
		BASIC, MANAGER;
	};

	private Profile profile;

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

}
