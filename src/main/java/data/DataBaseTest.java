package data;

import client.Client;
import client.ClientService;

import java.sql.SQLException;


public class DataBaseTest {
    public static void main(String[] args) throws SQLException {
        DatabaseInitServiceFlyway flyway = new DatabaseInitServiceFlyway();
        ClientService service = new ClientService();
        Client client = new Client();

        flyway.initDb();

        client.setName("Test1");
        service.create(client);

        System.out.println(service.getById(6));
        for (int i = 0; i < service.listAll().size(); i++)

            System.out.println(service.listAll().get(i));
        service.setName(6,"CompanyGOIT");
        
        service.deleteById(6);
    }
}

