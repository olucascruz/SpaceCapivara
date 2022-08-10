package com.space_capivara.classes;

public class HUD {

	private String capi_feliz;
	private String capi_raivosa;
	private String capi_triste;
	private String coracao1;
	private String coracao2;
	private String coracao3;
	private String inimigo;
	
	public HUD() {
		capi_feliz = "capi_feliz.png";
		capi_raivosa = "capi_raivosa.png";
		capi_triste = "capi_triste.png";
		coracao1 = "heart.png";
		coracao2 = "heart.png";
		coracao3 = "heart.png";
		inimigo = "enemy.png";
	}

	public String getCapi_feliz() {
		return capi_feliz;
	}

	public void setCapi_feliz(String capi_feliz) {
		this.capi_feliz = capi_feliz;
	}

	public String getCapi_raivosa() {
		return capi_raivosa;
	}

	public void setCapi_raivosa(String capi_raivosa) {
		this.capi_raivosa = capi_raivosa;
	}

	public String getCapi_triste() {
		return capi_triste;
	}

	public void setCapi_triste(String capi_triste) {
		this.capi_triste = capi_triste;
	}

	public String getCoracao1() {
		return coracao1;
	}

	public void setCoracao1(String coracao1) {
		this.coracao1 = coracao1;
	}

	public String getCoracao2() {
		return coracao2;
	}

	public void setCoracao2(String coracao2) {
		this.coracao2 = coracao2;
	}

	public String getCoracao3() {
		return coracao3;
	}

	public void setCoracao3(String coracao3) {
		this.coracao3 = coracao3;
	}

	public String getInimigo() {
		return inimigo;
	}

	public void setInimigo(String inimigo) {
		this.inimigo = inimigo;
	}
	
}
