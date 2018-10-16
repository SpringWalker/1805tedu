package cn.tedu.test;

import java.net.InetSocketAddress;

import cn.tedu.client.RPCClient;
import cn.tedu.service.HelloService;
import cn.tedu.service.ServerCenter;
import cn.tedu.service.impl.HelloServiceImpl;
import cn.tedu.service.impl.ServerCenterImpl;

public class Test {

	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					ServerCenter serverCenter=new ServerCenterImpl(8090);
					serverCenter.register(HelloService.class, HelloServiceImpl.class);
					serverCenter.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}).start();

		HelloService service=RPCClient.getRemoteProxyObj(HelloService.class, new InetSocketAddress("localhost", 8090));
		String result = service.hello("tomcat猫");
		System.out.println(result);
	}

}
