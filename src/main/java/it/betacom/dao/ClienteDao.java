package it.betacom.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import it.betacom.bean.Cliente;
import it.betacom.connection.DBHandler;

public class ClienteDao {
	public static DBHandler db = DBHandler.getInstance();

public static int save(Cliente c) {
	int status=0;
	String sql = "INSERT INTO cliente (nome,cognome,email,cellulare,data_di_nascita,passwd) VALUES(?,?,?,?,?,?)";
	try {
		PreparedStatement ps = db.getConnection().prepareStatement(sql);
		ps.setString(1, c.getNome());
		ps.setString(2, c.getCognome());
		ps.setString(3, c.getEmail());
		ps.setString(4, c.getCellulare());
		ps.setString(5, c.getDataDiNascita());
		ps.setString(6, c.getPassword());
		//String username = c.getNome().substring(0,1) + c.getCognome().substring(0,1) + c.getDataDiNascita().substring(5,8);
		//ps.setString(7, c.getUsername());
		status=ps.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return status;
}

public static List<Cliente> getAllRecords(){
	List<Cliente> list = new ArrayList<Cliente>();
	String sql = "Select * from cliente c";
	try {
		PreparedStatement ps = db.getConnection().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Cliente c = new Cliente();
			c.setNome(rs.getString("nome"));
			c.setCognome(rs.getString("cognome"));
			c.setEmail(rs.getString("email"));
			c.setCellulare(rs.getString("cellulare"));
			c.setDataDiNascita(rs.getString("data_di_nascita"));
			c.setPassword(rs.getString("passwd"));
			c.setUsername(rs.getString("username"));
			list.add(c);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}
	public static Cliente getRecordByUsername(String username){
		Cliente c=null;
		String sql = "select * from cliente where username=?";
		try{
			PreparedStatement ps=db.getConnection().prepareStatement(sql);
			ps.setString(1,username);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				c =new Cliente();
				c.setNome(rs.getString("nome"));
				c.setCognome(rs.getString("cognome"));
				c.setEmail(rs.getString("email"));
				c.setCellulare(rs.getString("cellulare"));
				c.setDataDiNascita(rs.getString("data_di_nascita"));
				c.setPassword(rs.getString("passwd"));
				c.setUsername(rs.getString("username"));
			}
		}catch(Exception e){System.out.println(e);}
		return c;
	}
	
	public static int update(Cliente c){
		int status=0;
		String sql = "update cliente set nome=?, cognome = ? ,email = ?, cellulare = ?,  data_di_nascita = ?,passwd=? where username=?";
		try{
			PreparedStatement ps=db.getConnection().prepareStatement(sql);
			ps.setString(1, c.getNome());
			ps.setString(2, c.getCognome());
			ps.setString(3, c.getEmail());
			ps.setString(4, c.getCellulare());
			ps.setString(5, c.getDataDiNascita());
			ps.setString(6, c.getPassword());
			ps.setString(7,	c.getUsername());	
			String username = c.getNome().substring(0,1) + "" + c.getCognome().substring(0,1) + "" + c.getDataDiNascita().substring(5,8);
			c.setUsername(username);
			PreparedStatement ps1=db.getConnection().prepareStatement("update cliente set username = ?");
			ps1.setString(1,c.getUsername());		
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
		
		//AGGIUNGERE CONTROLLO PER AGGIORNARE USERNAME IN BASE A CAMBIAMENTO DEL NOME, COGNOME, DATA NASCITA
	}

	public static int delete(Cliente c){
		int status=0;
		try{
			PreparedStatement ps=db.getConnection().prepareStatement("delete from cliente where username=?");
			ps.setString(1,c.getUsername());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}

		return status;
	}

}