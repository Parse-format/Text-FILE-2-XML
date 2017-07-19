package com.export.xml.sample;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "ReportLists")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({ Report.class })
public class ReportLists {
	@XmlElement
	private List<Report> reports;

	public List<Report> getReports() {
		return reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}

}
