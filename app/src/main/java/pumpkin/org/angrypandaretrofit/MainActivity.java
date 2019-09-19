package pumpkin.org.angrypandaretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.HashMap;

import pumpkin.org.angrypandaretrofit.media.IDPadPlayer;

import ximalayaos.net.RetrofitManager;
import ximalayaos.net.XiMaLayaOsWrapper;
import ximalayaos.net.model.BaseResult;
import ximalayaos.net.model.JuHeChengYu;
import ximalayaos.net.model.JuHeNews;
import ximalayaos.net.model.JuHeNewsStr;
import ximalayaos.net.model.albbrowse.AlbumsBrowseBean;
import ximalayaos.net.model.searchalbum.SearchAlbumBean;
import ximalayaos.net.model.tag.TagsList;
import ximalayaos.net.model.album.AlbumsBean;
import ximalayaos.net.params.JsonParamsBuild;
import ximalayaos.net.request.AlbumBatchRequest;
import ximalayaos.net.request.AlbumBatchUpdateRequest;
import ximalayaos.net.request.AlbumBrowseRequest;
import ximalayaos.net.request.AlbumRequest;
import ximalayaos.net.request.BannersBatchRequest;
import ximalayaos.net.request.ColumnsBatchRequest;
import ximalayaos.net.request.ColumnsBrowseRequest;
import ximalayaos.net.request.IRequest;
import ximalayaos.net.request.MetadataAblumsRequest;
import ximalayaos.net.request.MetadataListRequest;
import ximalayaos.net.request.RankAlbumRequest;
import ximalayaos.net.request.RanksListRequest;
import ximalayaos.net.request.TagRequest;
import ximalayaos.net.request.TracksBatchRequest;
import ximalayaos.net.request.TracksLastPlayRequest;
import ximalayaos.net.request.XiVodAPIManager;
import ximalayaos.net.request.search.SearchAlbumRequest;
import ximalayaos.net.request.search.SearchAlbumv2Request;
import ximalayaos.net.request.search.SearchTracksRequest;
import ximalayaos.net.request.search.SearchTrackv2Request;
import ximalayaos.net.request.search.XiSearchManager;
import ximalayaos.net.sign.Sign;
import ximalayaos.net.utils.Device;
import ximalayaos.net.params.ParamsMap;
import ximalayaos.net.utils.RndStr;
import ximalayaos.net.http.test.GetTest;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    private Button mBtn;
    private Button mBtn0;
    private Button mBtn1;
    private Button mXiBtn1;
    private Button mXiBtn2;
    private Button mTagBtn;
    private Button mAlbumBtn;
    private Button mAlbumBrowseBtn;
    private Button mAlbumBatchBtn;
    private Button mAlbumBatchUpdateBtn;
    private Button mTracksBatchBtn;
    private Button mTrackLastBtn;
    private Button mMetaListBtn;
    private Button mMetaAlbumBtn;
    private Button mRankListBtn;
    private Button mRankAlbumBtn;
    private Button mColumnBatchBtn;
    private Button mColumnBrowseBtn;
    private Button mBannerBtn;
    private Button mSearchAlbumBtn;
    private Button mSearchTrackBtn;
    private Button mSearchAlbumV2Btn;
    private Button mSearchTrackV2Btn;
    private Button mHotWordBtn;
    private Button mSugBtn;

    //public CompositeSubscription mCompositeSubscription;
    final XiMaLayaOsWrapper wrapper = new XiMaLayaOsWrapper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // mCompositeSubscription = new CompositeSubscription();

        mSugBtn = (Button)findViewById(R.id.sugword);
        mSugBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                XiSearchManager.getInstance().httpSearchSuggestWordsRequest(getApplicationContext(), "中国", new IRequest() {
                    @Override
                    public void callBackRequestResult(String rawJson) {

                    }

                    @Override
                    public void callBackRequestBean(BaseResult result) {

                    }

                    @Override
                    public void callBackRequestError(String rawJson) {

                    }
                });
                /*SearchSuggestWordsRequest.httpSearchSuggestWordsRequest(getApplicationContext(), "中国", new IRequest() {
                    @Override
                    public void callBackRequestResult(String rawJson) {

                    }

                    @Override
                    public void callBackRequestBean(BaseResult result) {

                    }

                    @Override
                    public void callBackRequestError(String rawJson) {

                    }
                });*/
            }
        });

        mHotWordBtn = (Button)findViewById(R.id.hotword);
        mHotWordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XiSearchManager.getInstance().httpSearchHotWordRequest(getApplicationContext(), 2, new IRequest() {
                    @Override
                    public void callBackRequestResult(String rawJson) {

                    }

                    @Override
                    public void callBackRequestBean(BaseResult result) {

                    }

                    @Override
                    public void callBackRequestError(String rawJson) {

                    }
                });
                /*SearchHotWordRequest.httpSearchHotWordRequest(getApplicationContext(), 2, new IRequest() {
                    @Override
                    public void callBackRequestResult(String rawJson) {

                    }

                    @Override
                    public void callBackRequestBean(BaseResult result) {

                    }

                    @Override
                    public void callBackRequestError(String rawJson) {

                    }
                });*/
            }
        });

        mSearchTrackV2Btn = (Button)findViewById(R.id.searchtracksv2);
        mSearchTrackV2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchTrackv2Request.httpSearchTrackv2Request(getApplicationContext(), new IRequest() {
                    @Override
                    public void callBackRequestResult(String rawJson) {

                    }

                    @Override
                    public void callBackRequestBean(BaseResult result) {

                    }

                    @Override
                    public void callBackRequestError(String rawJson) {

                    }
                });
            }
        });

        mSearchAlbumV2Btn = (Button)findViewById(R.id.searchalbumv2);
        mSearchAlbumV2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchAlbumv2Request.httpSearchAlbumv2Request(getApplicationContext(), new IRequest() {
                    @Override
                    public void callBackRequestResult(String rawJson) {

                    }

                    @Override
                    public void callBackRequestBean(BaseResult result) {

                    }

                    @Override
                    public void callBackRequestError(String rawJson) {

                    }
                });
            }
        });


        mSearchTrackBtn = (Button)findViewById(R.id.searchtracks);
        mSearchTrackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchTracksRequest.httpSearchTracksRequest(getApplicationContext(), "林夕", 3, 1, 1, 20, new IRequest() {
                    @Override
                    public void callBackRequestResult(String rawJson) {

                    }

                    @Override
                    public void callBackRequestBean(BaseResult result) {

                    }

                    @Override
                    public void callBackRequestError(String rawJson) {

                    }
                });
            }
        });

        mSearchAlbumBtn = (Button)findViewById(R.id.searchalbum);
        mSearchAlbumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchAlbumRequest.httpSearchAlbumRequest(getApplicationContext(), "刘德华", new IRequest() {
                    @Override
                    public void callBackRequestResult(String rawJson) {

                    }

                    @Override
                    public void callBackRequestBean(BaseResult result) {

                        // 通过搜素专辑,得到专辑的ID
                        // 通过专辑的ID,获取专辑ID详细信息
                        SearchAlbumBean searchAlbumBean = (SearchAlbumBean) result;

                        XiVodAPIManager.getInstance().httpAlbumBrowseRequest(getApplicationContext(),
                                (int) searchAlbumBean.getAlbums().get(0).getId(), new IRequest() {
                                    @Override
                                    public void callBackRequestResult(String rawJson) {

                                    }

                                    @Override
                                    public void callBackRequestBean(BaseResult result) {

                                        AlbumsBrowseBean albumsBrowseBean = (AlbumsBrowseBean) result;
                                        String url = albumsBrowseBean.getTracks().get(0).getPlay_url_32();

                                        IDPadPlayer.builder(getApplicationContext()).play(url);

                                    }

                                    @Override
                                    public void callBackRequestError(String rawJson) {

                                    }
                                });

                    }

                    @Override
                    public void callBackRequestError(String rawJson) {

                    }
                });
            }
        });

        mBannerBtn=(Button)findViewById(R.id.banner);
        mBannerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BannersBatchRequest.httpBannersBatchRequest(getApplicationContext(), "11069", new IRequest() {
                    @Override
                    public void callBackRequestResult(String rawJson) {

                    }

                    @Override
                    public void callBackRequestBean(BaseResult result) {

                    }

                    @Override
                    public void callBackRequestError(String rawJson) {

                    }
                });
            }
        });

        mColumnBrowseBtn=(Button)findViewById(R.id.albumbrowse);
        mColumnBrowseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColumnsBrowseRequest.httpColumnsBrowseRequest(getApplicationContext(), 34, 1, 20, new IRequest() {
                    @Override
                    public void callBackRequestResult(String rawJson) {

                    }

                    @Override
                    public void callBackRequestBean(BaseResult result) {

                    }

                    @Override
                    public void callBackRequestError(String rawJson) {

                    }
                });
            }
        });

        mColumnBatchBtn = (Button)findViewById(R.id.columbatch);
        mColumnBatchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColumnsBatchRequest.httpColumnsBatchRequest(getApplicationContext(), "26052508", new IRequest() {
                    @Override
                    public void callBackRequestResult(String rawJson) {

                    }

                    @Override
                    public void callBackRequestBean(BaseResult result) {

                    }

                    @Override
                    public void callBackRequestError(String rawJson) {

                    }
                });
            }
        });

        mRankAlbumBtn=(Button)findViewById(R.id.rankalbum);
        mRankAlbumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RankAlbumRequest.httpRankAlbumRequest(getApplicationContext(),"64",1,20, new IRequest() {
                    @Override
                    public void callBackRequestResult(String rawJson) {

                    }

                    @Override
                    public void callBackRequestBean(BaseResult result) {

                    }

                    @Override
                    public void callBackRequestError(String rawJson) {

                    }
                });
            }
        });

        mRankListBtn=(Button)findViewById(R.id.ranklist);
        mRankListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RanksListRequest.httpRanksListRequest(getApplicationContext(),1, new IRequest() {
                    @Override
                    public void callBackRequestResult(String rawJson) {

                    }

                    @Override
                    public void callBackRequestBean(BaseResult result) {

                    }

                    @Override
                    public void callBackRequestError(String rawJson) {

                    }
                });
            }
        });

        mMetaAlbumBtn = (Button)findViewById(R.id.metaalbum);
        mMetaAlbumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String, String> paramsMap = new HashMap<>();
                // 该声音所属专辑ID
                paramsMap.put("category_id", "3");
                // paramsMap.put("metadata_attributes", "");
                // 返回结果排序维度：1-最火，2-最新，3-最多播放
                paramsMap.put("calc_dimension", "1");
                paramsMap.put("page", "1");
                paramsMap.put("count", "20");
                ParamsMap.addCommonParams(getApplicationContext(),paramsMap);

                MetadataAblumsRequest.httpMetadataAblumsRequest(getApplicationContext(),3,1,1,20, new IRequest() {
                    @Override
                    public void callBackRequestResult(String rawJson) {

                    }

                    @Override
                    public void callBackRequestBean(BaseResult result) {

                    }

                    @Override
                    public void callBackRequestError(String rawJson) {

                    }
                });
            }
        });


        mMetaListBtn = (Button)findViewById(R.id.metalist);
        mMetaListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, String> paramsMap = new HashMap<>();
                // 该声音所属专辑ID
                paramsMap.put("category_id", "3");
                ParamsMap.addCommonParams(getApplicationContext(),paramsMap);

                MetadataListRequest.httpMetadataListRequest(getApplicationContext(),3, new IRequest() {
                    @Override
                    public void callBackRequestResult(String rawJson) {

                    }

                    @Override
                    public void callBackRequestBean(BaseResult result) {

                    }

                    @Override
                    public void callBackRequestError(String rawJson) {

                    }
                });
            }
        });

        mTrackLastBtn = (Button)findViewById(R.id.trackslast);
        mTrackLastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, String> paramsMap = new HashMap<>();
                // 该声音所属专辑ID
                paramsMap.put("album_id", "26052508");
                // 声音ID
                paramsMap.put("track_id", "207451147");
                // 每页大小，范围为[1,200]，默认为20
                paramsMap.put("count", "20");
                // 正序取页结果或倒序取页结果："asc" - 正序，"desc" - 倒序，默认为"asc"
                paramsMap.put("sort", "asc");
                // 是否输出付费内容（即返回值是否包含付费内容）：true-是；false-否；默认不填为false
                paramsMap.put("contains_paid", "false");

                ParamsMap.addCommonParams(getApplicationContext(),paramsMap);

                TracksLastPlayRequest.httpTracksLastPlayRequest(getApplicationContext(),
                        26052508,207451147,20,"asc",false,new IRequest() {
                    @Override
                    public void callBackRequestResult(String rawJson) {

                    }

                    @Override
                    public void callBackRequestBean(BaseResult result) {

                    }

                    @Override
                    public void callBackRequestError(String rawJson) {

                    }
                });


            }
        });

        mTracksBatchBtn = (Button)findViewById(R.id.tracksbatch);
        mTracksBatchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, String> paramsMap = new HashMap<>();
                // 以英文逗号分隔的专辑ID
                paramsMap.put("ids", "26052508");
                paramsMap.put("only_play_info", "false");

                ParamsMap.addCommonParams(getApplicationContext(),paramsMap);

                TracksBatchRequest.httpTracksBatchRequest(getApplicationContext(),"15362879",true, new IRequest() {
                    @Override
                    public void callBackRequestResult(String rawJson) {

                    }

                    @Override
                    public void callBackRequestBean(BaseResult result) {

                    }

                    @Override
                    public void callBackRequestError(String rawJson) {

                    }
                });

            }
        });


        mAlbumBatchUpdateBtn = (Button)findViewById(R.id.albumupdatebatch);
        mAlbumBatchUpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, String> paramsMap = new HashMap<>();
                // 以英文逗号分隔的专辑ID
                paramsMap.put("ids", "26052508");

                ParamsMap.addCommonParams(getApplicationContext(),paramsMap);

                AlbumBatchUpdateRequest.httpAlbumBatchUpdateRequest(getApplicationContext(),"26052508", new IRequest() {
                    @Override
                    public void callBackRequestResult(String rawJson) {

                    }

                    @Override
                    public void callBackRequestBean(BaseResult result) {

                    }

                    @Override
                    public void callBackRequestError(String rawJson) {

                    }
                });

            }
        });

        mAlbumBatchBtn = (Button)findViewById(R.id.albumbatch);
        mAlbumBatchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, String> paramsMap = new HashMap<>();
                // 以英文逗号分隔的专辑ID，一次最多传200个，超出部分ID会被忽略
                paramsMap.put("ids", "26052508");
                // true代表返回metadata，false或不填不返回，获取所有元数据列表，可以使用接口/metadata/list
                paramsMap.put("with_metadata", "false");

                ParamsMap.addCommonParams(getApplicationContext(),paramsMap);

                AlbumBatchRequest.httpAlbumBatchRequest(getApplicationContext(),"26052508",false, new IRequest() {
                    @Override
                    public void callBackRequestResult(String rawJson) {

                    }

                    @Override
                    public void callBackRequestBean(BaseResult result) {

                    }

                    @Override
                    public void callBackRequestError(String rawJson) {

                    }
                });
            }
        });

        mAlbumBrowseBtn = (Button)findViewById(R.id.albumbrowse);
        mAlbumBrowseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, String> paramsMap = new HashMap<>();
                // 专辑ID
                paramsMap.put("album_id", "26052508");
                // 返回结果排序方式： 默认为"asc"
                paramsMap.put("sort", "asc");
                // 返回第几页，从1开始，默认为1
                paramsMap.put("page", "1");
                // 每页大小，范围为[1,200]，默认为20
                paramsMap.put("count", "20");
                ParamsMap.addCommonParams(getApplicationContext(),paramsMap);

                AlbumBrowseRequest.httpAlbumBrowseRequest(getApplicationContext(),26052508, new IRequest() {
                    @Override
                    public void callBackRequestResult(String rawJson) {

                    }

                    @Override
                    public void callBackRequestBean(BaseResult result) {

                    }

                    @Override
                    public void callBackRequestError(String rawJson) {

                    }
                });

            }
        });

        mAlbumBtn = (Button)findViewById(R.id.album);
        mAlbumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, String> paramsMap = new HashMap<>();
                // 分类ID，为0时表示热门分类。分类数据可以通过 /categories/list 获取
                paramsMap.put("category_id", "3");
                // 专辑标签，可以通过传值为0的type参数去调 /v2/tags/list 获取
                paramsMap.put("tag_name", "0");
                // 返回结果排序维度：1-最火，2-最新，3-最多播放
                paramsMap.put("calc_dimension", "1");
                // 返回第几页，从1开始，默认为1
                paramsMap.put("page", "1");
                // 每页大小，范围为[1,200]，默认为20
                paramsMap.put("count", "20");
                // 是否输出付费内容（即返回值是否包含付费内容）：true-是；false-否；默认不填为false
                paramsMap.put("contains_paid", "false");
                ParamsMap.addCommonParams(getApplicationContext(), paramsMap);

                AlbumRequest.httpAlbumRequest(getApplicationContext(),3,"0",1,1,20,false, new IRequest() {
                    @Override
                    public void callBackRequestResult(String rawJson) {
                        Log.e(TAG, "album request result : " + rawJson);
                    }

                    @Override
                    public void callBackRequestBean(BaseResult result) {
                        AlbumsBean bean = (AlbumsBean) result;
                        Log.e(TAG, "album request result : " + bean.getAlbums().get(0).getAlbum_title());
                    }

                    @Override
                    public void callBackRequestError(String rawJson) {

                    }
                });

            }
        });

        mTagBtn = (Button) findViewById(R.id.tag);
        mTagBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String, String> paramsMap = new HashMap<>();
                paramsMap.put("category_id", "3");
                paramsMap.put("type", "0");
                ParamsMap.addCommonParams(getApplicationContext(), paramsMap);
                TagRequest.httpTagRequest(getApplicationContext(),3,0, new IRequest() {
                    @Override
                    public void callBackRequestResult(String rawJson) {
                        Log.e(TAG, "tag request result : " + rawJson);
                    }

                    @Override
                    public void callBackRequestBean(BaseResult result) {
                        TagsList listBean = (TagsList) result;
                        Log.e(TAG, "tag request result : " + listBean.getData().get(0).getTag_name());
                    }

                    @Override
                    public void callBackRequestError(String rawJson) {

                    }
                });

            }
        });


        mXiBtn2 = (Button) findViewById(R.id.button3);
        mXiBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("app_key", "b617866c20482d133d5de66fceb37da3");
                hashMap.put("client_os_type", "4");
                hashMap.put("nonce", RndStr.getRandomString(10));
                hashMap.put("timestamp", System.currentTimeMillis() + "");
                hashMap.put("server_api_version", "1.0.0");
                hashMap.put("device_id", Device.getAndroidId(getApplicationContext()));
                hashMap.put("sig", Sign.generateSig(hashMap));

                XiVodAPIManager.getInstance().httpCategoryRequest(getApplicationContext(), new IRequest() {
                    @Override
                    public void callBackRequestResult(String rawJson) {

                    }

                    @Override
                    public void callBackRequestBean(BaseResult result) {

                    }

                    @Override
                    public void callBackRequestError(String rawJson) {

                    }
                });

                // wrapper.getXiCategoriesList(hashMap);
                /*CategoryRequest.httpCategoryRequest(getApplicationContext(), new IRequest() {
                    @Override
                    public void callBackRequestResult(String rawJson) {
                        Log.e(TAG, "request result : " + rawJson);
                    }

                    @Override
                    public void callBackRequestBean(BaseResult result) {
                        CategoriesList list = (CategoriesList) result;
                        Log.e(TAG, "request result : " + list.getData().get(1).getCategory_name());
                    }

                    @Override
                    public void callBackRequestError(String rawJson) {

                    }
                });*/
            }
        });

        mBtn0 = (Button) findViewById(R.id.button0);
        mBtn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("type", "top");
                hashMap.put("key", "6cf780f700fb7211695fc721665194ab");

                /*Subscription subscription = wrapper.getJuHeInfoStr(hashMap*//*jsonObject*//*)
                        .subscribe(xiMaLayaOsSubscriber(new Action1<JuHeNewsStr>() {
                            @Override
                            public void call(JuHeNewsStr o) {
                                Log.d("MainActivity", "-- login " + "Success : " + o.getDatas());
                                Toast.makeText(getApplicationContext(), "get : " + o.getDatas(), Toast.LENGTH_SHORT).show();
                                // goNext(o);
                            }
                        }, null));
                mCompositeSubscription.add(subscription);*/
            }
        });

        mXiBtn1 = (Button) findViewById(R.id.button2);
        mXiBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("app_key", "b617866c20482d133d5de66fceb37da3");
                hashMap.put("client_os_type", "4");
                hashMap.put("nonce", RndStr.getRandomString(10));
                hashMap.put("timestamp", System.currentTimeMillis() + "");
                hashMap.put("server_api_version", "1.0.0");
                hashMap.put("device_id", Device.getAndroidId(getApplicationContext()));
                hashMap.put("sig", Sign.generateSig(hashMap));
                String body = Sign.showBody(hashMap);
                Log.e(TAG, body);
                // PostTest.post(hashMap);
                GetTest.getTest(hashMap);
                // GetConnTest.getQuery(hashMap);
                testSig();
            }
        });

        mBtn1 = (Button) findViewById(R.id.button1);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("word", stringToUnicode("自相矛盾")*//*"%E8%87%AA%E7%9B%B8%E7%9F%9B%E7%9B%BE&d"*//*);
                hashMap.put("dtype", "json");
                hashMap.put("key", "156d4911fdfa828aded330d6b45897aa");

                Subscription subscription = wrapper.getChengYuInfo(hashMap*//*jsonObject*//*)
                        .subscribe(xiMaLayaOsSubscriber(new Action1<JuHeChengYu>() {
                            @Override
                            public void call(JuHeChengYu o) {
                                Log.d("MainActivity", "-- login " + "Success : " + o.getResult().getExample());
                                Toast.makeText(getApplicationContext(), "" + o.getResult().getExample(), Toast.LENGTH_SHORT).show();
                                // goNext(o);
                            }
                        }, null));
                mCompositeSubscription.add(subscription);*/
            }
        });

        mBtn = (Button) findViewById(R.id.button);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*JSONObject jsonObject = JsonParamsBuild.buildJuHeNews("top", "6cf780f700fb7211695fc721665194ab");

                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("type", "top");
                hashMap.put("key", "6cf780f700fb7211695fc721665194ab");

                Subscription subscription = wrapper.getJuHeInfo(hashMap*//*jsonObject*//*)
                        .subscribe(xiMaLayaOsSubscriber(new Action1<JuHeNews>() {
                            @Override
                            public void call(JuHeNews o) {
                                Log.d("MainActivity", "-- login " + "Success : " + o.getResult().getData().get(0).getTitle());
                                goNext(o);
                            }
                        }, null));
                mCompositeSubscription.add(subscription);*/
            }
        });
    }

    public void goNext(JuHeNews news) {
        Toast.makeText(getApplicationContext(), "" + news.getResult().getData().get(0).getTitle(), Toast.LENGTH_SHORT).show();
    }

    public void testSig() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("app_key", "b617866c20482d133d5de66fceb37da3");
        hashMap.put("client_os_type", "4");
        hashMap.put("nonce", "mfn6ioblw4d");
        hashMap.put("timestamp", "1568627500861");
        hashMap.put("server_api_version", "1.0.0");
        hashMap.put("device_id", "32cc6f279c7a11e9a26e0235d2b38928");
        hashMap.put("sig", Sign.generateSig(hashMap)/*Sig.createSig(hashMap)*//*"bee6203aa68184028269ae266191a948"*/);
        String body = Sign.showBody(hashMap);
        Log.e("liuzhibao", body);
    }


    public void showToast(String info) {
        Toast.makeText(getApplicationContext(), info, Toast.LENGTH_SHORT).show();
    }

    public interface OnCompletedListenter {
        void onCompleted();

        void onError();
    }

    public static String stringToUnicode(String s) {
        try {
            StringBuffer out = new StringBuffer("");
            //直接获取字符串的unicode二进制
            byte[] bytes = s.getBytes("unicode");
            //然后将其byte转换成对应的16进制表示即可
            for (int i = 0; i < bytes.length - 1; i += 2) {
                out.append("\\u");
                String str = Integer.toHexString(bytes[i + 1] & 0xff);
                for (int j = str.length(); j < 2; j++) {
                    out.append("0");
                }
                String str1 = Integer.toHexString(bytes[i] & 0xff);
                out.append(str1);
                out.append(str);
            }
            return out.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

}
