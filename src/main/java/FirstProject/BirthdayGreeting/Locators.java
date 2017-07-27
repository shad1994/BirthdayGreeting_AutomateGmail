package FirstProject.BirthdayGreeting;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;

public class Locators {

	public static void main(String args[]) throws IOException {
		findLocator("email");
		// findLocator("nextbutton");
	}

	static String line;

	public static By findLocator(String key) throws IOException {
		FileReader readFile = new FileReader("resources/data.spec");

		BufferedReader readbuffer = new BufferedReader(readFile);

		while ((line = readbuffer.readLine()) != null) {

			if (line.contains(key)) {
				String[] part = line.split("\\s+");
				//System.out.println(part.length);
			
				/*for (int i = 0; i < part.length; i++) {
				
					System.out.print(part[i]);
				
				}*/
				if (part[1].equals("id")) {
					//System.out.println("By.id("+part[2]+")");
					//System.out.println(By.id(part[2]));
					return By.id(part[2]);
					
				
				} else if (part[1].equals("classname")) {
					//System.out.println(part[2]);
					return By.className(part[2]);
				} else if (part[1].equals("css")) {
					//System.out.println(part[2]);
					return By.cssSelector(part[2]);
				} else if (part[1].equals("xpath")) {
					//System.out.println(part[2]);
					return By.xpath(part[2]);
				}
			}

		}
		return null;

	}

}
