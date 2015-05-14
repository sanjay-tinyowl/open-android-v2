/*
   Copyright 2014 Citrus Payment Solutions Pvt. Ltd.
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
     http://www.apache.org/licenses/LICENSE-2.0
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package com.citrus.sdk;

/**
 * Created by salil on 24/4/15.
 */
public interface Constants {
    String INTENT_EXTRA_RETURN_URL = "INTENT_EXTRA_RETURN_URL";
    String INTENT_EXTRA_TRANSACTION_RESPONSE = "INTENT_EXTRA_TRANSACTION_RESPONSE";
    String INTENT_EXTRA_PAYMENT_PARAMS = "INTENT_EXTRA_PAYMENT_PARAMS";
    int REQUEST_CODE_PAYMENT = 10000;
    String JS_INTERFACE_NAME = "CitrusResponse";
    String CITRUS_PREPAID_COOKIE = "prepaiduser-payauth=''";
    String LOGOUT_SUCCESS_MESSAGE = "User Logged Out Successfully.";
    String LOGOUT_FAIL_MESSAGE = "Failed to LogOut!!!";
}

interface ResponseMessages {
    String ERROR_MESSAGE_BLANK_EMAIL_ID_MOBILE_NO = "Please enter emaild id or the mobile no of your friend to send the money";
    String ERROR_MESSAGE_BLANK_AMOUNT = "Please enter the amount to be sent.";
    String ERROR_MESSAGE_USER_NOT_LOGGED_IN = "ERROR: User not logged in. Please login the user before doing this.";
    String ERROR_MESSAGE_INVALID_JSON = "ERROR: Invlid json received.";
    String ERROR_MESSAGE_FAILED_MERCHANT_PAYMENT_OPTIONS = "ERROR: Unable to fetch merchant payment options";
    String ERROR_MESSAGE_BLANK_CONFIG_PARAMS = "Please make sure SignIn Id, SignIn Secret, SignUp Id, SignUp Secret & Vanity";
    String ERROR_MESSAGE_INVALID_MOBILE_NO = "Invalid Mobile No";
}