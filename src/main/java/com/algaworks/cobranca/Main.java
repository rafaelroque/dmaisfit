package com.algaworks.cobranca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		Connection c = DriverManager.getConnection("jdbc:postgres://nhgwsrdd:228B6WLACPVK12Rf9E8GmaKcNffOZlvX@pellefant-02.db.elephantsql.com:5432/nhgwsrdd?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory","nhgwsrdd","228B6WLACPVK12Rf9E8GmaKcNffOZlvX");
		System.out.println(c);
	}
	
}
