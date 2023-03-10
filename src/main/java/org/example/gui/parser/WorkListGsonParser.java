package org.example.gui.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.api.QueryBean;
import org.example.bean.WorkInfo;

import java.util.List;

public class WorkListGsonParser implements IWorkListParser{
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public String getWorkListInfo(long useTime, QueryBean bean, List<WorkInfo> list) {

        String s = gson.toJson(list);

        return s;
    }
}
