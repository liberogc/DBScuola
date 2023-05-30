package principale;

import java.sql.ResultSet;
import java.sql.SQLException;

import Javabean.BeanStudenti;
import crud.CrudStudenti;
import servizi.Servizi;

public class Test {

	public static void main(String[] args) {
		Servizi servizi = new Servizi();
		CrudStudenti crudstu = new CrudStudenti(); // Classe che contiene i metodi CRUD di Studenti
		BeanStudenti beanstu;  // la tabella e la classe hanno lo stesso datatype ad 
							   // esclusione delle date che sono stringhe nel bean e DATE nella tabella
		ResultSet rs;
		boolean continua=true;

		while(continua) {
			servizi.menu();
			System.out.println();
			//System.out.println("Effettua una scelta menu");
			int scelta=servizi.sceltaNumerica("Effettuare una Scelta");
			switch (scelta) {
			case 1:	// inserimento studenti
				beanstu=crudstu.creaStudente();
				crudstu.salvaStudente(beanstu);
				break;
			case 2:	// lista studenti	
				rs=crudstu.lista();
				System.out.println();
				try {
					while(rs.next()) {
						String[] dataing=rs.getString("dn").split("-");
						String dataita=dataing[2]+"-"+dataing[1]+"-"+dataing[0];
						System.out.println(rs.getInt("matricola")+" "+rs.getString("nome")+" "+rs.getString("cognome")+" "+dataita);
					}
					System.out.println();
				} catch (SQLException e) {
					System.out.println("Eccezione SQL metodo main() oggetto Resultset "+e);
				}
				break;
			case 3:		// cerca e modifica	
				
				break;
			case 4:		// cerca e cancella	
				
				break;
			case 7:
				continua=false;
				break;
			} // fine switch
		} // fine while

	}

}
