package com.parser.sax.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserHandler extends DefaultHandler {

	private static String currentElemnt;
	
	@Override
	public void startDocument() throws SAXException {
		//System.out.println("Started Parsing Document...");
	}

	@Override
	public void endDocument() throws SAXException {
		//System.out.println("Finished Parsing Document...");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//System.out.print("\n" + qName.toUpperCase() + " ==> ");
		currentElemnt = qName;
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		//System.out.print("</" + qName + "> \n");
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		//System.out.print(new String(ch, start, length));
		if(new String(ch, start, length) != null && (new String(ch, start, length)).replaceAll("\\s+","").length() > 0) {
			System.out.println(currentElemnt + " ==> " + new String(ch, start, length));
		}
	}

}
