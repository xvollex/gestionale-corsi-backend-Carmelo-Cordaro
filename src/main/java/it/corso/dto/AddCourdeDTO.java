package it.corso.dto;

public class AddCourdeDTO 
{
	private String nomeCorso;
	private String descrizioneBreve;
	private String descrizioneCompleta;
	private int durata;
	
	public String getNomeCorso() {
		return nomeCorso;
	}
	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}
	public String getDescrizioneBreve() {
		return descrizioneBreve;
	}
	public void setDescrizioneBreve(String descrizioneBreve) {
		this.descrizioneBreve = descrizioneBreve;
	}
	public String getDescrizioneCompleta() {
		return descrizioneCompleta;
	}
	public void setDescrizioneCompleta(String descrizioneCompleta) {
		this.descrizioneCompleta = descrizioneCompleta;
	}
	public int getDurata() {
		return durata;
	}
	public void setDurata(int durata) {
		this.durata = durata;
	}
	
	
}
