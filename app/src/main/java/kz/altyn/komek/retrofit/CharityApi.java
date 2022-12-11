package kz.altyn.komek.retrofit;

import java.util.List;

import kz.altyn.komek.models.Charity;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface CharityApi {

    @Headers({"Accept: application/json"})
    @GET("/api/charity")
    Call<List<Charity>> getAllCharities();
}
