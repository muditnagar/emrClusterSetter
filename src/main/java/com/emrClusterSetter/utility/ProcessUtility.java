package com.emrClusterSetter.utility;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.emrClusterSetter.constants.ClusterConstants;

public class ProcessUtility {

	private Process process = null;
	private List<String> commands = null;
	private ProcessBuilder processBuilder = null;
	
	private static final Logger log = LoggerFactory.getLogger(ProcessUtility.class);

	public void getFileFromLink(String fileLink, String fileName) {
		log.info("Getting File : {} from Link : {}",fileName,fileLink);
		cleanUpExistingFile(fileName);
		// Command : wget <fileLink>
		commands = new ArrayList<String>();
		commands.add(ClusterConstants.WGET);
		commands.add(fileLink);
		startProcess(commands);
	}

	public void createDirectory(String directoryName) {
		log.info("Creating directory : {}",directoryName);
		cleanUpExistingDirectory(directoryName);
		// Command : hadoop fs -mkdir -p <directoryName>
		commands = new ArrayList<String>();
		commands.add(ClusterConstants.HADOOP);
		commands.add(ClusterConstants.FILE_SYSTEM);
		commands.add(ClusterConstants.HYPHEN + ClusterConstants.CREATE_DIRECTORY);
		commands.add(ClusterConstants.HYPHEN + ClusterConstants.IF_NOT_EXIST);
		commands.add(directoryName);
		startProcess(commands);
	}

	public void putUDFJarIntoHadoopFileSystem(String udfJarName, String directoryName) {
		log.info("Putting UDF : {} into Hadoop directory : {}",udfJarName,directoryName);
		// Command : hadoop fs -put <udfJarName> <directoryName>
		commands = new ArrayList<String>();
		commands.add(ClusterConstants.HADOOP);
		commands.add(ClusterConstants.FILE_SYSTEM);
		commands.add(ClusterConstants.HYPHEN + ClusterConstants.PUT);
		commands.add(udfJarName);
		commands.add(directoryName);
		startProcess(commands);
	}

	public void runHqlScriptFile(String hqlFileName) {
		log.info("Running hive script : {}", hqlFileName);
		// Command : hive -f <hqlFileName>
		commands = new ArrayList<String>();
		commands.add(ClusterConstants.HIVE);
		commands.add(ClusterConstants.HYPHEN+ClusterConstants.FILE);
		commands.add(hqlFileName);
		startProcess(commands);
	}

	private void cleanUpExistingFile(String fileName) {
		log.info("Deleting up file : {} if existed previously.",fileName);
		// Command : rm -f -r <fileName>
		commands = new ArrayList<String>();
		commands.add(ClusterConstants.REMOVE);
		commands.add(ClusterConstants.HYPHEN + ClusterConstants.FORCED);
		commands.add(ClusterConstants.HYPHEN + ClusterConstants.RECURSIVE);
		commands.add(fileName);
		startProcess(commands);
	}

	private void cleanUpExistingDirectory(String directoryName) {
		log.info("Deleting up directory : {} if existed previously.",directoryName);
		// Command : hadoop fs -rm -f -r <directoryName>
		commands = new ArrayList<String>();
		commands.add(ClusterConstants.HADOOP);
		commands.add(ClusterConstants.FILE_SYSTEM);
		commands.add(ClusterConstants.HYPHEN + ClusterConstants.REMOVE);
		commands.add(ClusterConstants.HYPHEN + ClusterConstants.FORCED);
		commands.add(ClusterConstants.HYPHEN + ClusterConstants.RECURSIVE);
		commands.add(directoryName);
		startProcess(commands);
	}

	private void startProcess(List<String> commands) {
		processBuilder = new ProcessBuilder(commands);
		try {
			process = processBuilder.start();
			process.waitFor();
		} catch (Exception e) {
			System.out.println("An Exception occured while processting : ");
			e.printStackTrace();
		}
	}
	
}