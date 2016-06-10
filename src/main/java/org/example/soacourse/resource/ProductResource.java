package org.example.soacourse.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.example.soacourse.logic.ProductLogic;
import org.example.soacourse.model.ProductBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@Path("/products")
@Api(value = "Products category")
@Produces("application/json")
public class ProductResource {
	
	static ProductLogic productLogic = new ProductLogic();
	
	@GET
    @Path("/")
    @ApiOperation(value = "Retrieve the catalogue's products", 
		response = ProductBean.class,
		responseContainer = "List")
    @Consumes("application/json")
    public Response getProducts() {
    	ArrayList<ProductBean> arr = new ArrayList<ProductBean>();
    	arr.add(new ProductBean("Prod 1", 12.5));
    	arr.add(new ProductBean("Prod 2", 7.3));
    	return Response.ok(arr).build();
    }
	
	@GET
    @Path("/{productId}")
    @ApiOperation(
    		value = "Retrieve the product's details", 
    		response = ProductBean.class)
	@ApiResponses(value = { 
		      @ApiResponse(code = 400, message = "Invalid ID supplied"),
		      @ApiResponse(code = 404, message = "Product not found") })
    public Response getProduct(
    		@ApiParam(value = "Product ID to be retrieved", required = true) @PathParam("productId") long productId
    		) {

		return Response.ok(productLogic.getProductDetails(productId)).build();
    }
	
	@GET
    @Path("/by_status")
    @ApiOperation(value = "Find products by status",
    	notes = "Multiple status values can be provided with comma separated strings", 
		response = ProductBean.class,
		responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid status value") })
    public Response findProductsByStatus(
    		@ApiParam(value = "Status values that need to be considered for filter", 
    			required = false, 
    			defaultValue = "available", 
    			allowableValues = "available,pending,sold", 
    			allowMultiple = true) 
    		@QueryParam("status") List<String> status) {
        return Response.ok(productLogic.findProductsByStatus(status)).build();
    }
	
	@POST
    @Path("/")
    @ApiOperation(value = "Add a new product to the catalogue", 
    	notes = "The method needs a Product object",
		response = ProductBean.class)
	@Consumes("application/json")
    public Response addNewProduct(
    		@ApiParam(value = "Product object", required = true) ProductBean product) {
    	
    	product.setId(123);
    	
        return Response.ok(product).build();
    }
}
