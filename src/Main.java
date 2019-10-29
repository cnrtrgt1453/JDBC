import java.sql.*;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) throws SQLException {
        Connection connection=null;
        DbHelper helper=new DbHelper();
        PreparedStatement statement=null;
        ResultSet resultSet = null;
        try {

            connection= helper.getConnection();
            String sql="update world.city set population=16000000 where id=4092";
            statement=connection.prepareStatement(sql);
            int result=statement.executeUpdate();
            System.out.println("kayıt güncellendi.");

        } catch (SQLException e) {
            helper.showErrorMessage(e);
        }
        finally {
            connection.close();
        }

    }

public static void insertDemo() throws SQLException {
    Connection connection=null;
    DbHelper helper=new DbHelper();
    PreparedStatement statement=null;
    ResultSet resultSet = null;
    try {

        connection= helper.getConnection();
        statement= connection.prepareStatement("insert into world.city (Name,CountryCode,District,Population) values ('Kasimpasa','TUR','Halic',180000)");

        statement.executeUpdate();
        System.out.println("Kayıt Eklendi.");
    } catch (SQLException e) {
        helper.showErrorMessage(e);
    }
    finally {
        statement.close();
        connection.close();
    }

}

public static void selectDemo() throws SQLException {
    Connection connection=null;
    DbHelper helper=new DbHelper();
    Statement statement=null;
    ResultSet resultSet = null;
    try {

        connection= helper.getConnection();
        statement= connection.createStatement();
        resultSet=statement.executeQuery("select Code,Name,Continent,Region from world.country");
        ArrayList<Country> countries=new ArrayList<Country>();
        while (resultSet.next()){
            countries.add(new Country(resultSet.getString("Code"),
                    resultSet.getString("Name"),
                    resultSet.getString("Continent"),
                    resultSet.getString("Region")));
        }
        System.out.println(countries.size());
    } catch (SQLException e) {
        helper.showErrorMessage(e);
    }
    finally {
        statement.close();
        connection.close();
    }

}
}
