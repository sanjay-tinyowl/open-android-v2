package com.citrus.retrofit;

import com.citrus.pojo.AccessTokenPOJO;
import com.citrus.pojo.BillGeneratorPOJO;
import com.citrus.pojo.BindPOJO;
import com.citrus.pojo.PaymentOptionsPOJO;
import com.citrus.pojo.StructResponsePOJO;
import com.citrus.sdk.classes.Amount;
import com.citrus.sdk.payment.PaymentBill;
import com.citrus.sdk.response.CitrusResponse;
import com.citrus.sdk.response.PaymentResponse;
import com.google.gson.JsonElement;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.mime.TypedString;

/**
 * Created by MANGESH KADAM on 5/7/2015.
 */
public interface API {


    @FormUrlEncoded
    @POST("/oauth/token")
    void getSignUpToken(@Field("client_id") String client_ID, @Field("client_secret") String client_Secret, @Field("grant_type") String grantType, Callback<AccessTokenPOJO> accessTokenPOJOCallback);


    @FormUrlEncoded
    @POST("/service/v2/identity/bind")
    void getBindResponse(@Header("Authorization") String header, @Field("email") String email, @Field("mobile") String mobile, Callback<BindPOJO> bindPOJOCallback);

    //sign in
    @FormUrlEncoded
    @POST("/oauth/token")
    void getSignInToken(@Field("client_id") String client_ID, @Field("client_secret") String client_Secret, @Field("username") String username, @Field("grant_type") String grantType, Callback<AccessTokenPOJO> accessTokenPOJOCallback);

    @FormUrlEncoded
    @POST("/oauth/token")
    void getSignInWithPasswordResponse(@Field("client_id") String client_ID, @Field("client_secret") String client_Secret, @Field("username") String username, @Field("password") String password, @Field("grant_type") String grantType, Callback<AccessTokenPOJO> accessTokenPOJOCallback);

    //return url from citrus
    @Headers("Content-Type: application/json")
    @POST("/service/moto/authorize/struct/payment")
    void getPaymentResponse(@Body TypedString body, Callback<StructResponsePOJO> structResponseCallback);

    //payment options of merchant
    @FormUrlEncoded
    @POST("/service/v1/merchant/pgsetting")
    void getPaymentOptions(@Field("vanity") String vanity, Callback<PaymentOptionsPOJO> paymentOptionsCallback);

    //payment options of merchant
    @FormUrlEncoded
    @POST("/service/v1/merchant/pgsetting")
    void getMerchantPaymentOptions(@Field("vanity") String vanity, Callback<JsonElement> callback);

    // Get wallet of the user.
    @GET("/service/v2/profile/me/payment")
    void getWallet(@Header("Authorization") String header, Callback<JsonElement> callback);

    // Get the prepaid balance of the user.
    @GET("/service/v2/mycard")
    void getBalance(@Header("Authorization") String header, Callback<Amount> callback);

    //bill generator response
    @GET("/{path}")
    void getBillGeneratorResponse(@Path("path") String path, @Query("amount") String amount, Callback<PaymentBill> callback);

    // Send money by email
    @FormUrlEncoded
    @POST("/service/v2/prepayment/transfer")
    void sendMoneyByEmail(@Header("Authorization") String header, @Field("amount") String amount, @Field("currency") String currency, @Field("message") String message, @Field("to") String emailId, Callback<PaymentResponse> callback);

    // Send money by mobile
    @FormUrlEncoded
    @POST("/service/v2/prepayment/transfer/extended")
    void sendMoneyByMobile(@Header("Authorization") String header, @Field("amount") String amount, @Field("currency") String currency, @Field("message") String message, @Field("to") String mobileNo, Callback<PaymentResponse> callback);

}
