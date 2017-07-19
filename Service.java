package com.export.xml.sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Service {

	@SuppressWarnings("resource")
	public static List<Report> getReports() throws IOException {
		List<Report> reports = new ArrayList<>();
		Report report = null;
		BufferedReader reader = new BufferedReader(new FileReader(new File(
				"input.txt")));
		reader.readLine(); // this will read the first line
		String line = null;
		while ((line = reader.readLine()) != null) {
			report = new Report(Util.split(line)[0], Util.split(line)[1],
					Util.split(line)[2], Util.split(line)[3],
					Util.split(line)[4], Util.split(line)[5],
					Double.parseDouble(Util.split(line)[6]),
					Double.parseDouble(Util.split(line)[7]),
					Util.split(line)[8], Util.split(line)[9],
					Util.split(line)[10], Util.split(line)[11],
					Util.split(line)[12], Util.split(line)[13],
					Util.split(line)[14], Util.split(line)[15],
					Util.split(line)[16], Util.split(line)[17],
					Util.split(line)[18], Util.split(line)[19],
					Util.split(line)[20], Util.split(line)[21],
					Util.split(line)[22], Util.split(line)[23],
					Util.split(line)[24], Util.split(line)[25],
					Util.split(line)[26], Util.split(line)[27],
					Util.split(line)[28], Util.split(line)[29],
					Util.split(line)[30], Util.split(line)[31],
					Util.split(line)[32], Util.split(line)[33],
					Util.split(line)[34], Util.split(line)[35],
					Util.split(line)[36], Util.split(line)[37],
					Util.split(line)[38], Util.split(line)[39],
					Util.split(line)[40], Util.split(line)[41],
					Util.split(line)[42], Util.split(line)[43],
					Util.split(line)[44], Util.split(line)[45],
					Util.split(line)[46], Util.split(line)[47],
					Util.split(line)[48], Util.split(line)[49], null);
			reports.add(report);
		}
		return reports;
	}

	public static void convertJavaToXML(String FileNameToBeGenerate)
			throws IOException {
		ReportLists reportLists = new ReportLists();
		reportLists.setReports(getReports());
		try {
			JAXBContext context = JAXBContext.newInstance(ReportLists.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(reportLists, new File(FileNameToBeGenerate));
			System.out.println("Converting..........");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			convertJavaToXML("report.xml");
		} catch (IOException e) {
			System.out.println("Error :" + e.getLocalizedMessage());
		}
	}
}
