package cn.bmob.data.api;

import com.google.gson.JsonObject;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface BmobApiService {


    //TODO =========================================BmobObject单条数据增删改查=============================================

    /**
     * 新增一行数据
     *
     * @param tableName
     * @param jsonObject
     * @return
     */
    @POST("/1/classes/{tableName}")
    Call<JsonObject> insert(@Path("tableName") String tableName, @Body JsonObject jsonObject);


    /**
     * 删除一行数据
     *
     * @param tableName
     * @param objectId
     * @return
     */
    @DELETE("/1/classes/{tableName}/{objectId}")
    Call<JsonObject> deleteRow(@Path("tableName") String tableName, @Path("objectId") String objectId);


    @PUT("/1/classes/{tableName}/{objectId}")
    Call<JsonObject> deleteColumn(@Path("tableName") String tableName, @Path("objectId") String objectId);


    /**
     * 更新一条数据
     *
     * @param tableName
     * @param objectId
     * @param jsonObject
     * @return
     */
    @PUT("/1/classes/{tableName}/{objectId}")
    Call<JsonObject> update(@Path("tableName") String tableName, @Path("objectId") String objectId,
        @Body JsonObject jsonObject);

    /**
     * 查询一条数据
     *
     * @param tableName
     * @param objectId
     * @return
     */
    @GET("/1/classes/{tableName}/{objectId}")
    Call<JsonObject> get(@Path("tableName") String tableName, @Path("objectId") String objectId,
        @QueryMap Map<String, Object> map);

    @GET("/1/classes/{tableName}")
    Call<JsonObject> getObjects(@Path("tableName") String tableName, @QueryMap Map<String, Object> map);


    //TODO =========================================用户=============================================

    @POST("/1/users")
    Call<JsonObject> signUp(@Body JsonObject jsonObject);


    @GET("/1/login")
    Call<JsonObject> login(@Query("username") String username, @Query("password") String password);


    /**
     * 获取某个用户信息
     *
     * @param objectId
     * @return
     */
    @GET("/1/users/{objectId}")
    Call<JsonObject> getUserInfo(@Path("objectId") String objectId);


    /**
     * 检查某个用户的登录令牌是否过期
     *
     * @param objectId
     * @return
     */
    @GET("/1/checkSession/{objectId}")
    Call<JsonObject> checkUserSession(@Path("objectId") String objectId);


    /**
     * 更新某个用户信息
     *
     * @param objectId
     * @return
     */
    @PUT("/1/users/{objectId}")
    Call<JsonObject> updateUserInfo(@Path("objectId") String objectId, @Body JsonObject jsonObject);

    /**
     * 删除某个用户
     *
     * @param objectId
     * @return
     */
    @DELETE("/1/users/{objectId}")
    Call<JsonObject> deleteUser(@Path("objectId") String objectId);


    /**
     * 邮箱重置密码
     *
     * @param jsonObject
     * @return
     */
    @POST("/1/requestPasswordReset")
    Call<JsonObject> sendEmailForResetPassword(@Body JsonObject jsonObject);


    /**
     * 发送验证用户邮箱的邮件
     *
     * @param jsonObject
     * @return
     */
    @POST("/1/requestEmailVerify")
    Call<JsonObject> sendEmailForVerifyUserEmail(@Body JsonObject jsonObject);

    /**
     * 手机短信验证码重置密码
     *
     * @param jsonObject
     * @return
     */
    @PUT("/1/resetPasswordBySmsCode/{smsCode}")
    Call<JsonObject> resetUserPasswordBySmsCode(@Path("smsCode") String smsCode, @Body JsonObject jsonObject);


    /**
     * 未登录，第三方账号系统进行授权登录/注册
     *
     * @param jsonObject
     * @return
     */
    @POST("/1/users")
    Call<JsonObject> thirdSignUpLogin(@Body JsonObject jsonObject);


    /**
     * 已登录，将现有bmob用户与第三方账号系统关联绑定
     *
     * @param jsonObject
     * @return
     */
    @PUT("/1/users/{objectId}")
    Call<JsonObject> thirdBind(@Path("objectId") String objectId, @Body JsonObject jsonObject);

    /**
     * 已登录，将现有bmob用户与第三方账号系统解除关联
     *
     * @param jsonObject
     * @return
     */
    @PUT("/1/users/{objectId}")
    Call<JsonObject> thirdUnBind(@Path("objectId") String objectId, @Body JsonObject jsonObject);


    /**
     * 手机短信验证码重置密码
     *
     * @param jsonObject
     * @return
     */
    @PUT("/1/updateUserPassword/{objectId}")
    Call<JsonObject> resetUserPasswordByOldPassword(@Path("objectId") String objectId, @Body JsonObject jsonObject);


    //TODO =========================================短信=============================================


    /**
     * 发送短信
     *
     * @param object
     * @return
     */
    @POST("/1/requestSmsCode")
    Call<JsonObject> sendSmsCode(@Body Object object);


    /**
     * 验证短信验证码
     *
     * @param smsCode
     * @param object
     * @return
     */
    @POST("/1/verifySmsCode/{smsCode}")
    Call<JsonObject> verifySmsCode(@Path("smsCode") String smsCode, @Body Object object);


    //TODO ========================================文件=============================================


    @POST("/2/files/{fileName}")
    Call<JsonObject> upload(@Path("fileName") String fileName, @Body RequestBody body);


    @DELETE("/2/files/{cdnName}/{url}")
    Call<JsonObject> delete(@Path("cdnName") String cdnName, @Path("url") String url);


    @POST("/2/cdnBatchDelete")
    Call<JsonObject> deleteBatch(@Body JsonObject jsonObject);


}
