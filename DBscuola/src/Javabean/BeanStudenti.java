package Javabean;

public class BeanStudenti {
	private String nome,cognome,dn,citta;
	private int matricola;
	
	public String getNome() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}
	public String getDn() {
		return dn;
	}
	public String getCitta() {
		return citta;
	}
	public int getMatricola() {
		return matricola;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public void setDn(String dn) {
		this.dn = dn;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}
	
}
