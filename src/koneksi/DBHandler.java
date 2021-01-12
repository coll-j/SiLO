/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ZK
 */
public class DBHandler {
    static PreparedStatement ps = null;
    static ResultSet res = null;

    public static Object[][] SelectAll(Connection cn, String from){
        ArrayList<ArrayList<String> > data = new ArrayList<ArrayList<String> >();
        String sql = "SELECT * from " + from;
        try{
            ps = cn.prepareStatement(sql);
            res = ps.executeQuery();
            while(res.next()){
                ArrayList<String> row = new ArrayList<String>();
                row.add(res.getString("id"));
                row.add(res.getString("title"));
                row.add(res.getString("description"));
                row.add(res.getString("manufacturer"));
                row.add(res.getString("stocks"));
                data.add(row);
            }
        }catch (SQLException e){
            System.out.println("error");
        }

        Object[][] array = new Object[data.size()][];
        for (int i = 0; i < data.size(); i++) {
            ArrayList<String> row = data.get(i);
            array[i] = row.toArray(new String[row.size()]);
        }
        
        System.out.println("Data retrieved from " + from);
        return array;
    }
}
