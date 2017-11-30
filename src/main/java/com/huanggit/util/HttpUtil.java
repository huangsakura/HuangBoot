package com.huanggit.util;

import com.alibaba.fastjson.JSON;
import com.huanggit.general.dto.common.HttpResult;
import lombok.extern.slf4j.Slf4j;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 * Created by huang on 2017-11-29-0029.
 */
@Slf4j
public class HttpUtil {
    private HttpUtil(){}

    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36";
    private static final String ACCEPT = "text/html,application/xhtml+xml,application/xml,application/json";
    private static final String ACCEPT_LANGUAGE = "en-US,en,zh-CN,zh";
    private static final String CONTENT_TYPE = "application/x-www-form-urlencoded;charset=UTF-8;application/json";

    /**
     * http get
     * @param link
     * @return
     */
    public static HttpResult get(String link) {
        HttpResult httpResult = new HttpResult();
        try {
            URL url = new URL(link);
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            httpsURLConnection.setRequestMethod("GET");
            httpsURLConnection.setRequestProperty("User-Agent", USER_AGENT);
            httpsURLConnection.setRequestProperty("Accept", ACCEPT);
            httpsURLConnection.setRequestProperty("Accept-Language",ACCEPT_LANGUAGE);
            httpsURLConnection.setRequestProperty("content-type",CONTENT_TYPE);
            httpResult.setResponseCode(httpsURLConnection.getResponseCode());
            BufferedReader in = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
            String inputLine = null;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            httpResult.setResponseText(response.toString());
        } catch (MalformedURLException e) {
            log.error("请求{}报错MalformedURLException:{}",link,e.getMessage());
            httpResult.setErrorMessage(e.getMessage());
        } catch (IOException e) {
            log.error("请求{}报错IOException:{}",link,e.getMessage());
            httpResult.setErrorMessage(e.getMessage());
        } catch (Exception e) {
            log.error("请求{}报错Exception:{}",link,e.getMessage());
            httpResult.setErrorMessage(e.getMessage());
        }
        return httpResult;
    }

    /**
     * http post
     * @param link
     * @param paramMap
     * @return
     */
    public static HttpResult post(String link,Map<String,String> paramMap) {
        HttpResult httpResult = new HttpResult();
        try {
            URL url = new URL(link);
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection)url.openConnection();
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setRequestProperty("User-Agent", USER_AGENT);
            httpsURLConnection.setRequestProperty("Accept", ACCEPT);
            httpsURLConnection.setRequestProperty("Accept-Language",ACCEPT_LANGUAGE);
            httpsURLConnection.setRequestProperty("content-type",CONTENT_TYPE);

            httpsURLConnection.setDoOutput(true);
            DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
            StringBuffer stringBuffer = new StringBuffer();
            for (Map.Entry<String,String> entry : paramMap.entrySet()) {
                stringBuffer.append(entry.getKey() + "=" + entry.getValue() + "&");
            }
            dataOutputStream.writeBytes(stringBuffer.toString());
            dataOutputStream.flush();
            dataOutputStream.close();

            httpResult.setResponseCode(httpsURLConnection.getResponseCode());

            BufferedReader in = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
            String inputLine = null;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            httpResult.setResponseText(inputLine.toString());
        } catch (MalformedURLException e) {
            log.error("请求{}报错MalformedURLException:{}",link,e.getMessage());
            httpResult.setErrorMessage(e.getMessage());
        } catch (IOException e) {
            log.error("请求{}报错IOException:{}",link,e.getMessage());
            httpResult.setErrorMessage(e.getMessage());
        } catch (Exception e) {
            log.error("请求{}报错Exception:{}",link,e.getMessage());
            httpResult.setErrorMessage(e.getMessage());
        }
        return httpResult;
    }

    public static void main(String[] a) {
        System.out.println(JSON.toJSONString(HttpUtil.get("https://restcountries.eu/rest/v2/lang/zh")));
    }
}
