package com.mightyjava.aws.service.impl;

import java.util.List;

import com.amazonaws.regions.RegionUtils;
import com.amazonaws.services.cloudwatch.AmazonCloudWatch;
import com.amazonaws.services.cloudwatch.model.ListMetricsResult;
import com.amazonaws.services.cloudwatch.model.Metric;
import com.amazonaws.services.ec2.model.Region;
import com.mightyjava.aws.service.AWSService;
import com.mightyjava.aws.utils.ServiceClientUtils;

public class CloudWatchService extends AWSService {
	private com.amazonaws.regions.Region regionName = null;
	private AmazonCloudWatch amazonCloudWatch = null;
	
	public CloudWatchService() {
		amazonCloudWatch = ServiceClientUtils.createCloudWatchClient();
	}
	
	public void findMetrics() {
		System.out.println("CloudWatchService : findMetrics");
		if (!regions.isEmpty()) {
			for (Region region : regions) {
				regionName = RegionUtils.getRegion(region.getRegionName());
				if (regionName != null) {
					amazonCloudWatch.setRegion(regionName);
				}
				ListMetricsResult listMetricsResult = amazonCloudWatch.listMetrics();
				List<Metric> metrics = listMetricsResult.getMetrics();
				if(!metrics.isEmpty()) {
					for (Metric metric : metrics) {
						System.out.println(regionName+" : "+metric);
					} 
				}
			}
		}
	}
}
