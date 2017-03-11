package com.mightyjava.aws.service.impl;

import java.util.List;

import com.amazonaws.regions.RegionUtils;
import com.amazonaws.services.ec2.model.Region;
import com.amazonaws.services.rds.AmazonRDS;
import com.amazonaws.services.rds.model.DBInstance;
import com.amazonaws.services.rds.model.DBSnapshot;
import com.amazonaws.services.rds.model.DescribeDBInstancesResult;
import com.amazonaws.services.rds.model.DescribeDBSnapshotsResult;
import com.amazonaws.services.rds.model.DescribeReservedDBInstancesResult;
import com.amazonaws.services.rds.model.ReservedDBInstance;
import com.mightyjava.aws.service.AWSService;
import com.mightyjava.aws.utils.ServiceClientUtils;

public class RDSService extends AWSService {
	private AmazonRDS amazonRDS = null;
	private com.amazonaws.regions.Region regionName = null;

	public RDSService() {
		this.amazonRDS = ServiceClientUtils.createRDSClient();
	}
	
	public void findDBSnapshots() {
		System.out.println("RDSService : findDBSnapshots");
		if (!regions.isEmpty()) {
			for (Region region : regions) {
				regionName = RegionUtils.getRegion(region.getRegionName());
				if (regionName != null) {
					amazonRDS.setRegion(regionName);
				}
				DescribeDBSnapshotsResult snapshotsResult = amazonRDS.describeDBSnapshots();
				List<DBSnapshot> dbSnapshots = snapshotsResult.getDBSnapshots();
				if(!dbSnapshots.isEmpty()) {
					for (DBSnapshot dbSnapshot : dbSnapshots) {
						System.out.println(regionName+" : "+dbSnapshot);
					}
				}
			}
		}
	}
	
	public void findReservedDBInstances() {
		System.out.println("RDSService : findReservedDBInstances");
		if (!regions.isEmpty()) {
			for (Region region : regions) {
				regionName = RegionUtils.getRegion(region.getRegionName());
				if (regionName != null) {
					amazonRDS.setRegion(regionName);
				}
				DescribeReservedDBInstancesResult dbInstancesResult = amazonRDS.describeReservedDBInstances();
				List<ReservedDBInstance> dbInstances = dbInstancesResult.getReservedDBInstances();
				if(!dbInstances.isEmpty()) {
					for (ReservedDBInstance reservedDBInstance : dbInstances) {
						System.out.println(regionName+" : "+reservedDBInstance); 
					}
				}
			}
		}
	}

	public void findDBInstances() {
		System.out.println("RDSService : findDBInstances");
		if (!regions.isEmpty()) {
			for (Region region : regions) {
				regionName = RegionUtils.getRegion(region.getRegionName());
				if (regionName != null) {
					amazonRDS.setRegion(regionName);
				}
				DescribeDBInstancesResult instancesResult = amazonRDS.describeDBInstances();
				List<DBInstance> dbInstances = instancesResult.getDBInstances();
				if (!dbInstances.isEmpty()) {
					for (DBInstance dbInstance : dbInstances) {
						System.out.println(regionName + " : " + dbInstance);
					}
				}
			}
		}
	}
}
