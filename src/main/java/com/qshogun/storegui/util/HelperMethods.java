package com.qshogun.storegui.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelperMethods {
    public static String getTestCaseId(String testCaseName) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(testCaseName);
        String testCaseId = matcher.toString();
        return testCaseId;
    }
}
