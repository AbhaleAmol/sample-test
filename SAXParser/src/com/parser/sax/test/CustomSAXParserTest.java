package com.parser.sax.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.parser.sax.parser.CustomSAXParser;

public class CustomSAXParserTest {

	private static final String XML_FILE_PATH = "/media/amol/Ubuntu/JAVA Master/Web Services/SAXParser/resource/account.xml";
	
	public static void main(String[] args) throws FileNotFoundException, ParserConfigurationException, SAXException, IOException {
	
		CustomSAXParser customSAXParser = null;
		
		customSAXParser = new CustomSAXParser();
		customSAXParser.parseXML(XML_FILE_PATH);
	}
}
