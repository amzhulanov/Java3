package ru.geekbrains.lesson2;

import java.sql.*;

public class JdbcDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
       // Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/network_chat","root","Fqtlfqk");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/network_chat?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Novosibirsk","root","Fqtlfqk");
        //url = "jdbc:mysql://192.168.1.100:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Moscow";

        PreparedStatement preparedStatement=con.prepareStatement("insert into users (login,password) values(?,?)");
        preparedStatement.setString(1,"Ivan");
        preparedStatement.setString(2,"111");
        preparedStatement.execute();

        Statement stmt=con.createStatement();
        ResultSet resultSet=stmt.executeQuery("select * from users");

                while (resultSet.next()){
            System.out.printf("%d\t%s\t%s%n",resultSet.getInt(1),
                                            resultSet.getString(2),
                                            resultSet.getString(3));
        }
        resultSet.close();



    }
}
