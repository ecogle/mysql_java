package tools;

import java.io.File;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Config {
	
	private String host;
	private String port;
	private String username;
	private String password;
	private String database;
	private DB_TYPES type;
	
	public Config(DB_TYPES dbtype) {
		this.type = dbtype;
		initialize(dbtype.getName());		
	}
	
	private void initialize(String dbtype) {
		File file = new File("configuration.xml");
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dbBuilder;
		try {
			dbBuilder = dbFactory.newDocumentBuilder();
			Document doc = dbBuilder.parse(file);
			
			doc.getDocumentElement().normalize();
			
			NodeList nodes = doc.getElementsByTagName(dbtype);
			
			for(int x = 0; x < nodes.getLength(); x ++)
			{
				Node node = nodes.item(x);
				
				System.out.println(node.getNodeName());
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					this.host = (element.getElementsByTagName("host").item(0).getTextContent());
					this.port = (element.getElementsByTagName("port").item(0).getTextContent());
					this.username = (element.getElementsByTagName("username").item(0).getTextContent());
					this.password = (element.getElementsByTagName("password").item(0).getTextContent());
					this.database = (element.getElementsByTagName("database").item(0).getTextContent());
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static enum DB_TYPES{
		POSTGRES("postgresql"),MYSQL("mysql");
		private String name;
		
		DB_TYPES(String name) {
			this.name = name;
		}
		
		private String getName() {
			return this.name;
		}
	}

	public String getHost() {
		return host;
	}

	public String getPort() {
		return port;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	
	public String getDatabase() {
		return database;
	}

	public String getURL() {
		
		StringBuilder url = new StringBuilder();
		url.append("jdbc:");
		url.append(this.type.getName());
		url.append("://").append(this.host).append(":").append(this.port).append("/").append(this.database);
		
		return url.toString();
	}

	public DB_TYPES getType() {
		return type;
	}
	
	
	

}
