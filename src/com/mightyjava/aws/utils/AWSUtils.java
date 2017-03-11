package com.mightyjava.aws.utils;

import com.amazonaws.auth.BasicAWSCredentials;
import com.mightyjava.aws.constants.Constants;

public class AWSUtils {
	public static BasicAWSCredentials validateKeys() {
		return new BasicAWSCredentials(Constants.ACCESS_KEY, Constants.SECRET_KEY);
	}
}
