package com.space_capivara.classes;

public class Menu {
	
	private String fundo_menu;
	private String fundo_team;
	private String game_title;
	private String creditos;
	private String arrow;
	private int arrow_position;
	private String btn_jogar;
	private String btn_creditos;
	private boolean team_selected;
	private boolean btn_jogar_selected;
	
	public Menu() {
		fundo_menu = "capi_back.png";
		fundo_team = "alien_back.png";
		game_title = "game_title.png";
		creditos = "creditos.png";
		arrow = "arrow.png";
		arrow_position = 0;
		btn_jogar = "btn_jogar.png";
		btn_creditos = "btn_creditos.png";
		team_selected = false;
		btn_jogar_selected = true;
		
	}

	public String getCreditos() {
		return creditos;
	}

	public void setCreditos(String creditos) {
		this.creditos = creditos;
	}

	public boolean isBtn_jogar_selected() {
		return btn_jogar_selected;
	}

	public void setBtn_jogar_selected(boolean btn_jogar_selected) {
		this.btn_jogar_selected = btn_jogar_selected;
	}

	public int getArrow_position() {
		return arrow_position;
	}

	public void setArrow_position(int arrow_position) {
		this.arrow_position = arrow_position;
	}

	public String getGame_title() {
		return game_title;
	}

	public void setGame_title(String game_title) {
		this.game_title = game_title;
	}

	public String getArrow() {
		return arrow;
	}

	public void setArrow(String arrow) {
		this.arrow = arrow;
	}

	public String getBtn_jogar() {
		return btn_jogar;
	}

	public void setBtn_jogar(String btn_jogar) {
		this.btn_jogar = btn_jogar;
	}

	public String getBtn_creditos() {
		return btn_creditos;
	}

	public void setBtn_creditos(String btn_creditos) {
		this.btn_creditos = btn_creditos;
	}

	public String getFundo_menu() {
		return fundo_menu;
	}

	public void setFundo_menu(String fundo_menu) {
		this.fundo_menu = fundo_menu;
	}

	public String getFundo_team() {
		return fundo_team;
	}

	public void setFundo_team(String fundo_team) {
		this.fundo_team = fundo_team;
	}

	public boolean isTeam_selected() {
		return team_selected;
	}

	public void setTeam_selected(boolean team_selected) {
		this.team_selected = team_selected;
	}

}
