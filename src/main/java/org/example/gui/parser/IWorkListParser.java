package org.example.gui.parser;

import org.example.api.QueryBean;
import org.example.bean.WorkInfo;

import java.util.List;

public interface IWorkListParser {

      String getWorkListInfo(long useTime, QueryBean bean, List<WorkInfo> list);
}
