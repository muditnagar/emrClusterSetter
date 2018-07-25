package com.emrClusterSetter.constants;

public interface ClusterConstants {
	String WGET = "wget";
	String UDF_LINK = "https://s3.amazonaws.com/datametica/Pelican/Pelican-0.5.0.0/hive-udf-0.0.1-SNAPSHOT.jar";
	String CSV_WITH_10K_RECORDS_LINK = "https://s3.amazonaws.com/datametica/Pelican/Pelican-0.5.0.0/s1t2_10k.csv";
	String CSV_WITH_1K_RECORDS_LINK = "https://s3.amazonaws.com/datametica/Pelican/Pelican-0.5.0.0/s1t1_1k.csv";
	String CSV_WITH_10K_RECORDS_NAME = "s1t2_10k.csv";
	String CSV_WITH_1K_RECORDS_NAME = "s1t1_1k.csv";
	String REMOVE = "rm";
	String FORCED = "f";
	String RECURSIVE = "r";
	String UDF = "hive-udf-0.0.1-SNAPSHOT.jar";
	String HYPHEN = "-";
	String HADOOP = "hadoop";
	String FILE_SYSTEM = "fs";
	String FOLDER = "emrClusterSetter";
	String CREATE_DIRECTORY = "mkdir";
	String IF_NOT_EXIST = "p";
	String DIRECTORY = "emrClusterSetter";
	String PUT = "put";
	String FILE = "f";
	String HIVE = "hive";
	String HQL_FILE_LINK = "https://s3.amazonaws.com/datametica/Pelican/Pelican-0.5.0.0/hiveTableCreator.hql";
	String HQL_FILE_NAME = "hiveTableCreator.hql";
}
