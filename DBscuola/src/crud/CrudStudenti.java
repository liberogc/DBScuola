package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Javabean.BeanStudenti;
import connessioni.Connessioni;
import interfacce.ICrudStudenti;
import servizi.Servizi;

public class CrudStudenti extends Connessioni implements ICrudStudenti{
	Servizi servizi = new  Servizi();
	//Connessioni connessione = new Connessioni();
	
	String query;	
	Connection connesso;
	ResultSet rs;
	Statement st;
	PreparedStatement pst;	
	
	@Override
	public BeanStudenti creaStudente() {
		BeanStudenti studente = new BeanStudenti();
		studente.setMatricola(servizi.sceltaNumerica("Inserire la MATRICOLA STUDENTE"));
		studente.setNome(servizi.sceltaTesto("Inserire il NOME studente"));
		studente.setCognome(servizi.sceltaTesto("Inserire il COGNOME studente"));
		studente.setCitta(servizi.sceltaTesto("Inserire la CITTA studente"));
		studente.setDn(servizi.sceltaTesto("Inserire la DATA NASCITA studente (dd-mm-yyyy)"));
		return studente;		
	}
	
	@Override
	public void salvaStudente(BeanStudenti stu) {
		connesso=connettiScuola();
		query="INSERT INTO studenti(matricola,nome,cognome,citta,dn) values(?,?,?,?,?)";
		try {
			String[] dataita=stu.getDn().split("-");
			String dataing=dataita[2]+"-"+dataita[1]+"-"+dataita[0];
			pst=connesso.prepareStatement(query);			
			pst.setInt(1, stu.getMatricola());
			pst.setString(2, stu.getNome());
			pst.setString(3, stu.getCognome());
			pst.setString(4, stu.getCitta());
			pst.setString(5, dataing);
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Errore Eccezione SQL nel metodo salvaStudente() "+e);
		} 		
	} 
	
	@Override
	public ResultSet lista() {
		connesso=connettiScuola();
		query="select * from studenti";
		try {
			st=connesso.createStatement();
			rs=st.executeQuery(query);
			//connesso.close();
		} catch (SQLException e) {
			System.out.println("Errore Eccezione SQL nel metodo  lista()  "+e);
		}
		
		return rs;		
	}
} // fine classe
