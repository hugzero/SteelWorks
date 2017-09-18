package com.xwtz.platform.steel.report;

import org.mortbay.jetty.Request;
import org.mortbay.jetty.Response;

public abstract class AbstractReport implements Report {

	@Override
	public void log(Request request, Response response) {
		   StringBuilder buf = new StringBuilder();
	        buf.append("Jetty ");
	        buf.append(request.getServerName());
	        buf.append(' ');
	        buf.append(request.getRemoteAddr());
	        buf.append(" - ");
	        String user = request.getRemoteUser();
	        buf.append((user == null)? " - " : user);
	        buf.append(" [");
	        buf.append(request.getTimeStampBuffer().toString());
	        buf.append("] \"");
	        buf.append(request.getMethod());
	        buf.append(' ');
	        buf.append(request.getUri());
	        buf.append(' ');
	        buf.append(request.getProtocol());
	        buf.append("\" ");
	        int status = response.getStatus();
	        if (status<=0)
	        {
	            status=404;
	        }
	        buf.append(status);
	        long responseLength=response.getContentCount();
	        if (responseLength >=0)
	        {
	            buf.append(' ');
	            buf.append(responseLength);
	        }
	        report(buf);
	}

	@Override
	public boolean isFailed() {
		return false;
	}

	@Override
	public boolean isRunning() {
		return true;
	}

	@Override
	public boolean isStarted() {
		return true;
	}

	@Override
	public boolean isStarting() {
		return false;
	}

	@Override
	public boolean isStopped() {
		return false;
	}

	@Override
	public boolean isStopping() {
		return false;
	}

	@Override
	public void start() throws Exception {
		
	}

	@Override
	public void stop() throws Exception {
		
	}

}
