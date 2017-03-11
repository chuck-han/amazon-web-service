package com.mightyjava.aws.service.impl;

import java.util.List;

import com.amazonaws.regions.RegionUtils;
import com.amazonaws.services.ec2.model.Region;
import com.amazonaws.services.redshift.AmazonRedshift;
import com.amazonaws.services.redshift.model.DescribeReservedNodesResult;
import com.amazonaws.services.redshift.model.ReservedNode;
import com.mightyjava.aws.service.AWSService;
import com.mightyjava.aws.utils.ServiceClientUtils;

public class RedShiftService extends AWSService {
	private com.amazonaws.regions.Region regionName = null;
	private AmazonRedshift amazonRedshift = null;

	public RedShiftService() {
		this.amazonRedshift = ServiceClientUtils.createRedshiftClient();
	}

	public void findReservedNodes() {
		System.out.println("RedShiftService : findReservedNodes");
		if (!regions.isEmpty()) {
			for (Region region : regions) {
				regionName = RegionUtils.getRegion(region.getRegionName());
				if (regionName != null) {
					amazonRedshift.setRegion(regionName);
				}
				DescribeReservedNodesResult nodesResult = amazonRedshift.describeReservedNodes();
				List<ReservedNode> nodes = nodesResult.getReservedNodes();
				if (!nodes.isEmpty()) {
					for (ReservedNode reservedNode : nodes) {
						System.out.println(regionName + " : " + reservedNode);
					}
				}
			}
		}
	}
}
