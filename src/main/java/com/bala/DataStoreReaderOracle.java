package com.bala;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataStoreReaderOracle {

	public static List<String> getMerchantCodes() {
		System.out.println("Loading values from database");

		List<String> listaCodigos = new ArrayList<String>();
		try (Connection connection = DriverManager.getConnection(
				"jdbc:postgresql://192.168.122.40:5432/listas", "fgonzalezc",
				"redhat01")) {

			System.out.println("Java JDBC PostgreSQL Example");
			Class.forName("org.postgresql.Driver");

			System.out.println("Connected to PostgreSQL database!");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("select par_reg.diagnostico from his_tb_param_motor_reglas par_reg inner join his_tb_parametro_general par_gen on par_gen.parametro_general = par_reg.param_clasifica_diag and par_gen.codigo_externo = 'DIAG_ECV'");
			while (resultSet.next()) {
				System.out.printf("%-30.30s  %-30.40s%n",
				// resultSet.getString("codigo"),
						resultSet.getString("par_reg.diagnostico"));
				listaCodigos.add(resultSet.getString("par_reg.diagnostico"));
			}

		} catch (ClassNotFoundException e) {
			System.out.println("PostgreSQL JDBC driver not found.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Connection failure.");
			e.printStackTrace();
		}

		return listaCodigos;
	}

	public DataStoreReaderOracle() {
	}
}