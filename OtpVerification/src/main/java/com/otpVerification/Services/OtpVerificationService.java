package com.otpVerification.Services;

import java.util.Random;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
@Service
public class OtpVerificationService {
	
	 @Value("${twilio.account.sid}")
	    private String userSid;

	    @Value("${twilio.auth.token}")
	    private String authToken;

	    @Value("${twilio.phone.number}")
	    private String userPhoneNumber;
	    
	    private Random random = new Random();

	    
	    
	    public String generateOtp() {
	        return String.format("%06d", random.nextInt(1000000));
	    }
	    
	    public void sendOtp(String phoneNumber, String otp) {
	        Twilio.init(userSid, authToken);

	        // Send the OTP via Twilio SMS
	        Message message = Message.creator(
	                new PhoneNumber(phoneNumber),
	                new PhoneNumber(userPhoneNumber),
	                "Your OTP is: " + otp
	        ).create();
	    }
	}
	    
	    
	   
	    
	    

}
