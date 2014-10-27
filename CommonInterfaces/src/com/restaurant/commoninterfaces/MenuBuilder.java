package com.restaurant.commoninterfaces;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class MenuBuilder {

	public class ItemInfo {
		public ItemInfo (Long id, float price)
		{
			this.setItemId(id);
			this.setPrice(price);
		}
		public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price = price;
		}
		public Long getItemId() {
			return itemId;
		}
		public void setItemId(Long itemId) {
			this.itemId = itemId;
		}
		private Long itemId;
		private float price;
	}

	static DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
            .newInstance();
	private HashMap<String, ItemInfo> items;
	private HashMap<Long, String> idToName;
	private static MenuBuilder menuBuilder = new MenuBuilder();
	
	public static MenuBuilder getInstance() throws NullPointerException
	{
		if (menuBuilder == null) {
			throw new NullPointerException();
		}
		return menuBuilder;
	}
	public void buildMenu() throws ParserConfigurationException, SAXException, IOException
	{
		InputStream in = this.getClass().getClassLoader()
	            .getResourceAsStream("MenuCard.xml");
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(in);
		listNodes(doc.getDocumentElement(),"");
		NodeList list = doc.getElementsByTagName("menuitem");
		
		for(int i = 0; i < list.getLength(); ++i ) {
			Node n = list.item(i);
			Node child = n.getFirstChild();
			String s = child.getLocalName();
			//Long itemId = Long.parseLong(child.getNodeValue());
			child = child.getNextSibling();
			s = child.getLocalName();
			//String name = child.getNodeValue();
			child = child.getNextSibling();
			s = child.getLocalName();
			//float price = Float.parseFloat(child.getNodeValue());
			//items.put(name, new ItemInfo(itemId, price));
			//idToName.put(itemId, name);
		}
		
	}
	private  MenuBuilder()
	{
		try {
			this.buildMenu();
		} catch (ParserConfigurationException p) {
			p.printStackTrace();
		} catch (SAXException s) {
			s.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ItemInfo getItemInfo(String name)
	{
		return items.get(name);
	}
	
	public float getPrice(Long itemId)
	{
		return getPrice(idToName.get(itemId));
	}

	public float getPrice(String name)
	{
		return items.get(name).getPrice();
	}
	
	public String getItemName(Long itemId)
	{
		return idToName.get(itemId);
	}
   
	 static String nodeType(short type) {
		    switch(type) {
		      case Node.ELEMENT_NODE:                return "Element";
		      case Node.DOCUMENT_TYPE_NODE:          return "Document type";
		      case Node.ENTITY_NODE:                 return "Entity";
		      case Node.ENTITY_REFERENCE_NODE:       return "Entity reference";
		      case Node.NOTATION_NODE:               return "Notation";
		      case Node.TEXT_NODE:                   return "Text";
		      case Node.COMMENT_NODE:                return "Comment";
		      case Node.CDATA_SECTION_NODE:          return "CDATA Section";
		      case Node.ATTRIBUTE_NODE:              return "Attribute";
		      case Node.PROCESSING_INSTRUCTION_NODE: return "Attribute";
		    }
		    return "Unidentified";
    }
	private static void listNodes(Node node, String indent)
	{
	    String nodeName = node.getNodeName();
	    System.out.println(indent+" Node: " + nodeName);
	    short type = node.getNodeType();
	    System.out.println(indent+" Node Type: " + nodeType(type));
	    if(type == Node.TEXT_NODE){
	      System.out.println(indent+" Content is: "+((Text)node).getWholeText());
	    }
	    
	    NodeList list = node.getChildNodes();       
	    if(list.getLength() > 0) {                  
	      System.out.println(indent+" Child Nodes of "+nodeName+" are:");
	      for(int i = 0 ; i<list.getLength() ; i++) {
	        listNodes(list.item(i),indent+"  ");     
	      }
	    }         
	}
	
}
