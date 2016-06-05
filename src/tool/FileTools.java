package tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class FileTools {
    
    private final static String TAG = FileTools.class.getSimpleName();
    
    public static void readFile(List<String> data, String filePath) {
        if (data == null || Tools.isEmptyString(filePath)) {
            return;
        }
        
        File file = new File(filePath);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                if (!Tools.isEmptyString(tempString)) {
                    data.add(tempString);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println(TAG + ": 词库中未收录");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    System.out.println(e1);
                }
            }
        }
    }
    
    public static void write2File(List<String> textList, String path) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            
            FileOutputStream outputStream = new FileOutputStream(file, true);
            StringBuffer strBuffer = new StringBuffer();
            for (int i = 0; i < textList.size(); i++) {
                strBuffer.append(textList.get(i) + "\n");
            }
            strBuffer.append("\n");
            
            outputStream.write(strBuffer.toString().getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void write2SplitFile(Map<String, List<String>> data, String filePath) {
        Object[] cases = data.keySet().toArray();
        for (int i = 0; i < cases.length; i++) {
            try {
                File file = new File(filePath.replace("xxx", cases[i].toString()));
                if (!file.exists()) {
                    file.createNewFile();
                }
                
                FileOutputStream outputStream = new FileOutputStream(file, true);
                StringBuffer strBuffer = new StringBuffer();
                List<String> sameHeadList = data.get(cases[i]);
                for (int j = 0; j < sameHeadList.size(); j++) {
                    strBuffer.append(sameHeadList.get(j) + "\n");
                }
                
                outputStream.write(strBuffer.toString().getBytes());
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



