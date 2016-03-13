package com.csy.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public abstract class FileUtils
{

    public FileUtils()
    {
    }

    public static boolean exists(String filePath)
    {
        File file = new File(filePath);
        return file.exists() && file.isFile();
    }
    
    public static String read(String filePath, String charset)
    {
        return read(filePath, charset, SYS_LINE_SEPARATOR);
    }
    
    public static boolean create(String sFilePath, String sText)
    {
        PrintWriter printWriter = null;
        try
        {
            printWriter = new PrintWriter(new FileOutputStream(sFilePath));
            printWriter.print(sText);
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
        if(printWriter != null)
            printWriter.close();
        
        return true;
    }
    

    public static String read(String filePath, String charset, String lineSeparator)
    {
        BufferedReader bufferedReader;
        StringBuilder stringBuilder;
        InputStreamReader streamReader = null;
        bufferedReader = null;
        stringBuilder = new StringBuilder();
        try
        {
            streamReader = new InputStreamReader(new FileInputStream(filePath), charset);
            bufferedReader = new BufferedReader(streamReader);
            String text;
            while((text = bufferedReader.readLine()) != null) 
            {
                stringBuilder.append(text);
                if(!StringUtils.isTrimEmpty(lineSeparator))
                    stringBuilder.append(lineSeparator);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        try
        {
            if(bufferedReader != null)
                bufferedReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static boolean delete(String filePath)
    {
        File file = new File(filePath);
        if(file.isFile() && file.exists())
            return file.delete();
        else
            return false;
    }

    public static boolean rename(String fromFile, String toFile)
    {
        File fFile = new File(fromFile);
        File tFile = new File(toFile);
        if(fFile.exists() && fFile.isFile() && !tFile.exists() && !tFile.isDirectory())
            return fFile.renameTo(tFile);
        else
            return false;
    }

    public static boolean move(String fromFile, String toFile)
    {
        File fFile = new File(fromFile);
        File tFile = new File(toFile);
        if(fFile.exists() && fFile.isFile())
        {
            if(tFile.exists() && tFile.isFile() && tFile.delete())
                return fFile.renameTo(tFile);
            else
                return fFile.renameTo(tFile);
        } else
        {
            return false;
        }
    }

    public static final String SYS_LINE_SEPARATOR = System.getProperty("line.separator");
}
