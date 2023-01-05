package tests;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static io.restassured.RestAssured.baseURI;

public class SoapXMLRequest {
	@Test
	public void validateSoapXML() throws IOException {
		File file = new File("./SoapRequest/Add.xml");
		if(file.exists())
		System.out.println("  >> File Exists");
		FileInputStream FileInputStream = new FileInputStream("file");
		String requestBody = IOUtils.toString(FileInputStream, "UTF-8");
		
		baseURI = "http://dneonline.com/";
		given().
			contentType("text/xml").
			accept(ContentType.XML).
			body(requestBody).
		when().
			post("calculator.asmx").
		then().
			statusCode(200);
		
		
	}
}
