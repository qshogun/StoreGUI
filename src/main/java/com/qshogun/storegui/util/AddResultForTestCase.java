package com.qshogun.storegui.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AddResultForTestCase implements TestrailsCredentials {

        public static void addPass(String testCaseId) {
            try {
                APIClient client = new APIClient(RAILS_ENGINE_URL);
                client.setUser(TESTRAIL_USERNAME);
                client.setPassword(TESTRAIL_PASSWORD);
                Map data = new HashMap();
                data.put("status_id", TEST_CASE_PASSED_STATUS);
                data.put("comment", "Test Executed = Status updated automatically from Selenium test automation.");
                client.sendPost("add_result_for_case/"+TEST_RUN_ID+"/"+testCaseId+"", data);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (APIException e) {
                e.printStackTrace();
            }
        }

    public static void addFail(String testCaseId, String errorMessage) {
        try {
            APIClient client = new APIClient(RAILS_ENGINE_URL);
            client.setUser(TESTRAIL_USERNAME);
            client.setPassword(TESTRAIL_PASSWORD);
            Map data = new HashMap();
            data.put("status_id", TEST_CASE_FAILED_STATUS);
            data.put("comment", "Test Executed = Status updated automatically from Selenium test automation.");
            client.sendPost("add_result_for_case/"+TEST_RUN_ID+"/"+testCaseId+"", data);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (APIException e) {
            e.printStackTrace();
        }
    }

}
