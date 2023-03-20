package org.example.api;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import org.example.bean.WorkInfo;
import org.example.bean.ProjectInfo;
import org.example.bean.UserInfo;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public interface GitLabApi {
    Holder holder=new Holder();

    class Holder{
        GitLabApi instance;
    }
    /**
     * 获取用户信息
     * @param token
     * @param userName
     * @return
     */
    @GET("/api/v4/users")
    Observable<List<UserInfo>> getUserInfo(@Header("PRIVATE-TOKEN")String token, @Query("username") String userName);


    /**
     *
     * @param token 令牌
     * @param userId 用户id
     * @param pageSize 分页大小
     * @param pageIndex 分页index 从1开始
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @return
     */
    @GET("/api/v4/users/{userId}/events")
    Observable<List<WorkInfo>> getUserEvents(@Header("PRIVATE-TOKEN")String token, @Path("userId")int userId, @Query("per_page") int pageSize,@Query("page") int pageIndex, @Query("after") String startDate, @Query("before") String endDate);

    /**
     * 获取项目信息
     * @param projectId
     * @return
     */
    @GET("/api/v4/projects/{projectId}")
    Observable<ProjectInfo> getProjectInfo(@Header("PRIVATE-TOKEN")String token,@Path("projectId") int projectId);

    Calendar calendar = new GregorianCalendar();
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    static Observable<List<WorkInfo>> getWorkList(QueryBean bean){
        if(holder.instance==null){
            try {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(bean.baseUrl)
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                GitLabApi gitLabApi = retrofit.create(GitLabApi.class);
                holder.instance = gitLabApi;
            }catch (Exception e){
                return Observable.error(e);
            }
        }
        // 获取当前时间

        String statTime= bean.startTime;
        String endTime= bean.endTime;
        try {
            calendar.setTime(sf.parse(bean.startTime));
             calendar.add(Calendar.DATE, -1);
             statTime=sf.format(calendar.getTime());

            calendar.setTime(sf.parse(bean.endTime));
            calendar.add(Calendar.DATE, 1);
            endTime=sf.format(calendar.getTime());

        } catch (ParseException e) {
           return Observable.error(new RuntimeException("时间格式不对:startTime="+bean.startTime+".endTime="+bean.endTime));
        }


        String finalStatTime = statTime;
        String finalEndTime = endTime;
        return holder.instance
                .getUserInfo(bean.token, bean.name)
                .flatMap(list->{
                    if(list.isEmpty()){
                        return Observable.error(new RuntimeException("没有对应的用户信息:mame="+bean.name+",请请确保用户名正确"));
                    }else {
                        return Observable.just(list.get(0));
                    }
                })
                .map(UserInfo::getId)
                .flatMap(id-> getUserEventsForPage(bean.token,id,finalStatTime,finalEndTime))
                .compose(new ProjectTransform(holder.instance,bean.token))
                .subscribeOn(Schedulers.io());
    }

    /**
     * 通过分页的方式获取所有的用户事件
     * @return
     */
    static   Observable<List<WorkInfo>> getUserEventsForPage(String token,int userId,String startTime,String endTime){
        return Observable.create(new ObservableOnSubscribe<List<WorkInfo>>() {
          final   Object lock=new Object();
            boolean haveMore=true;
            boolean errorOccurred=false;
            Throwable throwable=null;
            @Override
            public void subscribe(ObservableEmitter<List<WorkInfo>> emitter) throws Exception {
                int pageIndex=1;
                int perPageSize=100;
                List<WorkInfo> workInfos=new ArrayList<>(0);
                while (haveMore&&!emitter.isDisposed()) {
                    System.out.println("获取用户事件 pageIndex="+pageIndex);
                    holder.instance.getUserEvents(token, userId, perPageSize, pageIndex, startTime, endTime)
                            .subscribe(list->{
                                if(list.size()<perPageSize){
                                    haveMore=false;
                                }
                                workInfos.addAll(list);

                            },e->{
                                throwable=e;
                                errorOccurred=true;
                                haveMore=false;

                            });

                    pageIndex++;
                }
               if(!errorOccurred){
                   emitter.onNext(workInfos);
                   emitter.onComplete();
               }else{
                   emitter.onError(throwable);
               }
            }
        });

    }
}
