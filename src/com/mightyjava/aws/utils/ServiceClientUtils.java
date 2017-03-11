package com.mightyjava.aws.utils;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.cloudformation.AmazonCloudFormation;
import com.amazonaws.services.cloudformation.AmazonCloudFormationClient;
import com.amazonaws.services.cloudwatch.AmazonCloudWatch;
import com.amazonaws.services.cloudwatch.AmazonCloudWatchClient;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancing;
import com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingClient;
import com.amazonaws.services.rds.AmazonRDS;
import com.amazonaws.services.rds.AmazonRDSClient;
import com.amazonaws.services.redshift.AmazonRedshift;
import com.amazonaws.services.redshift.AmazonRedshiftClient;

public class ServiceClientUtils {
	private static BasicAWSCredentials awsCredentials = null;
	
	static {
		awsCredentials = AWSUtils.validateKeys();
	}
	
	public static AmazonCloudWatch createCloudWatchClient() {
		return new AmazonCloudWatchClient(awsCredentials);
	}
	
	public static AmazonCloudFormation createCloudFormationClient() {
		return new AmazonCloudFormationClient(awsCredentials);
	}
	
	public static AmazonRedshift createRedshiftClient() {
		return new AmazonRedshiftClient(awsCredentials);
	}
	
	public static AmazonElasticLoadBalancing createELBClient() {
		return new AmazonElasticLoadBalancingClient(awsCredentials);
	}
	
	public static AmazonRDS createRDSClient() {
		return new AmazonRDSClient(awsCredentials);
	}
	
	public static AmazonEC2 createEC2Client() {
		return new AmazonEC2Client(awsCredentials);
	}
}
