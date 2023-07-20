package it.betacom.bean;

public class Cliente {
	
	private String nome;
	private String cognome;
	private String username;
	private String email;
	private String cellulare;
	private String dataDiNascita;
	private String password ;
	private int count=3;
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	public String getCognome() {return cognome;}
	public void setCognome(String cognome) {this.cognome = cognome;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	public String getCellulare() {return cellulare;}
	public void setCellulare(String cellulare) {this.cellulare = cellulare;}
	public String getDataDiNascita() {return dataDiNascita;}
	public void setDataDiNascita(String dataDiNascita) {this.dataDiNascita = dataDiNascita;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
