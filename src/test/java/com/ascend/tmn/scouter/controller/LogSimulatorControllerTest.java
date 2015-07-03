package com.ascend.tmn.scouter.controller;

import com.ascend.tmn.scouter.service.LogServiceImpl;
import com.ascend.tmn.scouter.service.RobotCustomer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class LogSimulatorControllerTest extends Assert{

    @InjectMocks
    LogSimulatorController logSimulatorController;
    @Mock
    LogServiceImpl logServiceImplMock;
    @Mock
    RobotCustomer robotCustomer1;
    @Mock
    RobotCustomer robotCustomer2;

    @Test
    public void getAllLog__getViewAllLog__pageViewWasReturn(){
        when(logServiceImplMock.getAllLog()).thenReturn(new ArrayList());
        String result = logSimulatorController.getAllLog(new ModelMap());
        assertEquals("allLog", result);
    }

    @Test
    public void getAllLog__getLogList__logWasReturn(){
        ModelMap model = new ModelMap();
        List result = new ArrayList<String>();
        result.add("Log");
        when(logServiceImplMock.getAllLog()).thenReturn(result);
        logSimulatorController.getAllLog(model);
        assertEquals(result, model.get("logList"));
    }

    @Test
    public void getAllLog__seriveDown__errorPageWasReturn(){
        when(logServiceImplMock.getAllLog()).thenThrow(NullPointerException.class);
        String result = logSimulatorController.getAllLog(new ModelMap());
        assertEquals("error", result);


    }




}
