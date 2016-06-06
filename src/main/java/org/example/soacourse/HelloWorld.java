package org.example.soacourse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/hello")
@Api(value = "/hello", description = "Operations about pets")
public class HelloWorld {

    @GET
    @Path("/echo/{input}")
    @Produces("text/plain")
    @ApiOperation(value = "Echo input parameter", 
    notes = "Returns the input value as an echo answer",
    response = String.class)
    public String ping(@PathParam("input") String input) {
    	//Testing the Deployment Pipeline reaction when adding this line
    	//And this line too
    	//And this
    	//new line
        return input;
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/jsonBean")
    public Response modifyJson(JsonBean input) {
    	//assing input va1 to input val2 
        input.setVal2(input.getVal1());
        //return transformed input as an OK response
        return Response.ok().entity(input).build();
    }
    
    @GET
    @Path("/code-analysis/bad")
    @Produces("application/json")
    public JsonBean badCodeAnalysis() {
    	//System.out.println("Testing SonarQube");
    	//System.exit(0);
    	
        return new JsonBean();
    }
}

