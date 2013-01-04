/**
	Description:java模拟 Ping的效果
	Date:2013.1.4日
	author:LiShixi
*/

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
public class JavaPing{
	public static void main(String[] args){
		new JavaPing().isAddressAvailable(args[0]);
	}
	
	void isAddressAvailable(String ip){
		try{
			InetAddress address=InetAddress.getByName(ip);
			
			if(address instanceof java.net.Inet4Address){
				System.out.println(ip+" is Ipv4 address");
			}else
				if(address instanceof java.net.Inet6Address){
				System.out.println(ip+" is Ipv6 address");
			} else{
				System.out.println(ip+" is unrecongized");
			}
			
			if(address.isReachable(5000)){
				System.out.println("成功 - ping "+ip);
			}else{
				System.out.println("失败 - ping "+ip);
			}
			Enumeration<NetworkInterface> netInterfaces=NetworkInterface.getNetworkInterfaces();
			while(netInterfaces.hasMoreElements()){
				NetworkInterface ni=netInterfaces.nextElement();
				System.out.println("检查接口,显示名(displayName)："+ni.getDisplayName()+",名字(name):"+ni.getName());
				if(address.isReachable(ni,0,5000)){
					System.out.println("成功 - Ping "+ip);
				}else{
					System.out.println("失败 - Ping "+ip);
				}
				
				Enumeration<InetAddress> ips=ni.getInetAddresses();
				while(ips.hasMoreElements()){
					System.out.println("Ip: "+ips.nextElement().getHostAddress());
				}
				System.out.println("----------------------------------");
			}
		}catch( Exception ex){
			System.out.println("出现错误");
			ex.printStackTrace();
		}
	}
}