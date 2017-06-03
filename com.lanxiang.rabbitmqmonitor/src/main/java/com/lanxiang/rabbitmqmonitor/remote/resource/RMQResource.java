package com.lanxiang.rabbitmqmonitor.remote.resource;

import com.lanxiang.rabbitmqmonitor.remote.model.response.QueueInfo;
import com.lanxiang.rabbitmqmonitor.remote.model.response.Vhost;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by lanxiang on 2017/4/21.
 */

@Path("api")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public interface RMQResource {

    @GET
    @Path("vhosts")
    Vhost[] getVhosts();

    /**
     * Declares a test queue, then publishes and consumes a message. Intended for use by monitoring tools.
     * If everything is working correctly, will return HTTP status 200 with body:
     *
     * @return {@link com.lanxiang.rabbitmqmonitor.remote.model.response.CheckResp}
     */
    @GET
    @Path("aliveness-test/{vhost}")
    Response testAliveness(@PathParam("vhost") String vhost);


    /**
     * Return a queue`s info
     *
     * @param vhost
     * @param name
     * @return {@link QueueInfo}
     */
    @GET
    @Path("queues/{vhost}/{name}")
    Response getQueueInfo(@PathParam("vhost") String vhost, @PathParam("name") String name);

    @GET
    @Path("nodes")
    Response getNodes();
}