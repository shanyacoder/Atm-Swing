/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AtmMechn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author shanya
 */
public class MainClass {
    
    Connection con;
    Statement st;
    ResultSet rs;
  
 public MainClass()
 {
     try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rwork","root","root");
            st=con.createStatement();
         }catch(Exception e){System.out.println(e);}
 }
 
 public int InsertData(String name,int a,String un,String pw){
       try{
               String sql="insert into atm(name,amount,userid,password) values('"+name+"','"+a+"','"+un+"','"+pw+"')";
               int k=st.executeUpdate(sql);
               
               if(k>0){
                   System.out.println("inserted");
                   return 1;
               }else
               {
                  System.out.println("inserted");
                  return 2;
               }
           
       }catch(Exception e){System.out.println(e);}
     
     return 0;
     
 }
 public ResultSet Check(String us,String pw){
     try{
         String sql="select * from atm where userid='"+us+"' and password='"+pw+"' ";
         rs=st.executeQuery(sql);
         return rs;
     
        
     }catch(Exception e){System.out.println(e);}
     return null;
     
 }
 public ResultSet Data(String un,String pw){
        try{
                String sql="select amount from atm where userid='"+un+"' and password='"+pw+"' ";
                rs=st.executeQuery(sql);
                return rs;
            
        }catch(Exception e){System.out.println(e);}
         return null;
   }
 public int depup(int tamt,String uid){
     try{
           String sql="update atm set amount='"+tamt+"' where userid='"+uid+"'"; 
           int up=st.executeUpdate(sql);
     }catch (Exception e){System.out.println(e);}
     
        return 0;
     
 }
 public int withup(int wamt,String uid){
     try{
            String sql="update atm set amount='"+wamt+"' where userid='"+uid+"' ";
            int wi=st.executeUpdate(sql);
         
     }catch (Exception e){System.out.println(e);}
        
     return 0;
     
 }
// public ResultSet balnce(String ui,String pw)
// {
//     try{
//            String sql="select amount"
//     }catch (Exception e){System.out.println(e);}
//        return null;
//     
// }
    
    
}
