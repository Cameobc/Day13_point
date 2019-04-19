package com.sesung.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.sesung.util.DBConnector;

public class DBConnectorTest {

	@Test
	public void test() throws Exception {
		Connection con = DBConnector.dbConnect();
		assertNotNull(con);
	}

}
