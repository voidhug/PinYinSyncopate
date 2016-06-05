package tool;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tools {
    
    /**
     * 线程休眠
     *
     * @param millis
     *            休眠时间(毫秒)
     */
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 判断一个字符串是否为空字符串
     *
     * @param text
     *            待判断的字符串
     * @return 是否为空字符串
     */
    public static boolean isEmptyString(String text) {
        if (text == null || text.length() == 0) {
            return true;
        }
        
        return false;
    }
    
    /**
     * 获得匹配的字符串
     *
     * @param str
     *            待匹配的字符串
     * @param re
     *            匹配的正则表达式
     * @return 返回匹配结果
     */
    public static String getSub(String str, String re) {
        String name = "";
        Pattern pattern = Pattern.compile(re);
        Matcher match = pattern.matcher(str);
        if (match.find(0)) {
            name = match.group();
        }
        
        return name;
    }
    
    /**
     * 判断一段字符串中是否包含中文
     *
     * @param text
     *          待匹配的字符串
     * @return
     *          是否包含中文
     */
    public static boolean hasChinese(String text) {
        // 匹配的字符串的正则表达式
        String reg_charset = "[\u4e00-\u9fa5]*";
        
        Pattern p = Pattern.compile(reg_charset);
        Matcher m = p.matcher(text);
        
        while (m.find()) {
            if (m.group().length() > 0) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * 判断str是否匹配正则表达式re
     *
     * @param str
     *          待匹配的字符串
     * @param re
     *          匹配的正则表达式
     * @return
     *          匹配结果
     */
    public static boolean isSub(String str, String re) {
        Pattern pattern = Pattern.compile(re);
        Matcher match = pattern.matcher(str);
        if (match.find(0)) {
            return true;
        }
        
        return false;
    }
    
    public static List<String> getOptimalPrefixSub(List<String> labels, String sub) {
        if (labels == null || labels.size() == 0 || isEmptyString(sub)) {
            return null;
        }
        
        List<String> dataList = new ArrayList<String>();
        for (int i = 0; i < labels.size(); i++) {
            if (labels.get(i).startsWith(sub)) {
                dataList.add(labels.get(i));
            }
        }
        
        return dataList;
    }
}
