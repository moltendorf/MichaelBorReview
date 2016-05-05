package com.mikhail.sportsnewshistoryrecords.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mikhail.sportsnewshistoryrecords.R;
import com.mikhail.sportsnewshistoryrecords.adapters.LeaguesNewsAdapter;
import com.mikhail.sportsnewshistoryrecords.api.NytSearchAPI;
import com.mikhail.sportsnewshistoryrecords.model.search.ArticleSearch;
import com.mikhail.sportsnewshistoryrecords.model.search.Doc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Mikhail on 4/28/16.
 */
public class LeaguesFragment extends Fragment {
    private int mFragmentType;
    public RecyclerView recyclerView;
    public ArrayList<Doc> searchSportsResults;
    protected SwipeRefreshLayout swipeContainer;
    public static final String NYT_HOCKEY = "NHL";
    public static final String NYT_MLS = "MLS";
    public static final String NYT_FOOTBALL = "NFL Football";
    public static final String NYT_BASKETBALL = "NBA Basketball";
    public static final String NYT_BASEBALL = "Baseball";
    public static final String NYT_SPANISH = "La liga";
    public static final String NYT_ENGLISH = "English Premier league";
    public static final String NYT_ITALIAN = "Italian Serie A";
    public static final String NYT_GERMAN = "Bundesliga";

    LeaguesNewsAdapter leaguesNewsAdapter;


    TabLayout tabLayout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.recycleview_activity_fragment, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycle_view);
        searchSportsResults = new ArrayList<>();
        swipeContainer = (SwipeRefreshLayout) v.findViewById(R.id.swipeContainer);
//        tabLayout = (TabLayout) v.findViewById(R.id.tab_layout);
//        tabLayout.addTab(tabLayout.newTab().setText("Articles"));
//        tabLayout.addTab(tabLayout.newTab().setText("History"));
//        tabLayout.addTab(tabLayout.newTab().setText("Records"));
//        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        setPullRefresh();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return v;
    }



//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//
//        if (isVisibleToUser) {
//            apiCall();
//        }
//    }

    private void setPullRefresh() {
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                apiCall();
            }
        });

        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(android.R.color.darker_gray,
                android.R.color.white);

    }

    public void italianSoccerSearch() {
        NytSearchAPI.NytRx nytSports = NytSearchAPI.createRx();

        Observable<ArticleSearch> observable = nytSports.response(NYT_ITALIAN);

        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ArticleSearch>() {
                    @Override
                    public void onCompleted() {

                        Log.d("LeaguesFragment", "Query Succes!");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("LeaguesFragment", "Error!");
                    }

                    @Override
                    public void onNext(ArticleSearch response) {
                        handleData(response);

                    }
                });
    }

    public void spanishSoccerSearch() {
        NytSearchAPI.NytRx nytSports = NytSearchAPI.createRx();

        Observable<ArticleSearch> observable = nytSports.response(NYT_SPANISH);

        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ArticleSearch>() {
                    @Override
                    public void onCompleted() {

                        Log.d("LeaguesFragment", "Query Succes!");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("LeaguesFragment", "Error!");
                    }

                    @Override
                    public void onNext(ArticleSearch response) {
                        handleData(response);

                    }
                });
    }

    public void mlsSearch() {
        NytSearchAPI.NytRx nytSports = NytSearchAPI.createRx();

        Observable<ArticleSearch> observable = nytSports.response(NYT_MLS);

        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ArticleSearch>() {
                    @Override
                    public void onCompleted() {

                        Log.d("LeaguesFragment", "Query Succes!");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("LeaguesFragment", "Error!");
                    }

                    @Override
                    public void onNext(ArticleSearch response) {
                        handleData(response);

                    }
                });
    }

    public void bundesligaSearch() {
        NytSearchAPI.NytRx nytSports = NytSearchAPI.createRx();

        Observable<ArticleSearch> observable = nytSports.response(NYT_GERMAN);

        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ArticleSearch>() {
                    @Override
                    public void onCompleted() {

                        Log.d("LeaguesFragment", "Query Succes!");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("LeaguesFragment", "Error!");
                    }

                    @Override
                    public void onNext(ArticleSearch response) {
                        handleData(response);

                    }
                });
    }

    public void nbaSearch() {
        NytSearchAPI.NytRx nytSports = NytSearchAPI.createRx();

        Observable<ArticleSearch> observable = nytSports.response(NYT_BASKETBALL);

        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ArticleSearch>() {
                    @Override
                    public void onCompleted() {

                        Log.d("LeaguesFragment", "Query Succes!");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("LeaguesFragment", "nba Error!");
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(ArticleSearch response) {
                        swipeContainer.setRefreshing(false);
                        handleData(response);
                    }
                });
    }

    public void footballSearch() {
        NytSearchAPI.NytRx nytSports = NytSearchAPI.createRx();

        Observable<ArticleSearch> observable = nytSports.response(NYT_FOOTBALL);

        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ArticleSearch>() {
                    @Override
                    public void onCompleted() {

                        Log.d("LeaguesFragment", "Query Succes!");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("LeaguesFragment", "nfl Error!");
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(ArticleSearch response) {
                        swipeContainer.setRefreshing(false);
                        handleData(response);
                    }
                });
    }

    public void baseballSearch() {
        NytSearchAPI.NytRx nytSports = NytSearchAPI.createRx();

        Observable<ArticleSearch> observable = nytSports.response(NYT_BASEBALL);

        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ArticleSearch>() {
                    @Override
                    public void onCompleted() {

                        Log.d("LeaguesFragment", "Query Succes!");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("LeaguesFragment", "Error!");
                    }

                    @Override
                    public void onNext(ArticleSearch response) {
                        handleData(response);
                    }
                });
    }

    public void hockeySearch() {
        NytSearchAPI.NytRx nytSports = NytSearchAPI.createRx();

        Observable<ArticleSearch> observable = nytSports.response(NYT_HOCKEY);

        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ArticleSearch>() {
                    @Override
                    public void onCompleted() {

                        Log.d("LeaguesFragment", "Query Succes!");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("LeaguesFragment", "Error!");
                    }

                    @Override
                    public void onNext(ArticleSearch response) {

                        handleData(response);

                    }
                });
    }

//    public void englishSoccerSearch() {
//        NytSearchAPI.NytRx nytSports = NytSearchAPI.createRx();
//
//        Observable<ArticleSearch> observable = nytSports.response(NYT_ENGLISH);
//
//        observable.subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<ArticleSearch>() {
//                    @Override
//                    public void onCompleted() {
//
//                        Log.d("LeaguesFragment", "Query Succes!");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d("LeaguesFragment", "Error!");
//                    }
//
//                    @Override
//                    public void onNext(ArticleSearch response) {
//                        handleData(response);
//
//                    }
//                });
//    }

    private void englishSoccerSearch() {

        NytSearchAPI.NytAPIRetrofitSimple nytSportsSearch = NytSearchAPI.create();

        Call<ArticleSearch> call = nytSportsSearch.response(NYT_ENGLISH);

        call.enqueue(new Callback<ArticleSearch>() {
            @Override
            public void onResponse(Call<ArticleSearch> call, Response<ArticleSearch> response) {
                ArticleSearch nytSportsSearch = response.body();

//                Collection<Contributor> frequentContributors = Filter.isFrequentContributor(contributors);

                LeaguesNewsAdapter leaguesNewsAdapter = new LeaguesNewsAdapter(nytSportsSearch);
                recyclerView.setAdapter(leaguesNewsAdapter);
            }

            @Override
            public void onFailure(Call<ArticleSearch> call, Throwable t) {

            }
        });

    }


    public void setFragmentType(int type) {
        mFragmentType = type;
        apiCall();
    }

    private void apiCall() {
        switch (mFragmentType) {
            case R.id.nfl:
                footballSearch();
                break;
            case R.id.nba:
                nbaSearch();
                break;
            case R.id.mlb:
                baseballSearch();
                break;
            case R.id.nhl:
                hockeySearch();
                break;
            case R.id.mls:
                mlsSearch();
                break;
            case R.id.english_soccer:
                englishSoccerSearch();
                break;
            case R.id.spanish_soccer:
                spanishSoccerSearch();
                break;
            case R.id.italian_soccer:
                italianSoccerSearch();
                break;
            case R.id.german_soccer:
                bundesligaSearch();
                break;
        }
    }

    private void handleData(ArticleSearch response) {
        if (leaguesNewsAdapter == null && recyclerView != null) {
            leaguesNewsAdapter = new LeaguesNewsAdapter(response);
            recyclerView.setAdapter(leaguesNewsAdapter);
        } else if (leaguesNewsAdapter != null) {
            leaguesNewsAdapter.setArticles(response);
            leaguesNewsAdapter.notifyDataSetChanged();
        } else {
            leaguesNewsAdapter = new LeaguesNewsAdapter(response);
        }
    }
}


//List<Doc> articlesWithImages = articlesWithImages(response);
//LeaguesNewsAdapter leaguesNewsAdapter = new LeaguesNewsAdapter(articlesWithImages);
//recyclerView.setAdapter(leaguesNewsAdapter);
//        }
//        });
//        }
//
//private List<Doc> articlesWithImages(ArticleSearch response) {
//        Doc[] docs = response.getResponse().getDocs();
//        List<Doc> docsWithImages = new ArrayList<>();
//
//        for(Doc doc: docs) {
//        if(doc.getMultimedia() != null && doc.getMultimedia().length != 0) {
//        docsWithImages.add(doc);
//        }
//        }