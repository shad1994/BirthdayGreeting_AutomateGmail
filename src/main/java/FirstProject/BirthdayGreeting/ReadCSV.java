package FirstProject.BirthdayGreeting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class ReadCSV {
	public static void main(String[] args) throws IOException {

	List clist=readfile();
	
	for(int i=0;i<clist.size();i++)
	{
		System.out.println(clist.get(i));
		
	}
		
		

	}

	public static List readfile() {
		String csvFile = "resources/data.csv";
		BufferedReader br=null;
		List contactList = new ArrayList();
	
		String line="";
		
		int i=0;
		
		String cvsSplitBy = ",";

		try {

			br = new BufferedReader(new FileReader(csvFile));
			line = br.readLine();
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				// use comma as separator
				String[] singleContact = line.split(cvsSplitBy);

				//System.out.println("Name= " + singleContact[0] + " , Email= " + singleContact[1]);
				//contactList.add(new BasicNameValuePair("name", singleContact[0]));
				contactList.add(singleContact[1]);
				
				

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return contactList;
	}


}
