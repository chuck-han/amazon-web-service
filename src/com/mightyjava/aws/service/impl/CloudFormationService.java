package com.mightyjava.aws.service.impl;

import java.util.List;

import com.amazonaws.regions.RegionUtils;
import com.amazonaws.services.cloudformation.AmazonCloudFormation;
import com.amazonaws.services.cloudformation.model.DescribeStacksResult;
import com.amazonaws.services.cloudformation.model.Stack;
import com.amazonaws.services.ec2.model.Region;
import com.mightyjava.aws.service.AWSService;
import com.mightyjava.aws.utils.ServiceClientUtils;

public class CloudFormationService extends AWSService {
	private com.amazonaws.regions.Region regionName = null;
	private AmazonCloudFormation amazonCloudFormation = null;

	public CloudFormationService() {
		amazonCloudFormation = ServiceClientUtils.createCloudFormationClient();
	}

	public void findStacks() {
		System.out.println("CloudFormationService : findStacks");
		if (!regions.isEmpty()) {
			for (Region region : regions) {
				regionName = RegionUtils.getRegion(region.getRegionName());
				if (regionName != null) {
					amazonCloudFormation.setRegion(regionName);
				}
				DescribeStacksResult stacksResult = amazonCloudFormation.describeStacks();
				List<Stack> stacks = stacksResult.getStacks();
				if (!stacks.isEmpty()) {
					for (Stack stack : stacks) {
						System.out.println(regionName + " : " + stack);
					}
				}
			}
		}
	}
}
