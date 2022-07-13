package com.day21;

import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Test1 {

	public static void main(String[] args) {
		
		try {
			
			//DOM��ü�� �����ϱ� ���� ���丮
			DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = f.newDocumentBuilder();
			
			//�Է¹��� ������ �Ľ��ϵ��� ��û�ϴ� Ŭ����
			Document xmlDoc = null;
			
			String url = "book.xml";
			
			if(url.indexOf("https://")!=-1) { //�����̸�
				
				URL u = new URL(url);
				InputStream is = u.openStream();
				xmlDoc = parser.parse(is);
				
			}else {//�����̸�
				xmlDoc = parser.parse(url);
				
			}
			
			//Element : XML������ ��Ҹ� ǥ���ϱ����� ���
			Element root = xmlDoc.getDocumentElement();
			System.out.println(root.getTagName());
			
			//ù��° book
			//Node : �� ��Ҹ� �а� ���� ���� ���
			Node book1 = root.getElementsByTagName("book").item(0);
			System.out.println(((Element)book1).getAttribute("kind"));
			
			Node title = book1.getFirstChild();
			Node title1 = title.getNextSibling();
			System.out.println(title1.getNodeName());
			
			Node title2 = title1.getFirstChild();
			System.out.println(title2.getNodeValue());
			
			
			String out = "";
			String str = "";
			
			NodeList books = root.getElementsByTagName("book");
			
			for(int i=0;i<books.getLength();i++) {
				
				Node book = books.item(i);
				str = book.getNodeName();
				
				out+="����: " + str;
				
				NamedNodeMap bookMap = book.getAttributes();
				str = bookMap.getNamedItem("kind").getNodeValue();
				
				out+=", kind: "+str;
				
				NodeList elementList = book.getChildNodes();
				
				for(int j = 0;j<elementList.getLength();j++) {
					Node e = elementList.item(j);
					
					str = "";
					
					if(e.getNodeType()==Node.ELEMENT_NODE) {
						str = ", "+e.getNodeName();
						out+=str+":";
						out +=e.getChildNodes().item(0).getNodeValue();
					}
				}
				out +="\n";
			}
			
			System.out.println(out);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
