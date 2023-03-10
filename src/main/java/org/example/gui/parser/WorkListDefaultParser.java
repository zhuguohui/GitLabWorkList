package org.example.gui.parser;

import org.example.api.QueryBean;
import org.example.bean.ProjectInfo;
import org.example.bean.WorkInfo;
import org.example.gui.parser.IWorkListParser;
import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkListDefaultParser implements IWorkListParser {

    public  String getWorkListInfo(long useTime, QueryBean bean, List<WorkInfo> list){
            return printInfo(useTime,bean.name,bean.startTime,bean.endTime,list);
    }

    private static String printInfo(long runTime,String name,String startTime,String endTime,List<WorkInfo> list){
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        PrintStream out=new PrintStream(outputStream);

        Map<ProjectInfo, Map<String, List<String>>> eventMap = getProjectInfoMap(list);
        printHeader(out,runTime,name,startTime,endTime);
        int projectIndex=1;
        for(ProjectInfo projectInfo:eventMap.keySet()) {
            Map<String, List<String>> branchMap = eventMap.get(projectInfo);

            for (String branchName : branchMap.keySet()) {
                out.println("----------------工作（"+projectIndex+"）---------------------");
                printBranch(out,projectInfo,branchName,branchMap.get(branchName));
                projectIndex++;
                out.println("\n");
            }

        }
        String s = outputStream.toString();
        try {
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return s;
    }

    @NotNull
    private static Map<ProjectInfo, Map<String, List<String>>> getProjectInfoMap(List<WorkInfo> eventInfoList) {
        Map<ProjectInfo, Map<String, List<String>>> eventMap=new HashMap<>();

        for(WorkInfo info:eventInfoList){
            ProjectInfo projectInfo = info.getProjectInfo();
            Map<String, List<String>> fzMap = eventMap.computeIfAbsent(projectInfo, projectInfo1 -> new HashMap<>());
            String ref = info.getPushData().getRef();
            String title = info.getPushData().getCommitTitle();
            List<String> list = fzMap.computeIfAbsent(ref, k -> new ArrayList<>());
            list.add(title);
        }
        return eventMap;
    }

    private static void printHeader(PrintStream out,long runTime,String name,String startTime,String endTime){
        out.println("---------------------------------------");
        out.println("生成成功，耗时"+runTime+"毫秒");
        out.println("开发者:"+name);
        out.println("时间:"+startTime+"-"+endTime);
        out.println("\n");
    }

    /**
     * 打印分支信息
     */
    private static void printBranch(PrintStream out,ProjectInfo projectInfo,String branchName,List<String> workList){


        out.println("项目:"+projectInfo.getName());
        out.println("项目描述:"+projectInfo.getDescription());
        out.println("分支:" + branchName);


        int i = 1;
        for (String str : workList) {
            if (str!=null&&str.contains("Merge remote-tracking branch")) {
                continue;
            }
            out.println(i + ":" + str);
            i++;
        }
    }
}
