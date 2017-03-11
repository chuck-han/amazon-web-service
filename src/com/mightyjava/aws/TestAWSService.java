package com.mightyjava.aws;

import com.mightyjava.aws.service.impl.CloudFormationService;
import com.mightyjava.aws.service.impl.CloudWatchService;
import com.mightyjava.aws.service.impl.EC2Service;
import com.mightyjava.aws.service.impl.ELBService;
import com.mightyjava.aws.service.impl.RDSService;
import com.mightyjava.aws.service.impl.RedShiftService;

public class TestAWSService {
	public static void main(String[] args) {
		CloudWatchService cloudWatchService = new CloudWatchService();
		cloudWatchService.findMetrics();
		
		/*CloudFormationService formationService = new CloudFormationService();
		formationService.findStacks();*/
		
		/*RedShiftService redShiftService = new RedShiftService();
		redShiftService.findReservedNodes();*/
		
		/*ELBService elbService = new ELBService();
		elbService.findLoadBalancers();*/
		
		/*RDSService rdsService = new RDSService();
		rdsService.findDBSnapshots();
		rdsService.findReservedDBInstances();
		rdsService.findDBInstances();*/
		
		/*EC2Service ec2Service = new EC2Service();
		ec2Service.findSnapshots();
		ec2Service.findAMIs();
		ec2Service.findReservedInstances();
		ec2Service.findInstances();
		ec2Service.findEBSVolumes();
		ec2Service.findElasticIps();*/
	}
}
