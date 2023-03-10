package org.example.api;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import org.example.bean.WorkInfo;
import org.example.bean.ProjectInfo;

import java.util.*;

public class ProjectTransform implements ObservableTransformer<List<WorkInfo>,List<WorkInfo>> {


    GitLabApi api;

    String token;
    public ProjectTransform(GitLabApi api,String token) {
        this.api = api;
        this.token=token;
    }

    @Override
    public ObservableSource<List<WorkInfo>> apply(Observable<List<WorkInfo>> upstream) {
     return    upstream
                .flatMap(list -> {
                    Set<Integer> projectIdSet=new HashSet<>();
                    for(WorkInfo eventInfo:list) {
                        projectIdSet.add(eventInfo.getProjectId());
                    }

                  return   Observable.fromIterable(projectIdSet)
                            .flatMap(this::getProjectInfo)
                            .toList()
                             .toObservable()
                            .map(projectInfos -> {
                                HashMap<Integer, ProjectInfo> map = new HashMap<>();
                                for(ProjectInfo info:projectInfos){
                                    map.put(info.getId(),info);
                                }
                                return map;
                            })
                            .map(map->{
                                for(WorkInfo eventInfo:list){
                                    eventInfo.setProjectInfo(map.get(eventInfo.getProjectId()));
                                }
                                return list;
                            });

                });



    }


    private Observable<ProjectInfo> getProjectInfo(int projectId) {
        return api.getProjectInfo(token,projectId);
    }
}
