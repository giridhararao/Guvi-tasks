import javax.ws.rs.core.Response;
import java.sql.Connection;
import lombok.Cleanup;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.core.Response;

public class dao{
  public statis ArrayList<DataModel> getalldata(String category1, String category2){
   ArrayList<DataModel> dataModels =new ArrayList<>();
  try{
     
      String query="select prod_name,price,categories from Sample_data "
      String str2="where categories like '%"+category1+"%' ";
      String str3="where categories like '%"+category2+"%'";
      if (category1 != null && !category1.equals("0") && !category1.equals("selectall")){
        if (category1.length() > 0 && !category1.trim().isEmpty()){
             query=query+str2;
        }
      }
      if (category2 != null && !category2.equals("0") && !category2.equals("selectall")){
        if (category2.length() > 0 && !category2.trim().isEmpty()){
             query=query+str3;
        }
      }
      @Cleanup Connection con = ConnectionUtil.getConnection();        //connect it to database on which you are working.
      @Cleanup PreparedStatement pstmt = con.prepareStatement(query);
      @Cleanup ResultSet rs = pstmt.executeQuery();
      while(rs.next()){
        DataModel dataModel = new DataModel();
        dataModel.setname(rs.getString("prod_name"));
        dataModel.setprice(rs.getInt("price"));
        dataModel.setcategories(rs.getString("categories"));
        dataModels.add(poOutletModel);
      }

    return(dataModels);
   }catch (Exception ex) {
      logger.log(Level.INFO, "Exception in getalldata method ", ex);
      
    }
    return(dataModels);
  }


  public static ArrayList<String> getCategories(){
  ArrayList<String> datas =new ArrayList<>();
  try{
        @Cleanup Connection con = ConnectionUtil.getConnection();     //for connection connect to database on which you are working.
      @Cleanup PreparedStatement pstmt = con.prepareStatement("SELECT categories FROM Sample_data");
      @Cleanup ResultSet rs = pstmt.executeQuery();
      for(String str1 : rs){
          datas.addall(str1.split(","));
      }
  }catch (Exception e){
      logger.log(Level.SEVERE, "Exception in getCategories method", e);
  }
  return(datas);
}

