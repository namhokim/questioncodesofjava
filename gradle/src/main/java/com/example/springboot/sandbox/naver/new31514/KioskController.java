package com.example.springboot.sandbox.naver.new31514;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class KioskController {

    @Autowired
    private CallInfoService callInfoService;

    @ResponseBody
    @RequestMapping(value = "/kiosk/callinfo", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = "application/json; utf-8")
    public JSONObject callinfo(@RequestBody Map<String, String> storeId) throws JSONException {

        List<CallVO> callVo = callInfoService.callInfo(storeId.get("S_NAME"));

        log.info("에스 네임은 뭐지?  " + storeId.get("S_NAME"));

        //int liveCallCount = callInfoService.liveCallCount(storeId.get("S_NAME"));

        log.info("콜에 담긴 정보들.... : " + callVo);
        log.info("살아있는 콜 수 .... : " + callVo.size());


        JSONObject obj = new JSONObject();

        try {
            JSONArray jArray = new JSONArray(); //배열이 필요할때

            for (int i = 0; i < callVo.size(); i++) {
                JSONObject sObject = new JSONObject();
                sObject.put("carNum", callVo.get(i).getCarNum());
                sObject.put("callStatus", callVo.get(i).getCCode());
                sObject.put("visitorPhone", callVo.get(i).getVisitorPhone());
                sObject.put("cIndex", callVo.get(i).getCIndex());
                jArray.put(sObject);
            }

            obj.put("count", callVo.size());
            obj.put("name", callVo.get(0).getSName());
            obj.put("list", jArray);

            System.out.println(obj.toString());

        } catch (JSONException e) {
            log.error("callinfo", e);
            throw e;
        }

        return obj;

    }
}
