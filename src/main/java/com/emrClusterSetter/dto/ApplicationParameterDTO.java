package com.emrClusterSetter.dto;

import com.emrClusterSetter.constants.ClusterConstants;

public class ApplicationParameterDTO {

	private String directoryName;
	private String udfJarName;
	private String udfJarLink;
	private String csvWith1KRecordsLink;
	private String csvWith10KRecordsLink;
	private String csvWith1KRecordsName;
	private String csvWith10KRecordsName;
	private String hqlFileLink;
	private String hqlFileName;

	public ApplicationParameterDTO() {
		this.directoryName = ClusterConstants.DIRECTORY;
		this.udfJarName = ClusterConstants.UDF;
		this.udfJarLink = ClusterConstants.UDF_LINK;
		this.csvWith1KRecordsLink = ClusterConstants.CSV_WITH_1K_RECORDS_LINK;
		this.csvWith1KRecordsName = ClusterConstants.CSV_WITH_1K_RECORDS_NAME;
		this.csvWith10KRecordsLink = ClusterConstants.CSV_WITH_10K_RECORDS_LINK;
		this.csvWith10KRecordsName = ClusterConstants.CSV_WITH_10K_RECORDS_NAME;
		this.hqlFileLink = ClusterConstants.HQL_FILE_LINK;
		this.hqlFileName = ClusterConstants.HQL_FILE_NAME;
	}

	public String getDirectoryName() {
		return directoryName;
	}

	public void setDirectoryName(String directoryName) {
		this.directoryName = directoryName;
	}

	public String getUdfJarName() {
		return udfJarName;
	}

	public void setUdfJarName(String udfJarName) {
		this.udfJarName = udfJarName;
	}

	public String getUdfJarLink() {
		return udfJarLink;
	}

	public void setUdfJarLink(String udfJarLink) {
		this.udfJarLink = udfJarLink;
	}

	public String getCsvWith1KRecordsLink() {
		return csvWith1KRecordsLink;
	}

	public void setCsvWith1KRecordsLink(String csvWith1KRecordsLink) {
		this.csvWith1KRecordsLink = csvWith1KRecordsLink;
	}

	public String getCsvWith10KRecordsLink() {
		return csvWith10KRecordsLink;
	}

	public void setCsvWith10KRecordsLink(String csvWith10KRecordsLink) {
		this.csvWith10KRecordsLink = csvWith10KRecordsLink;
	}

	public String getCsvWith1KRecordsName() {
		return csvWith1KRecordsName;
	}

	public void setCsvWith1KRecordsName(String csvWith1KRecordsName) {
		this.csvWith1KRecordsName = csvWith1KRecordsName;
	}

	public String getCsvWith10KRecordsName() {
		return csvWith10KRecordsName;
	}

	public void setCsvWith10KRecordsName(String csvWith10KRecordsName) {
		this.csvWith10KRecordsName = csvWith10KRecordsName;
	}

	public String getHqlFileLink() {
		return hqlFileLink;
	}

	public void setHqlFileLink(String hqlFileLink) {
		this.hqlFileLink = hqlFileLink;
	}

	public String getHqlFileName() {
		return hqlFileName;
	}

	public void setHqlFileName(String hqlFileName) {
		this.hqlFileName = hqlFileName;
	}

	private void setDirectoryName(String[] args) {
		this.directoryName = args[0];
	}
	
	private void setUDFJarDetails(String[] args) {
		this.udfJarName = args[1];
		this.udfJarLink = args[2];	
	}
	
	private void setCSVDetails(String[] args) {
		this.csvWith1KRecordsLink = args[3];
		this.csvWith1KRecordsName = args[4];
		this.csvWith10KRecordsLink = args[5];
		this.csvWith10KRecordsName = args[6];
	}
	
	private void setHiveDetails(String[] args) {
		this.hqlFileLink = args[7];
		this.hqlFileName = args[8];	
		
	}
	
	public void setUpApplicationParameters(String[] args) {
		switch (args.length) {
		case 1:
			setDirectoryName(args);
			break;
		case 3:
			setDirectoryName(args);
			setUDFJarDetails(args);
			break;
		case 7:
			setDirectoryName(args);
			setUDFJarDetails(args);
			setCSVDetails(args);			
			break;
		case 9:
			setDirectoryName(args);
			setUDFJarDetails(args);
			setCSVDetails(args);
			setHiveDetails(args);
			break;
		default:
			return;
		}
	}

	@Override
	public String toString() {
		return "ApplicationParameterDTO [directoryName=" + directoryName + ", udfJarName=" + udfJarName
				+ ", udfJarLink=" + udfJarLink + ", csvWith1KRecordsLink=" + csvWith1KRecordsLink
				+ ", csvWith10KRecordsLink=" + csvWith10KRecordsLink + ", csvWith1KRecordsName=" + csvWith1KRecordsName
				+ ", csvWith10KRecordsName=" + csvWith10KRecordsName + ", hqlFileLink=" + hqlFileLink + ", hqlFileName="
				+ hqlFileName + "]";
	}
	
}
