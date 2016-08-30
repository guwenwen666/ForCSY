package com.csy.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
    
    /**
     * @author wangqiang
     * @date 2016-8-30 14:56:00
     * @param in		输入流
     * @param fileUri	文件存储路径
     * @param fileName	保存文件名称
     * @return 
     * @description
     * 		 文件保存类
     */
    public static boolean saveFile(InputStream in, String filePath , String fileName){
    	//路径不存在，则创建目录 
		if(!FolderUtils.exists(filePath)){
			FolderUtils.mkdirs(filePath);
		}
		FileOutputStream out;
		try {
			out = new FileOutputStream(filePath+File.separator+fileName);
			//创建一个缓冲区
			byte buffer[] = new byte[1024];
			//判断输入流中的数据是否已经读完的标识
			int len = 0;
			//循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
			while((len=in.read(buffer))>0){
				//使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
				out.write(buffer, 0, len);
			}
			//关闭输入流
			in.close();
			//关闭输出流
			out.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
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
    
    public static boolean delete(String folderPath, String fileName){
    	String filePath = folderPath + File.separator + fileName;
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
