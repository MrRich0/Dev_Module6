package client;

import prefs.Prefs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private PreparedStatement insertStClientSt;
    private PreparedStatement selectMaxIdSt;
    private PreparedStatement getByIdSt;
    private PreparedStatement setNameSt;
    private PreparedStatement deleteByIdSt;
    private PreparedStatement listAllSt;

    public ClientService() throws SQLException {
        String connectionUrl = new Prefs().getString(Prefs.JDBC_CONNECTION_URL);
        Connection connection = DriverManager.getConnection(connectionUrl);

        insertStClientSt = connection.prepareStatement(
                "INSERT INTO client (NAME) VALUES ( ?)"
        );
        selectMaxIdSt = connection.prepareStatement(
                "SELECT max(id) AS maxId FROM client"
        );
        getByIdSt = connection.prepareStatement(
                "SELECT name FROM client WHERE id = ?"
        );
        setNameSt = connection.prepareStatement(
                "UPDATE client SET name = ? WHERE id = ?"
        );
        deleteByIdSt = connection.prepareStatement(
                "DELETE FROM client WHERE id = ?"
        );
        listAllSt = connection.prepareStatement(
                "SELECT *FROM client"
        );
    }

    public long create(Client client) throws SQLException {
        insertStClientSt.setString(1, client.getName());

        long id;
        try(ResultSet resultSet = selectMaxIdSt.executeQuery()){
            resultSet.next();
            id = resultSet.getLong("maxId");
        }

        return id;
    }

    public String getById(long id) throws SQLException {
        getByIdSt.setLong(1, id);
        Client clientResult = new Client();

        try(ResultSet resultSet = getByIdSt.executeQuery()){
            if(!resultSet.next())
            return null;

            clientResult.setId(id);
            clientResult.setName(resultSet.getString("name"));
        }
        return String.valueOf(clientResult);
    }

    public void setName(long id, String name) throws SQLException {
        setNameSt.setString(1, name);
        setNameSt.setLong(2, id);

        setNameSt.executeUpdate();
    }

    public void deleteById(long id) throws SQLException {
            deleteByIdSt.setLong(1, id);
            deleteByIdSt.executeUpdate();
    }

    public List<Client> listAll() throws SQLException {
        List<Client> clientsAll = new ArrayList<>();
        try(ResultSet resultSet = listAllSt.executeQuery()) {
            while (resultSet.next()) {
                Client client = new Client();

                client.setId(resultSet.getLong("id"));
                client.setName(resultSet.getString("name"));

                clientsAll.add(client);
            }
        }
        return clientsAll;
    }
}
