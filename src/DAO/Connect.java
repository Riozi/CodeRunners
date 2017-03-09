
package DAO;

import java.sql.Connection;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class Connect
{
    // Declare the JDBC objects.
    private Connection connection;

    public Connect()
    {
	try
	{

	    SQLServerDataSource ds = new SQLServerDataSource();

	    ds.setServerName("STA6017523\\SQLEXPRESS");
	    ds.setPortNumber(1433);
	    ds.setDatabaseName("PROGICA");
	    ds.setIntegratedSecurity(false);
	    ds.setUser("sa");
	    ds.setPassword("0000");

	    connection = ds.getConnection();
	}

	catch (Exception e)
	{
	    e.printStackTrace();
	}
        

    }

    public Connection getConnection()
    {
	return connection;
    }

}
