package com.prueba.bancooccidente;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.internal.testutils.Timer;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

import jakarta.ws.rs.core.Application;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamLambdaHandler implements RequestStreamHandler{
	
	 private static final SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;

	    static {
	        try {
	            handler = SpringBootLambdaContainerHandler.getAwsProxyHandler(Application.class);
	        } catch (ContainerInitializationException e) {
	            // if we fail here. We re-throw the exception to force another cold start
	            e.printStackTrace();
	            throw new RuntimeException("Could not initialize Spring Boot application", e);
	        }
	    }

	    public StreamLambdaHandler() {
	        // we enable the timer for debugging. This SHOULD NOT be enabled in production.
	        Timer.enable();
	    }

	@Override
	public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
		// TODO Auto-generated method stub
		
	}

}