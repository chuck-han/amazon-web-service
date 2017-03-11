package com.mightyjava.aws.service.impl;

import java.util.List;

import com.amazonaws.regions.RegionUtils;
import com.amazonaws.services.ec2.model.Region;
import com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancing;
import com.amazonaws.services.elasticloadbalancing.model.DescribeLoadBalancersResult;
import com.amazonaws.services.elasticloadbalancing.model.LoadBalancerDescription;
import com.mightyjava.aws.service.AWSService;
import com.mightyjava.aws.utils.ServiceClientUtils;

public class ELBService extends AWSService {
	private com.amazonaws.regions.Region regionName = null;
	private AmazonElasticLoadBalancing amazonELB = null;
	 
	public ELBService() {
		amazonELB = ServiceClientUtils.createELBClient();
	}
	
	public void findLoadBalancers() {
		System.out.println("ELBService : findLoadBalancers");
		if (!regions.isEmpty()) {
			for (Region region : regions) {
				regionName = RegionUtils.getRegion(region.getRegionName());
				if (regionName != null) {
					amazonELB.setRegion(regionName);
				}
				DescribeLoadBalancersResult balancersResult = amazonELB.describeLoadBalancers();
				List<LoadBalancerDescription> balancerDescriptions = balancersResult.getLoadBalancerDescriptions();
				if(!balancerDescriptions.isEmpty()) {
					for (LoadBalancerDescription loadBalancerDescription : balancerDescriptions) {
						System.out.println(regionName+" : "+loadBalancerDescription);
					}
				}
			}
		}
	}
}
