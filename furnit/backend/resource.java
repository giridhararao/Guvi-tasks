import javax.ws.rs.GET;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.FormParam;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import org.json.JSONObject;


@path('/mainpath')
public class resource{
      @GET
    @Path("/alldata")
    @Produces({MediaType.APPLICATION_JSON})
    public ArrayList<DataModel> getOutletStatus(@Context HttpServletRequest req, @QueryParam("category1") String category1,@QueryParam("category2") String category2) {
      return dao.getalldata(category1,category2);
    }

    @GET
    @Path("/categories")
    @Produces({MediaType.APPLICATION_JSON})
    public ArrayList<String> getArea(@Context HttpServletRequest req) {
      return dao.getCategories();

}
