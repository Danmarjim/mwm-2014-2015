/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.mwm.testcloudfoundry;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Dani
 */
public class DBClient {
    
    private Connection con;
    
    public DBClient(){
        try {
            JsonNode rootNode = new
            ObjectMapper().readTree(System.getenv("VCAP_SERVICES"));
            JsonNode innerNode = rootNode.get("cleardb").get(0);
            if (innerNode!=null){
                JsonNode aField = innerNode.get("credentials");
                if (aField!=null){
                    String host = aField.get("hostname").asText();
                    String database = aField.get("name").asText();
                    String username = aField.get("username").asText();
                    String password = aField.get("password").asText();
                    con = DriverManager.getConnection("jdbc:mysql://"+host+":3306/"+database, username,
                    password);
                }
            }
        } catch (IOException ex) {
            System.out.println (ex.toString());
        } catch (SQLException ex) { 
            System.out.println (ex.toString());
        }
    }
    
    @Override
    public void finalize(){
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println (ex.toString());
        }
    }
    
    public String getClients(){
        String result = "";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Client");
            result+="<table>";
            result+="<tr><th>idClient</th><th>Name</th></tr>";
            while (rs.next()) {
                result+="<tr>";
                result+="<td>"+rs.getInt("idClient")+"</td>";
                result+="<td>"+rs.getString("Address")+"</td>";
                result+="<td>"+rs.getString("Name")+"</td>";
                result+="</tr>";
            }
            result+="</table>";
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            System.out.println (ex.toString());
        }
        return result;
    }
}
