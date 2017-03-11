package com.mightyjava.aws.service.impl;

import java.util.List;

import com.amazonaws.regions.RegionUtils;
import com.amazonaws.services.ec2.model.Address;
import com.amazonaws.services.ec2.model.DescribeAddressesResult;
import com.amazonaws.services.ec2.model.DescribeImagesResult;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.DescribeReservedInstancesResult;
import com.amazonaws.services.ec2.model.DescribeSnapshotsResult;
import com.amazonaws.services.ec2.model.DescribeVolumesResult;
import com.amazonaws.services.ec2.model.Image;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.Region;
import com.amazonaws.services.ec2.model.Reservation;
import com.amazonaws.services.ec2.model.ReservedInstances;
import com.amazonaws.services.ec2.model.Snapshot;
import com.amazonaws.services.ec2.model.Volume;
import com.mightyjava.aws.service.AWSService;

public class EC2Service extends AWSService {
	com.amazonaws.regions.Region regionName = null;
	
	public void findSnapshots() {
		System.out.println("EC2Service : findSnapshots");
		if (!regions.isEmpty()) {
			for (Region region : regions) {
				regionName = RegionUtils.getRegion(region.getRegionName());
				if (regionName != null) {
					amazonEC2.setRegion(regionName);
				}
				DescribeSnapshotsResult snapshotsResult = amazonEC2.describeSnapshots();
				List<Snapshot> snapshots = snapshotsResult.getSnapshots();
				if(!snapshots.isEmpty()) {
					for (Snapshot snapshot : snapshots) {
						System.out.println(regionName+" : "+snapshot);
					}
				}
			}
		}
	}
	
	public void findAMIs() {
		System.out.println("EC2Service : findAMIs");
		if (!regions.isEmpty()) {
			for (Region region : regions) {
				regionName = RegionUtils.getRegion(region.getRegionName());
				if (regionName != null) {
					amazonEC2.setRegion(regionName);
				}
				DescribeImagesResult imagesResult = amazonEC2.describeImages();
				List<Image> images = imagesResult.getImages();
				if(!images.isEmpty()) {
					for (Image image : images) {
						System.out.println(regionName+" : "+image); 
					}
				}
			}
		}
	}
	
	public void findReservedInstances() {
		System.out.println("EC2Service : findReservedInstances");
		if (!regions.isEmpty()) {
			for (Region region : regions) {
				regionName = RegionUtils.getRegion(region.getRegionName());
				if (regionName != null) {
					amazonEC2.setRegion(regionName);
				}
				DescribeReservedInstancesResult instancesResult = amazonEC2.describeReservedInstances();
				List<ReservedInstances> instances = instancesResult.getReservedInstances();
				if(!instances.isEmpty()) {
					for (ReservedInstances reservedInstances : instances) { 
						System.out.println(regionName+" : "+reservedInstances);
					}
				}
			}
		}
	}

	public void findInstances() {
		System.out.println("EC2Service : findInstances");
		if (!regions.isEmpty()) {
			for (Region region : regions) {
				regionName = RegionUtils.getRegion(region.getRegionName());
				if (regionName != null) {
					amazonEC2.setRegion(regionName);
				}
				DescribeInstancesResult instancesResult = amazonEC2.describeInstances();
				List<Reservation> reservations = instancesResult.getReservations();
				if (!reservations.isEmpty()) {
					for (Reservation reservation : reservations) {
						List<Instance> instances = reservation.getInstances();
						if (!instances.isEmpty()) {
							for (Instance instance : instances) {
								System.out.println(regionName + " : " + instance);
							}
						}
					}
				}
			}
		}
	}

	public void findEBSVolumes() {
		System.out.println("EC2Service : findEBSVolumes");
		if (!regions.isEmpty()) {
			for (Region region : regions) {
				regionName = RegionUtils.getRegion(region.getRegionName());
				if (regionName != null) {
					amazonEC2.setRegion(regionName);
				}
				DescribeVolumesResult volumesResult = amazonEC2.describeVolumes();
				List<Volume> volumes = volumesResult.getVolumes();
				if (!volumes.isEmpty()) {
					for (Volume volume : volumes) {
						System.out.println(regionName + " : " + volume);
					}
				}
			}
		}
	}

	public void findElasticIps() {
		System.out.println("EC2Service : findElasticIps");
		if (!regions.isEmpty()) {
			for (Region region : regions) {
				regionName = RegionUtils.getRegion(region.getRegionName());
				if (regionName != null) {
					amazonEC2.setRegion(regionName);
				}
				DescribeAddressesResult addressesResult = amazonEC2.describeAddresses();
				List<Address> addresses = addressesResult.getAddresses();
				if (!addresses.isEmpty()) {
					for (Address address : addresses) {
						System.out.println(regionName + ":" + address);
					}
				}
			}
		}
	}
}
