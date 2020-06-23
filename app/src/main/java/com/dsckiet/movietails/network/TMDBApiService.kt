package com.dsckiet.movietails.network

interface TMDBApiService {
/* TMDB APIs
     https://image.tmdb.org/t/p/original/yFSIUVTCvgYrpalUktulvk3Gi5Y.jpg
     https://api.themoviedb.org/3/movie/299534?api_key=910cb471f3326152066529eef1b406b2
     https://api.themoviedb.org/3/movie/now_playing?api_key=910cb471f3326152066529eef1b406b2
*/

    companion object{
        const val TMDB_API_KEY = "910cb471f3326152066529eef1b406b2"
        const val TMDB_BASE_URL = "https://api.themoviedb.org/3/"
        const val TMDB_POSTER_BASE_URL = "https://image.tmdb.org/t/p/original/"

        const val FIRST_PAGE = 1
        const val MOVIES_PER_PAGE = 20
    }

//    @GET("movie/now_playing?api_key=${TMDB_API_KEY}")
//    suspend fun getNowPlayingMovies(): Response<NowPlayingResponse>

//    @GET("movie/popular")
//    fun getPopularMovies(@Query("page" ) page: Int): Response<>

//    @GET("movie/{movie_id}")
//    fun getMovieDetails(@Path("movie_id") id: Int): Response<>
//
//    @GET("i={imdb_id}")
//    fun getMovieByImdbId(@Path("imdb_id") imdbID: Int): Response<>
//
//    @GET("t={movie_title}")
//    fun getMovieByTitle(@Path("movie_title") movieTitle: String): Response<>

}