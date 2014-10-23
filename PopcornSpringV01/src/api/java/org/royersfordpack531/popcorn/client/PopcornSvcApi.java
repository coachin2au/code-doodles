package org.royersfordpack531.popcorn.client;

import java.util.List;

import org.royersfordpack531.popcorn.controller.Popcorn;
import org.royersfordpack531.popcorn.controller.InventoryList;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * This interface defines an API for a VideoSvc. The
 * interface is used to provide a contract for client/server
 * interactions. The interface is annotated with Retrofit
 * annotations so that clients can automatically convert the
 * interface into a client object. See VideoSvcClientApiTest
 * for an example of how Retrofit is used to turn this interface
 * into a client.
 * 
 * @author jules
 *
 */
public interface PopcornSvcApi 
{
	// The path where we expect the Popcorn App to live
	public static final String INVENTORY_SVC_PATH = "/inventory";

	@GET(INVENTORY_SVC_PATH)
	public int getInventoryCount(Popcorn type);
	
	
// we'll do posts later
//	@POST(INVENTORY_SVC_PATH)
	// BFTODO - get an appropriate method queued up
//	public boolean addVideo(@Body Video v);
	

}
