package cn.tedu.service.impl;

import cn.tedu.service.HelloService;

/**
 * 服务提供者接口实现类
 * @author Administrator
 */
public class HelloServiceImpl implements HelloService {

	@Override
	public String hello(String name) {
		return "hello "+name;
	}

}
