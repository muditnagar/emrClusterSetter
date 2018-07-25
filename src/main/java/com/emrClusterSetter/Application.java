package com.emrClusterSetter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.emrClusterSetter.dto.ApplicationParameterDTO;
import com.emrClusterSetter.utility.ProcessUtility;

public class Application {
	static ProcessUtility processUtility = new ProcessUtility();
	static ApplicationParameterDTO applicationParameterDTO = new ApplicationParameterDTO();
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		log.info("Fetching all realting files into EMR Cluster");
		if (null != args && args.length > 0) {
			log.info("User provided arguments exists, setting up parameters.");
			applicationParameterDTO.setUpApplicationParameters(args);
		}
		processUtility.getFileFromLink(applicationParameterDTO.getUdfJarLink(), applicationParameterDTO.getUdfJarName());
		processUtility.createDirectory(applicationParameterDTO.getDirectoryName());
		processUtility.putUDFJarIntoHadoopFileSystem(applicationParameterDTO.getUdfJarName(),applicationParameterDTO.getDirectoryName());
		processUtility.getFileFromLink(applicationParameterDTO.getCsvWith1KRecordsLink(),applicationParameterDTO.getCsvWith1KRecordsName());
		processUtility.getFileFromLink(applicationParameterDTO.getCsvWith10KRecordsLink(),applicationParameterDTO.getCsvWith10KRecordsName());
		log.info("Files successfullt fetched.");
		log.info("Setting up hive tables into EMR Cluster");
		processUtility.getFileFromLink(applicationParameterDTO.getHqlFileLink(),applicationParameterDTO.getHqlFileName());
		processUtility.runHqlScriptFile(applicationParameterDTO.getHqlFileName());
		log.info("Tables created successfully.");
		log.info("EMR Cluster is ready to use.");
	}
	
}
