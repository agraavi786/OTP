package com.otpVerification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.otpVerification.Services.OtpVerificationService;

@RestController
public class OtpController {
	
	@Autowired
	OtpVerificationService ots;
	
	@PostMapping("/send_otp")
    public ResponseEntity<String> sendOtp(@RequestParam String phoneNumber) {
      
        ots.sendOtp(phoneNumber, ots.generateOtp(););
        return ResponseEntity.ok("OTP sent successfully");
    }
	
	

}
