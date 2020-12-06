package com.esprit.scluptfit.utils;

import com.esprit.scluptfit.entities.Exercice;
import com.esprit.scluptfit.entities.Post;
import com.esprit.scluptfit.entities.User;

import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GetDataService {
    /* **** EXERCICES SERVICES **** */
    @GET("/exercices")
    Call<ArrayList<Exercice>> getAllExercices();

    @GET("/exercices/{id}")
    Call<ArrayList<Exercice>> getExercicesById(@Path("id") String _id);

    @GET("/exercices/find/{category}")
    Call<ArrayList<Exercice>> getExercicesByCategory(@Path("category") String category);

    /* **** USERS SERVICES **** */
    @POST("/users/login")
    Call<LoginResponse> Login(@Body User user);

    @POST("/users/signup")
    Call<User> Signup(@Body User user);

    @GET("/users/find/")
    Call<ArrayList<User>> getAllUsers();

    @GET("/users/find/{id}")
    Call<User> getUserById(@Path("id") String idUser);

    @POST("/users/hi/{idUser}&{calories}&{steps}&{weight}&{height}")
    Call<ResponseBody> addHealthInformation(@Path("idUser") String idUser,
                                            @Path("calories") Double calories,
                                            @Path("steps") int steps,
                                            @Path("weight") Double weight,
                                            @Path("height") Double height);

    @POST("/users/runs/{idUser}&{calories}&{distance}&{duration}")
    Call<ResponseBody> addRun(@Path("idUser") String idUser, @Path("calories") Double calories, @Path("distance") Double distance,
                              @Path("duration") Double duration);

    @POST("/users/activities/{idUser}&{sum}&{idExercice}")
    Call<ResponseBody> addActivity(@Path("idUser") String idUser,
                                   @Path("sum") int sum,
                                   @Path("idExercice") String idExercice);

    @DELETE("/users/{id}")
    Call<Void> deleteUser(@Path("id") String idUser);

    /* **** POSTS SERVICE **** */
    @GET("/posts")
    Call<ArrayList<Post>> getAllPosts();

    @GET("/posts/{id}")
    Call<ArrayList<Post>> getPostsById(@Path("id") String _id);

    @GET("/posts/find/{idUser}")
    Call<ArrayList<Post>> getPostsByIdUser(@Path("idUser") String idUser);

    @POST("/posts/comments/{idPost}&{text}&{idUser}")
    Call<ResponseBody> addComment(@Path("idPost") String idPost,
                                  @Path("text") String text,
                                  @Path("idUser") String idUser);

    @DELETE("/posts/{id}")
    Call<Void> deletePost(@Path("id") String _id);

    @POST("/posts")
    Call<Post> addPost(@Body Post post);

    @PATCH("/posts/text/{id}")
    Call<Post> updatePostText(@Path("id") String idPost, @Body Post post);

    @PATCH("/posts/likes/{id}")
    Call<Post> updatePostLikes(@Path("id") String idPost, @Body Post post);


}
