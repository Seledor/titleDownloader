package cz.quazard.title.opensubtitles.org;

import java.net.URL;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

public class TestXmlRpcApi {

	public static void main(String[] args) throws Exception {
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		config.setServerURL(new URL("​http://api.opensubtitles.org/xml-rpc"));

		XmlRpcClient client = new XmlRpcClient();
		client.setConfig(config);
	}

}
