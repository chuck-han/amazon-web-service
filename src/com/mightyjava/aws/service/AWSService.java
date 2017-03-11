package com.mightyjava.aws.service;

import java.util.List;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.DescribeRegionsResult;
import com.amazonaws.services.ec2.model.Region;
import com.mightyjava.aws.utils.ServiceClientUtils;

public class AWSService {
	protected AmazonEC2 amazonEC2 = null;
	protected List<Region> regions = null;
	protected DescribeRegionsResult regionsResult = null;

	public AWSService() {
		this.amazonEC2 = ServiceClientUtils.createEC2Client();
		this.regionsResult = amazonEC2.describeRegions();
		this.regions = regionsResult.getRegions();
	}
}
