package ip;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class GetHostAddress {

	public String getHostAddr() {
		String hostAddr = "";
		try {
			Enumeration<NetworkInterface> nienum = NetworkInterface.getNetworkInterfaces();
			while (nienum.hasMoreElements()) {
				NetworkInterface ni = nienum.nextElement();
				Enumeration<InetAddress> kk = ni.getInetAddresses();
				while (kk.hasMoreElements()) {
					InetAddress inetAddress = kk.nextElement();
					if (!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress() && inetAddress.isSiteLocalAddress()) {
						hostAddr = inetAddress.getHostAddress().toString();
					}
				}
			}

		} catch (SocketException e) {
			e.printStackTrace();
		}
		return hostAddr;
	}

	public static void main(String[] args) {
		System.out.println(new GetHostAddress().getHostAddr().trim());
	}
}
