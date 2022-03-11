package com.BridgeLabz.employeePayRoll;
import java.io.File;
public class FilesUtils {
    public static boolean deleteFiles(File contentToDelete){
        File[]allContents=contentToDelete.listFiles();
        if(allContents!=null){
            for (File file:allContents){
                deleteFiles(file);
            }
        }
        return contentToDelete.delete();
    }

}
