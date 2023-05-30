package interfacce;

import java.sql.ResultSet;

import Javabean.BeanStudenti;

public interface ICrudStudenti {
	public BeanStudenti creaStudente();
	public void salvaStudente(BeanStudenti stu);
	public ResultSet lista();
}
