package com.parser.sax.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.parser.sax.handler.SAXParserHandler;

public class CustomSAXParser {

	public void parseXML(String filePath) throws ParserConfigurationException, SAXException, FileNotFoundException, IOException {
		
		SAXParserFactory saxParserFactory = null;
		SAXParser saxParser = null;
		
		saxParserFactory = SAXParserFactory.newInstance();
		saxParser = saxParserFactory.newSAXParser();
		saxParser.parse(new FileInputStream(new File(filePath)), new SAXParserHandler());
	}
}
