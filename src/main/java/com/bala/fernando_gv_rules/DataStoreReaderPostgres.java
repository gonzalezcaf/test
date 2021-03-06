package com.bala.fernando_gv_rules;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataStoreReaderPostgres {

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
					.executeQuery("SELECT codigo, descripcion FROM public.codcardiovascular");
			while (resultSet.next()) {
				System.out.printf("%-30.30s  %-30.40s%n",
						resultSet.getString("codigo"),
						resultSet.getString("descripcion"));
				listaCodigos.add(resultSet.getString("codigo"));
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

	public DataStoreReaderPostgres() {
	}
}