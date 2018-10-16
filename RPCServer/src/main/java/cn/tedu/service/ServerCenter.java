package cn.tedu.service;

import java.io.IOException;

/**
 * 服务中心的接口定义
 * @author Administrator
 */
public interface ServerCenter {

	public void stop();
	
	public void start() throws IOException;
	
	public void register(Class ServiceInterface,Class ServiceInterfaceImpl);
	
	public boolean isRunning();
	
	public int getPort();
}
